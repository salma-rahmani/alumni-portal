package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;


@Entity
public class Contact extends Model {
	@Id
	 public String email;
	 public String message;
	 public static Finder<String, Contact> find = new Finder<String, Contact>(
				String.class, Contact.class);

	 
}