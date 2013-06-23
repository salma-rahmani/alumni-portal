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
@Table(name="UserStorage")
public class UserStorage extends Model {

    @Id
    @Constraints.Required
    @Formats.NonEmpty
    public String username;
    @Constraints.Required
    public String password;
    
    @Constraints.Required
    public String retypedPassword;
    
    @Constraints.Required
    public String job;
    
    
    
    // -- Queries
    
    public static Model.Finder<String,UserStorage> find = new Model.Finder(String.class, UserStorage.class);
    
    /**
     * Retrieve all users.
     */
    public static List<UserStorage> findAll() {
        return find.all();
    }

    /**
     * Retrieve a User from email.
     */
    public static UserStorage findByEmail(String username) {
        return find.where().eq("username", username).findUnique();
    }
    
    /**
     * Authenticate a User.
     */
    public static UserStorage authenticate(String username, String password) {
        return find.where()
            .eq("username", username)
            .eq("password", password)
            .findUnique();
    }
    
    // --
    
    public String toString() {
        return "User(" + username + ")";
    }

}

