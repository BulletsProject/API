package logic.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArticlesResponse extends Response {

	@JsonProperty("articles")
	private List<ArticleResponse> articles;

	public List<ArticleResponse> getArticles() {
		return articles;
	}

	public void setArticles(List<ArticleResponse> articles) {
		this.articles = articles;
	}	
	
	
}
