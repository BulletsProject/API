package logic;

import java.io.IOException;
import java.util.Date;
import java.util.StringTokenizer;

import logic.exceptions.IncorrectFacebookId;
import models.Author;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.json.JSONObject;

import com.restfb.DefaultFacebookClient;
import com.restfb.DefaultWebRequestor;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.WebRequestor;
import com.restfb.types.User;


public class ShortLogic {

	public static final String FB_APP_ID = "221667328027556";
    public static final String FB_SECRET_KEY = "9eb42081e278a7babe4d152fa06f17ae";	
	
	private AccessToken getFacebookUserToken(String code, String redirectUrl) throws IOException {

	    WebRequestor wr = new DefaultWebRequestor();
	    WebRequestor.Response accessTokenResponse = wr.executeGet(
	            "https://graph.facebook.com/oauth/access_token?client_id=" + FB_APP_ID + "&redirect_uri=" + redirectUrl
	            + "&client_secret=" + FB_SECRET_KEY + "&code=" + code);

	    return DefaultFacebookClient.AccessToken.fromQueryString(accessTokenResponse.getBody());
	}	
	
	public Author validateFacebookUser(String signedRequest) 
	throws IncorrectFacebookId {

		try {
			String payload = null;
			StringTokenizer st = new StringTokenizer(signedRequest, ".");
	
			boolean first = false;
			while (st.hasMoreTokens()) {
				if (first) {
					payload = st.nextToken();
					break;
				}
	
				st.nextToken();
				first = true;
			}
	
			payload = payload.replace("-", "+").replace("-", "/").trim();
			payload = StringUtils.newStringUtf8(Base64.decodeBase64(payload));
			JSONObject payloadObject = new JSONObject(payload);
	
			String facebookId = payloadObject.getString("user_id");
			String code = payloadObject.getString("code");
	
			FacebookClient.AccessToken accessToken = getFacebookUserToken(code, "");
			
			FacebookClient facebookClient = new DefaultFacebookClient(accessToken.getAccessToken());
			User user = facebookClient.fetchObject("me", User.class);
			
			Author author = new Author();
			
			author.email = user.getEmail();
			author.firstName = user.getFirstName();
			author.lastName = user.getLastName();
			author.facebookId = user.getId();
			author.created = new Date();
			
			return author;
		}
		catch(Exception ex) {
			throw new IncorrectFacebookId();
		}
	}	
	
}
