package logic.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShortPostResponse extends Response {

	@JsonProperty("id")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
	
	
	
}
