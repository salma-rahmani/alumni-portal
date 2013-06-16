package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;


@Entity
public class Student extends Model {
	@Id
	 public int id;
	 public String name;
	 public String pic;
	 public String lastname;
	 public String fathername;
	 public String email;
	 public int cn;
	 public int ecn;
	 public String password;
	 public String passwordconf;
	 public String current;
	 public String main;
   

	public static Finder<String, Student> find = new Finder<String, Student>(
			String.class, Student.class);

}
