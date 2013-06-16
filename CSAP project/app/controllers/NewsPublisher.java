package controllers;

import java.util.List;

import models.News;
import models.Student;
import play.mvc.Controller;
import play.mvc.Result;
import play.data.Form;
import views.html.publishNews;
import views.html.submitPublish;
import views.html.listedNews;
public class NewsPublisher extends Controller{
	public static News news;
	public static Result publishNews(){
		
	     return ok(publishNews.render());
	
}
	public static Result submitPublish(){
		Form<News> newsForm = Form.form(News.class).bindFromRequest();
		 news= newsForm.get();
		 news.save();
		 
		 List <News> list= News.find.findList();
		
		return ok(submitPublish.render(list));
	}
	public static Result checkNews(){
        List <News> list= News.find.findList();
		
		return ok(listedNews.render(list));
	}
}
