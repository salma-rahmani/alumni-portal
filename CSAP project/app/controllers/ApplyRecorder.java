package controllers;

import java.util.List;

import models.Apply;
import models.Archive;
import models.News;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.applyJob;
import views.html.applyReciever;
import views.html.submitApply;
import views.html.wrongInput;

public class ApplyRecorder extends Controller{
	public static Apply apply;

	public static Result applyJob() {
	return ok(applyJob.render());
	
}
	public static Result submitApply() {
		Form<Apply> applyForm = Form.form(Apply.class).bindFromRequest();
		if (applyForm.hasErrors()) {
			return ok(wrongInput.render());
		}else{
		apply = applyForm.get();
		apply.save();
		return ok(submitApply.render());
		
	}}
	public static Result applyReciever() {
		
		List<Apply> list = Apply.find.findList();

		return ok(applyReciever.render(list));
}
}