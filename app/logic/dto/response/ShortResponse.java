package logic.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author piotr.kosiakowski
 *
 */
public class ShortResponse extends Response {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("user_id")
	private Long userId;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("likes_count")
	private Long likesCount;
	
	@JsonProperty("bullets")
	private String[] bullets;
	
	@JsonProperty("article")
	private ArticleResponse article;
	
	@JsonProperty("author")
	private AuthorResponse author;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public ArticleResponse getArticle() {
		return article;
	}

	public void setArticle(ArticleResponse article) {
		this.article = article;
	}

	public AuthorResponse getAuthor() {
		return author;
	}

	public void setAuthor(AuthorResponse author) {
		this.author = author;
	}
	
}
