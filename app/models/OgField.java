package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.db.ebean.Model;

@Entity
@Table(name="ogfields")
public class OgField extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8966261629216042046L;

	@Id
	@Column(name="pkid")
	public Long pkid;
	
	@ManyToOne
	@JoinColumn(name="parentid")
	public OgField parent;
	
	@Column(name="name")
	public String name;
	
	public static Finder<Long, OgField> find = new Finder<Long, OgField> (Long.class, OgField.class);
	
}
