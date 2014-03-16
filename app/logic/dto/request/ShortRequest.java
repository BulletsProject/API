package logic.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShortRequest {

	@JsonProperty("article_url")
	private String articleUrl;
	
	@JsonProperty("title")
	private String title;

	@JsonProperty("category_id")
	private Integer categoryId;	
	
	@JsonProperty("bullets")
	private String[] bullets;

	public String getArticleUrl() {
		return articleUrl;
	}

	public void setArticleUrl(String articleUrl) {
		this.articleUrl = articleUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String[] getBullets() {
		return bullets;
	}

	public void setBullets(String[] bullets) {
		this.bullets = bullets;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
}
