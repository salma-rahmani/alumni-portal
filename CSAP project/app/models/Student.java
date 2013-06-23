package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

/**
 * User entity managed by Ebean
 */
@Entity 
@Table(name="Student")
public class Student extends Model {

//    @Id
//    @Constraints.Required
//    @Formats.NonEmpty
//    public String username;
//    @Constraints.Required
//    public String password;
//    
//    @Constraints.Required
//    public String retypedPassword;
//    
//    @Constraints.Required
//    public String job;
	
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
    
    
    
    // -- Queries
    
    public static Model.Finder<String,Student> find = new Model.Finder(String.class, Student.class);
    
    /**
     * Retrieve all users.
     */
    public static List<Student> findAll() {
        return find.all();
    }

    /**
     * Retrieve a User from email.
     */
    public static Student findByEmail(String email) {
        return find.where().eq("email", email).findUnique();
    }
    
    /**
     * Authenticate a User.
     */
    public static Student authenticate(String email, String password) {
        return find.where()
            .eq("email", email)
            .eq("password", password)
            .findUnique();
    }
    
    // --
    
//    public String toString() {
//        return "User(" + email + ")";
//    }

}

