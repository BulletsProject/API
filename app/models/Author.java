package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.db.ebean.Model;

@Entity
@Table(name="authors")
public class Author extends Model {

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
	
	@OneToMany(mappedBy="author")
	public List<Short> shorts;		
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date created;
	
	public static Finder<Long, Author> find = new Finder<Long, Author> (
			Long.class, Author.class);
	
}
