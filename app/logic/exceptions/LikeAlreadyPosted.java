package logic.exceptions;

public class LikeAlreadyPosted extends LogicException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5505155755509541164L;

	@Override
	public String getExceptionMessage() {
		return "Like already posted";
	}
	
}
