package models;



import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;


@Entity
public class Apply extends Model {
	@Id
	 public String name;
	 public String email;
	 public int    id;
	 public int    graduationyear;
	 public String job;
	 public static Finder<String, Apply> find = new Finder<String, Apply>(
				String.class, Apply.class);

	 
}