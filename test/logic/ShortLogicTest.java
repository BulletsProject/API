package logic;

import models.Article;
import models.Author;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class ShortLogicTest {

	@Test
	@Ignore
	public void test() {
		ShortLogic logic = new ShortLogic();
		
		String signedRequest = "Secret";
		
		try {
			Author author = logic.validateFacebookUser(signedRequest);
			Assert.assertEquals(author.facebookId, "Secret");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	
	@Test
	public void testOpenGraph() {
		ShortLogic logic = new ShortLogic();
		
		String value = null;
		try {
			Article article = new Article();
			article.url = "http://socializer.pl";
			logic.processOpenGraph(article);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
		
		Assert.assertEquals("Socializer - najskuteczniejsze reklamy na Facebooku i w social media", value);
	}
	
}
