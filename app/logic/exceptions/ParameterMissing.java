package logic.exceptions;

public class ParameterMissing extends ValidationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8401903826235857929L;

	private String parameter;
	
	public ParameterMissing(String name) {
		parameter = name;
	}
	
	@Override
	public String getExceptionMessage() {
		return "Missing parameter: " + parameter;
	}
	
	
}
