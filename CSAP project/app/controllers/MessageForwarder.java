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
	 
	 //added by jawid
	 public static Result sendEmail(){
		 
		 List<Student> students = Student.find.all();

		 
		 MailerAPI mail = play.Play.application().plugin(MailerPlugin.class).email();
		 mail.setSubject("play framework mail");
		 for(Student current: students){
			 
			 if (current.email.equals("monira_srt@yahoo.com"))
				 continue;
			 mail.setSubject("play framework mail");
			// mail.addRecipient("Ahmad Jawid Jami <ahmadjawidjami@gmail.com>","mon.ahmadjawid@gmail.com");
			 mail.addRecipient(current.name+"<"+current.email+">");
			 mail.addFrom("Monira Salehyar <m3.salehyar@email.com>");
			 //sends html
			 //mail.sendHtml("<html>html</html>");
			 //sends text/text
			 mail.send( "text" );
			 
		 }
		 
		 
		 //sends both text and html
		 //mail.send( "text", "<html>html</html>");
		 
		 
		 
		 
		 return ok("email sent");
	 }
	 
	 //finished by jawid
}
