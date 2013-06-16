package controllers;

import models.Student;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.createProfile;
import views.html.signup;
import views.html.submitAdd;
import views.html.shortPass;
import views.html.passMatch;
public class Register extends Controller{
	public static Student student;
	 public static Result signup() {
	    	
			return ok(signup.render());
		}

		public static Result submitAdd() {

			Form<Student> studentForm = Form.form(Student.class).bindFromRequest();
			 student = studentForm.get();
			
			String p = student.password;
			String pc = student.passwordconf;
			if(p.equals(pc)){
				if(p.length()<8){
					
					return ok(shortPass.render(student));
					}
				else{
				
				
		 	    student.save();
		 	    
				return ok(submitAdd.render());
				
				}
				
			}
			else{
				return ok(passMatch.render(student));
			
		}}
			public static Result createProfile(){
				 String name = student.name;
				 

				return ok(createProfile.render(student));
			}
		}
		

