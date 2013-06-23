package models;



import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;


@Entity
public class Apply extends Model {
	@Id
	 
	 public String email;
	 public String    name;
	 public int    graduationyear;
	 public String job;
	 public static Finder<String, Apply> find = new Finder<String, Apply>(
				String.class, Apply.class);

	 	
}