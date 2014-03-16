package logic.exceptions;

public class CategoryNotExists extends LogicException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8639894526654135465L;

	@Override
	public String getExceptionMessage() {
		return "Category not exists";
	}
	
}
