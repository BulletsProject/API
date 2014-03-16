package logic.dto.response;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import logic.common.Tools;
import logic.dto.response.opengraph.Image;
import models.ArticleOgField;
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
		
		List<ArticleShort> shorts = new LinkedList<ArticleShort>();
		for(ShortView shortElem : article.shorts) {
			shorts.add(new ArticleShort(shortElem));
		}
		
		Collections.sort(shorts, new Comparator<ArticleShort> () {
			@Override
			public int compare(ArticleShort first, ArticleShort second) {
				long result = first.getLikesCount() - second.getLikesCount();
				if (result < 0) return -1;
				if (result > 0) return 1;
				return 0;
			}
		});
		
		shortsBest = shorts.toArray(new ArticleShort[] {});
		
		ArticleOgField articleOgField = ArticleOgField.find
				.where()
				.eq("article.pkid", article.pkid)
				.eq("ogfield.pkid", 1)
				.findUnique();
		
		if (articleOgField != null) {
		
			Image[] images = new Image[1];
			Image image = new Image();
			image.setUrl(articleOgField.value);
			images[0] = image;
			
			openGraph = new OpenGraph();
			openGraph.setImage(images);
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
