package controllers;

import java.util.List;

import models.Search;
import models.Student;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.submitSearch;
import views.html.searchProfile;
import views.html.searchMember;

public class SearchMember extends Controller{
	public static Result  searchMember() {
		 return ok(searchMember.render());
	}
	public static Result submitSearch() {

		Form<Search> searchForm = Form.form(Search.class).bindFromRequest();
		Search searched = searchForm.get();
		List<Student> mylist = Student.find.where()
				.eq("lastname", "salehyar").eq("name", "monira").findList();

		List <Student> student = null;
		 String s = searched.searchStudent;
		 if (searched.searchBy.equals("name")) {
		 student = Student.find.where().eq("name", s).findList();
		
		 return ok(submitSearch.render(student));
		
		 } else if (searched.searchBy.equals("id")) {
		
		 student = Student.find.where().eq("id", s).findList();
		 return ok(submitSearch.render(student));
		
		 
		
		 }
		 else if (searched.searchBy.equals("lastname")) {
				
			 student = Student.find.where().eq("lastname", s).findList();
			 return ok(submitSearch.render(student));
			
			 
			
			 }
		 
		
		 else

		return ok(submitSearch.render(student));
	}
	
	public static Result searchProfile() {
		Form<Search> searchForm = Form.form(Search.class).bindFromRequest();
		Search searched = searchForm.get();
		List<Student> mylist = Student.find.where()
				.eq("lastname", "salehyar").eq("name", "monira").findList();

		List<Student> student = null;
		 String s = searched.searchStudent;
		 student = Student.find.where().eq("name", s).findList();
		
		 return ok(searchProfile.render(student));
	}


}
