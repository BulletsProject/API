package models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.db.ebean.Model;

@Entity
@Table(name="articles")
public class Article extends Model {

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
	
	@Column(name="title")
	public String title;	
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date created;
	
	@OneToMany(mappedBy="article", cascade = {CascadeType.PERSIST})
	public List<ArticleOgField> ogfields;
	
	@OneToMany(mappedBy="article")
	public List<Short> shorts;	
	
	public static Finder<Long, Article> find = new Finder<Long, Article> (Long.class, Article.class);
	
}
