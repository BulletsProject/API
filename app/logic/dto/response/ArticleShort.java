package logic.dto.response;

import models.views.ShortView;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArticleShort {

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("user_id")
	private Long userId;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("likes_count")
	private Long likesCount;
	
	@JsonProperty("bullets")
	private String[] bullets;
	
	@JsonProperty("author")
	private AuthorResponse author;	
	
	public ArticleShort() {}
	
	public ArticleShort(ShortView shortView) {
		id = shortView.pkid;
		userId = shortView.author.pkid;
		title = shortView.title;
		likesCount = shortView.likesCount;
		bullets = new String[] {shortView.bullet1, shortView.bullet2, shortView.bullet3, shortView.bullet4, shortView.bullet5 };
		author = new AuthorResponse(shortView.author);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getLikesCount() {
		return likesCount;
	}

	public void setLikesCount(Long likesCount) {
		this.likesCount = likesCount;
	}

	public String[] getBullets() {
		return bullets;
	}

	public void setBullets(String[] bullets) {
		this.bullets = bullets;
	}

	public AuthorResponse getAuthor() {
		return author;
	}

	public void setAuthor(AuthorResponse author) {
		this.author = author;
	}
	
}
