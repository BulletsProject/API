package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import play.db.ebean.Model;

@Entity
@Table(name="categories")
public class Category extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6950635569417880317L;

	@Id
	@Column(name="pkid")
	public Long pkid;
	
	@Column(name="name")
	public String name;
	
	@OneToMany(mappedBy="category")
	public List<Short> shorts;		
	
	public static Finder<Long, Category> find = new Finder<Long, Category> (Long.class, Category.class);
	
}