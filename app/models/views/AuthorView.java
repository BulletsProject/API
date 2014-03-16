package models.views;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.db.ebean.Model;

@Entity
@Table(name="authors_view")
public class AuthorView extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7073529736340302284L;

	@Id
	@Column(name="pkid")
	public Long pkid;
	
	@Column(name="facebook_id")
	public String facebookId;
	
	@Column(name="first_name")
	public String firstName;
	
	@Column(name="last_name")
	public String lastName;
	
	@Column(name="email")
	public String email;
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date created;
	
	@Column(name="likes_amount")
	public Long likesCount;	
	
	@Column(name="shorts_amount")
	public Long shortsCount;		

	@Column(name="articles_amount")
	public Long articlesCount;	
	
	public static Finder<Long, AuthorView> find = new Finder<Long, AuthorView> (
			Long.class, AuthorView.class);
	
}
