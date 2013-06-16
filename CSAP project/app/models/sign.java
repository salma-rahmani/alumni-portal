package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class sign extends Model {
	@Id
	public String email;
	public String password;
	

	public static Finder<String, Student> find = new Finder<String, Student>(
			String.class, Student.class);

}
