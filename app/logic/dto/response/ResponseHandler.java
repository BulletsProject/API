package logic.dto.response;

import logic.dto.response.Response.ResponseStatus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ResponseHandler<T extends Response> {

	private T element;
	
	public ResponseHandler(T element) {
		this.element = element;
	}
	
	public String prepareResponse() throws JsonProcessingException {
		element.setStatus(ResponseStatus.OK);
			
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure( SerializationFeature.FAIL_ON_EMPTY_BEANS, false );
		return mapper.writeValueAsString(element);
	}
}