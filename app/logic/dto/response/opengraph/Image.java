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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSecureUrl() {
		return secureUrl;
	}

	public void setSecureUrl(String secureUrl) {
		this.secureUrl = secureUrl;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public boolean isUserGenerated() {
		return userGenerated;
	}

	public void setUserGenerated(boolean userGenerated) {
		this.userGenerated = userGenerated;
	}
	
}
