package logic;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.StringTokenizer;

import logic.common.OpenGraphData;
import logic.exceptions.IncorrectFacebookId;
import models.Article;
import models.ArticleOgField;
import models.Author;
import models.OgField;
import models.cached.OpenGraphDictionary;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.json.JSONObject;

import play.Play;

import com.restfb.DefaultFacebookClient;
import com.restfb.DefaultWebRequestor;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.WebRequestor;
import com.restfb.types.User;

/**
 * 
 * @author piotr.kosiakowski
 *
 */
public class ShortLogic {

	private AccessToken getFacebookUserToken(String code, String redirectUrl) throws IOException {

		String appId = Play.application().configuration().getString("facebook.appId");
		String secretKey = Play.application().configuration().getString("facebook.secretKey");
		
	    WebRequestor wr = new DefaultWebRequestor();
	    WebRequestor.Response accessTokenResponse = wr.executeGet(
	            "https://graph.facebook.com/oauth/access_token?client_id=" + appId + "&redirect_uri=" + redirectUrl
	            + "&client_secret=" + secretKey + "&code=" + code);

	    return DefaultFacebookClient.AccessToken.fromQueryString(accessTokenResponse.getBody());
	}	
	

	public void processOpenGraph(Article article) throws Exception {
		
		OpenGraphData openGraphData = new OpenGraphData(article.url);
		openGraphData.process();

		article.title = openGraphData.getPageTitle();
		article.ogfields = new LinkedList<>();
		
		ArticleOgField ogField = new ArticleOgField();
		ogField.article = article;
		ogField.ogfield = OgField.find.byId(OpenGraphDictionary.OG_IMAGE);
		ogField.value = openGraphData.getOgImage();
		ogField.created = new Date();
		
		article.ogfields.add(ogField);
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
