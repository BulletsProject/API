package logic.exceptions;

public class ShortNotFound extends LogicException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5816171067640642865L;

	@Override
	public String getExceptionMessage() {
		return "Short not exists";
	}

}
