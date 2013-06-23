package controllers;


import com.typesafe.plugin.*;

import java.util.List;

import models.Contact;
import models.Student;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.contactAdmin;
import views.html.listedNews;
import views.html.checkInbox;
import views.html.sent;
public class MessageForwarder extends Controller{
	public static Contact contact;
	 public static Result contactAdmin() {
	    	
			return ok(contactAdmin.render());
		}
	 public static Result sendMessage() {
	    	
		 Form<Contact> contactForm = Form.form(Contact.class).bindFromRequest();
		 contact= contactForm.get();
		 contact.save();
		 return ok(contactAdmin.render());
		}
	 public static Result checkInbox() {
	    	
		 List <Contact> list= Contact.find.findList();
			
			return ok(checkInbox.render(list));
		 
		}
	 
	 
	 public static Result sendEmail(){
		 
		 List<Student> students = Student.find.all();

		 
		 MailerAPI mail = play.Play.application().plugin(MailerPlugin.class).email();
		 mail.setSubject("Notification");
		 for(Student current: students){
			 
			 if (current.email.equals("monira_srt@yahoo.com"))
				 continue;
			 mail.setSubject("Notification");
			 mail.addRecipient(current.name+"<"+current.email+">");
			 mail.addFrom("Monira Salehyar <monira_srt@yahoo.com>");
			 mail.send( "Admin of CSAP has published a news news to news page" );
			 
		 }
		 
		 
		 return ok(sent.render());
	 }
	 
	
}
