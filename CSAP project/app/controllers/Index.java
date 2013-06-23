package controllers;

import java.io.File;
import java.util.List;


import models.Search;
import models.Student;


import models.sign;
import play.*;
import play.api.mvc.MultipartFormData;
import play.api.mvc.MultipartFormData.FilePart;
import play.data.Form;
import play.mvc.*;
import play.mvc.Security.Authenticated;
import play.data.validation.*;


import views.html.*;

public class Index extends Controller {


	 // @Security.Authenticated
    public static Result index() {
        return ok(index.render("Wellcome to CSAP"));
    }
    public static Result service(){
    	return ok(service.render());
    }
    public static Result office(){
    	return ok(office.render());
    }
    public static Result product(){
    	return ok(product.render());
    }
    public static Result aboutCSAP(){
    	return ok(aboutCSAP.render());
    }



					



}

 

