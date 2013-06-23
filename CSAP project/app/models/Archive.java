package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;


@Entity
public class Archive extends Model {
	@Id
	 public String title;
	 public String description;
	 public static Finder<String, Archive> find = new Finder<String, Archive>(
				String.class, Archive.class);

	 
}