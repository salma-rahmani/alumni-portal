package controllers;

import java.util.List;

import models.Contact;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.contactAdmin;
import views.html.listedNews;
import views.html.checkInbox;
public class MessageForwarder extends Controller{
	public static Contact contact;
	 public static Result contactAdmin() {
	    	
			return ok(contactAdmin.render());
		}
	 public static Result sendMessage() {
	    	
		 Form<Contact> contactForm = Form.form(Contact.class).bindFromRequest();
		 contact= contactForm.get();
		 contact.save();
		 return ok("your message has been sent");
		}
	 public static Result checkInbox() {
	    	
		 List <Contact> list= Contact.find.findList();
			
			return ok(checkInbox.render(list));
		 
		}
}
