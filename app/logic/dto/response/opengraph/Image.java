package logic.dto.response.opengraph;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Image {

	@JsonProperty(value = "og_image_url", required = false)
	private String url;
	
	@JsonProperty(value = "og_image_secure_url", required = false)
	private String secureUrl;
	
	@JsonProperty(value = "og_image_type", required = false)
	private String type;
	
	@JsonProperty(value = "og_image_width", required = false)
	private Integer width;
	
	@JsonProperty(value = "og_image_height", required = false)
	private Integer height;
	
	@JsonProperty(value = "og_image_user_generated", required = false)
	private boolean userGenerated;
	
}
