package models;

public class Key {
	
	public String username;
	public String password;
	
	public String validate() {
        if(UserStorage.authenticate(username, password) == null) {
            return "Invalid user or password";
        }
        return null;
    }

}
