package controllers;

import static play.data.Form.form;

import java.util.List;

//import models.CategoryStorage;
import models.Key;
import models.Student;
import models.sign;

import play.data.Form;
import play.mvc.*;
import views.html.*;


public class KeyChecker extends Controller {
	public static Student student;

	// -- Authentication



	/**
	 * Login page.
	 */
	public static Result login() {
		return ok(login.render(form(Key.class)));
	}

	/**
	 * Handle login form submission.
	 */
	public static Result authenticate() {
		Form<Key> loginForm = form(Key.class).bindFromRequest();
		if (loginForm.hasErrors()) {
			return badRequest(login.render(loginForm));
		} else if(loginForm.get().email.equals("monira_srt@yahoo.com")) {
			Key find = loginForm.get();
			session("email", loginForm.get().email);
			return ok(adminSigned.render(Student.findByEmail(find.email).name));
			
		}
		else{
			Key find = loginForm.get();
			session("email", loginForm.get().email);
			return ok(userSigned.render(Student.findByEmail(find.email).name));
		}
	}

	/**
	 * Logout and clean the session.
	 */
	@Security.Authenticated(Secured.class)
	public static Result logout() {
		session().clear();
		flash("success", "You've been logged out");
		return redirect(routes.KeyChecker.login());
	}

}
