package logic.dto.response.opengraph;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Video {

	@JsonProperty(value = "og_video_url", required = false)
	private String url;
	
	@JsonProperty(value = "og_video_secure_url", required = false)
	private String secureUrl;
	
	@JsonProperty(value = "og_video_type", required = false)
	private String type;
	
	@JsonProperty(value = "og_video_width", required = false)
	private Integer width;
	
	@JsonProperty(value = "og_video_height", required = false)
	private Integer height;
	
}
