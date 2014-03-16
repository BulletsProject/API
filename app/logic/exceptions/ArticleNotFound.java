package logic.exceptions;

public class ArticleNotFound extends LogicException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8576864074304628279L;

	@Override
	public String getExceptionMessage() {
		return "Article not found";
	}
	
}
