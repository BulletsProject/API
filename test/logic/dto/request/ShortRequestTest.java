package logic.dto.request;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ShortRequestTest {

	@Test
	public void shouldBeCorrectlyParsedTest() {
		
		String JSON = "{\"article_url\": \"http://www.wikipedia.pl\", "
				      + "\"title\": \"Simple title\", "
				      + "\"bullets\": [\"First line\", \"Second line\"]}";		
		
		ObjectMapper objectMapper = new ObjectMapper();
		ShortRequest shortRequest = null;
		try {
			shortRequest = objectMapper.readValue(JSON, ShortRequest.class);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			Assert.assertTrue(false);
		}
        
		Assert.assertNotNull(shortRequest);		
		
	}

}
