package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.db.ebean.Model;

@Entity
@Table(name="article_ogfields")
public class ArticleOgField extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4725813896543761625L;

	@Id
	public Long pkid;

	@ManyToOne
	@JoinColumn(name="parentid")
	public ArticleOgField parent;
	
	@ManyToOne
	@JoinColumn(name="articleid")
	public Article article;
	
	@ManyToOne
	@JoinColumn(name="ogfieldid")
	public OgField ogfield;
	
	@Column(name="value")
	public String value;
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date created;
	
	public static Finder<Long, ArticleOgField> find = new Finder<Long, ArticleOgField> (Long.class, ArticleOgField.class);
	
}
