package logic.dto.request;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class RequestHandler<T> {

	private Class<?> classValue;
	
	public RequestHandler(Class<?> classValue) {
		this.classValue = classValue;
	}
	
	@SuppressWarnings("unchecked")
	public T parseRequest(String request) throws IOException {
			
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure( SerializationFeature.FAIL_ON_EMPTY_BEANS, false );
		return (T)mapper.readValue(request, classValue);
	}
}