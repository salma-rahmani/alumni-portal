package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import play.mvc.Controller;
import play.mvc.Result;

public class NewsDownloader extends Controller{
	
	
	
	public static Result downloadNews(String path) throws FileNotFoundException{
		
		
		return ok(new FileInputStream(new File(path)));
	}

}
