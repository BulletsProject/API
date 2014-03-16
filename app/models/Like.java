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
@Table(name="likes")
public class Like extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1098007989335614020L;

	@Id
	@Column(name="pkid")
	public Long pkid;
	
	@ManyToOne
	@JoinColumn(name="shortid")
	public Short shortElement;
	
	@Column(name="device_id")
	public String deviceId;
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date created;
	
	public static Finder<Long, Like> find = new Finder<Long, Like> (Long.class, Like.class);
	
}
