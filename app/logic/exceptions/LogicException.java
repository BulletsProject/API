package logic.exceptions;

/**
 * 
 * @author piotr.kosiakowski
 *
 */
abstract public class LogicException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1527098538570268702L;

	abstract public String getExceptionMessage();
	
}
