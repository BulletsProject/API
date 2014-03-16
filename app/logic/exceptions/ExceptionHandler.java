package logic.exceptions;

import logic.dto.response.Response;
import logic.dto.response.Response.ResponseStatus;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * 
 * @author piotr.kosiakowski
 *
 * @param <T>
 */
public class ExceptionHandler<T extends Response> {

	private T element;
	private LogicException ex;
	
	public ExceptionHandler(LogicException ex, T element) {
		this.ex = ex;
		this.element = element;
	}
	
	public String prepareResponse() {
		try {
			element.setStatus(ResponseStatus.ERROR);
			element.setMessage(ex.getExceptionMessage());
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure( SerializationFeature.FAIL_ON_EMPTY_BEANS, false );
			mapper.setSerializationInclusion(Include.NON_NULL);
			return mapper.writeValueAsString(element);
		}
		catch(Exception ex) {
			return null;
		}
	}
}
