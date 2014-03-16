package logic.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author piotr.kosiakowski
 *
 */
abstract public class Response {

	public enum ResponseStatus { OK("OK"), ERROR("ERROR");
	
		private final String value;
		
		ResponseStatus(String value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return value;
		}
	};
	
	@JsonProperty(value = "response_status", required = false)
	protected ResponseStatus status;
	
	@JsonProperty(value = "response_message", required = false)
	protected String message;

	public ResponseStatus getStatus() {
		return status;
	}

	public void setStatus(ResponseStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
