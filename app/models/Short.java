package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.db.ebean.Model;

@Entity
@Table(name="shorts")
public class Short extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9026808260418322375L;
	
	@Id
	@Column(name="pkid")
	public Long pkid;
	
	@ManyToOne
	@JoinColumn(name="authorid")
	public Author author;
	
	@ManyToOne
	@JoinColumn(name="articleid")
	public Article article;
	
	@ManyToOne
	@JoinColumn(name="categoryid")
	public Category category;	
	
	@Column(name="title")
	public String title;
	
	@Column(name="bullet1")
	public String bullet1;
	
	@Column(name="bullet2")
	public String bullet2;
	
	@Column(name="bullet3")
	public String bullet3;
	
	@Column(name="bullet4")
	public String bullet4;
	
	@Column(name="bullet5")
	public String bullet5;
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date created;
	
	@OneToMany(mappedBy="shortElement")
	public List<Like> likes;
	
	public static Finder<Long, Short> find = new Finder<Long, Short> (Long.class, Short.class);

}
