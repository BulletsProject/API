package logic;

import models.Author;

import org.junit.Assert;
import org.junit.Test;

public class ShortLogicTest {

	@Test
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
	
}
