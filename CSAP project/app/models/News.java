package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;


@Entity
public class News extends Model {
	@Id
	 public String title;
	 public String description;
	 public static Finder<String, News> find = new Finder<String, News>(
				String.class, News.class);

	 
}