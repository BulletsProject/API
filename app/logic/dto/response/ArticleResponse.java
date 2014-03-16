package logic.dto.response;

import logic.common.Tools;
import models.views.ArticleView;
import models.views.ShortView;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author piotr.kosiakowski
 *
 */
public class ArticleResponse extends Response {

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("url")
	private String url;
	
	@JsonProperty("likes_count")
	private Long likesCount;
	
	@JsonProperty("created")
	private Long created;
	
	@JsonProperty("opengraph")
	private OpenGraph openGraph;
	
	@JsonProperty("shorts_count")
	private Long shortsCount;
	
	@JsonProperty("shorts_best")
	private ArticleShort[] shortsBest;

	public ArticleResponse() {}
	
	public ArticleResponse(ArticleView article) {
		if (article == null) return;
		
		id = article.pkid;
		url = article.url;
		likesCount = article.likesCount;
		created = Tools.unixTimeStamp(article.created);
		shortsCount = (long)article.shorts.size();
		shortsBest = new ArticleShort[article.shorts.size()];
		
		int count = 0;
		for(ShortView shortElem : article.shorts) {
			shortsBest[count++] = new ArticleShort(shortElem);
		}
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getLikesCount() {
		return likesCount;
	}

	public void setLikesCount(Long likesCount) {
		this.likesCount = likesCount;
	}

	public Long getCreated() {
		return created;
	}

	public void setCreated(Long created) {
		this.created = created;
	}

	public OpenGraph getOpenGraph() {
		return openGraph;
	}

	public void setOpenGraph(OpenGraph openGraph) {
		this.openGraph = openGraph;
	}

	public Long getShortsCount() {
		return shortsCount;
	}

	public void setShortsCount(Long shortsCount) {
		this.shortsCount = shortsCount;
	}

	public ArticleShort[] getShortsBest() {
		return shortsBest;
	}

	public void setShortsBest(ArticleShort[] shortsBest) {
		this.shortsBest = shortsBest;
	}

}
