package logic.exceptions;

public class ShortAlreadyPosted extends LogicException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1145656613895422173L;

	@Override
	public String getExceptionMessage() {
		return "This author already posted short for this article";
	}


}
