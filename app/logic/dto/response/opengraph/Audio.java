package logic.dto.response.opengraph;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Audio {

	@JsonProperty(value = "og_audio_url", required = false)
	private String url;
	
	@JsonProperty(value = "og_audio_secure_url", required = false)
	private String secureUrl;
	
	@JsonProperty(value = "og_audio_type", required = false)
	private String type;
	
}
