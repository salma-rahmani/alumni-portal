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
import play.data.validation.*;


import views.html.*;

public class Application extends Controller {


	  
    public static Result index() {
        return ok(index.render("Wellcome to CSAP"));
    }
  



					



}

 

