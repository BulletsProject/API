package logic.exceptions;

public class ValidationException extends LogicException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3257783106773524561L;

	@Override
	public String getExceptionMessage() {
		return "Input parameters are invalid";
	}

	
		
}
