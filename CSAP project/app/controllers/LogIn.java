package controllers;

import models.Student;
import models.sign;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.signIn;
import views.html.adminSigned;
import views.html.userSigned;
import views.html.unsigned;


public class LogIn extends Controller{
	public static Student student;
	public static Result signIn(){
		 return ok(signIn.render());
	}
	public static Result submitSignIn(){
		Form<Student> studentForm = Form.form(Student.class).bindFromRequest();
		student = studentForm.get();		
		  Form<sign> signForm = Form.form(sign.class).bindFromRequest();
			sign s = signForm.get();
			String theEmail = s.email;
			String password = s.password;
			Student findsign= Student.find.where().eq("name", theEmail).eq("password", password).findUnique();
			if(findsign != null){
				if(theEmail.equals("monira_srt@yahoo.com")){
					return ok("klsjdkj");
				}
				else
				{
			return ok("skldmzkxm");
			}}
			else{
			return ok(unsigned.render());
			}
			
					
}
	

}
