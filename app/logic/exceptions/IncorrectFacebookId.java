package logic.exceptions;

public class IncorrectFacebookId extends LogicException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -742681530615416790L;

	@Override
	public String getExceptionMessage() {
		return "Facebook identifier is incorrect";
	}

	
	
}
