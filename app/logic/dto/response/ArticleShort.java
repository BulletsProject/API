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
	
}
