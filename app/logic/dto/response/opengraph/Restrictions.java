package logic.dto.response.opengraph;

import com.fasterxml.jackson.annotation.JsonProperty;

import logic.dto.response.opengraph.restrictions.Country;

public class Restrictions {

	@JsonProperty(value = "og_restrictions_country", required = false)
	private Country country;
	
	@JsonProperty(value = "og_restrictions_age", required = false)
	private String age;
	
	@JsonProperty(value = "og_restrictions_content", required = false)
	private String[] content;
	
	
}
