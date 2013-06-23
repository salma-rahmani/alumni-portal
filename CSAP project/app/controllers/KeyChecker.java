package controllers;

import static play.data.Form.form;

import java.util.List;

//import models.CategoryStorage;
import models.Key;
import models.UserStorage;

import play.data.Form;
import play.mvc.*;
import play.mvc.Security;
import views.html.*;


public class KeyChecker extends Controller {

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
		} else {
			session("username", loginForm.get().username);
			return redirect(routes.Index.index());
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
