package logic.dto.response;

import logic.common.Tools;
import models.views.AuthorView;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author piotr.kosiakowski
 *
 */
public class AuthorResponse extends Response {

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("facebook_id")
	private String facebookId;	
	
	@JsonProperty("first_name")
	private String firstName;
	
	@JsonProperty("last_name")
	private String lastName;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("created")
	private Long created;
	
	@JsonProperty("shorts_count")
	private Long shortsCount;
	
	@JsonProperty("articles_count")
	private Long articlesCount;
	
	@JsonProperty("likes_count")
	private Long likesCount;
	
	public AuthorResponse() {}
	
	public AuthorResponse(AuthorView authorElem) {
		id = authorElem.pkid;
		facebookId = authorElem.facebookId;
		firstName = authorElem.firstName;
		lastName = authorElem.lastName;
		email = authorElem.email;
		created = Tools.unixTimeStamp(authorElem.created);
		shortsCount = authorElem.shortsCount;
		articlesCount = authorElem.articlesCount;
		likesCount = authorElem.likesCount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCreated() {
		return created;
	}

	public void setCreated(Long created) {
		this.created = created;
	}

	public Long getShortsCount() {
		return shortsCount;
	}

	public void setShortsCount(Long shortsCount) {
		this.shortsCount = shortsCount;
	}

	public Long getArticlesCount() {
		return articlesCount;
	}

	public void setArticlesCount(Long articlesCount) {
		this.articlesCount = articlesCount;
	}

	public Long getLikesCount() {
		return likesCount;
	}

	public void setLikesCount(Long likesCount) {
		this.likesCount = likesCount;
	}

}
