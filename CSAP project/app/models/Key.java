package models;

public class Key {
	
	public String email;
	public String password;;
	
	public String validate() {
        if(Student.authenticate(email, password) == null) {
            return "Invalid user or password";
        }
        return null;
    }

}
