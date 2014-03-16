package logic.dto.response.opengraph.restrictions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Country {

	
	@JsonProperty(value = "og_restrictions_country_allowed", required = false)
	private String[] allowed;
	
	@JsonProperty(value = "og_restrictions_country_diallowed", required = false)
	private String[] disallowed;
	
}
