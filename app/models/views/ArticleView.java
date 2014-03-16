package models.views;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import models.ArticleOgField;
import play.db.ebean.Model;

@Entity
@Table(name="articles_view")
public class ArticleView extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6950635569417880317L;

	@Id
	@Column(name="pkid")
	public Long pkid;
	
	@Column(name="url")
	public String url;
	
	@Column(name="url_hash")
	public String urlHash;
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date created;

	@Column(name="time_difference")
	public Float timeDifference;	

	@Column(name="factor")
	public Float factor;		
	
	@OneToMany(mappedBy="article")
	public List<ArticleOgField> ogfields;
	
	@OneToMany(mappedBy="article")
	public List<ShortView> shorts;	
	
	@Column(name="likes_amount")
	public Long likesCount;
	
	public static Finder<Long, ArticleView> find = new Finder<Long, ArticleView> (Long.class, ArticleView.class);
	
}
