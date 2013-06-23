package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import models.Archive;
import models.News;
import models.Student;
import play.mvc.Controller;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Result;
import play.data.Form;
import views.html.publishNews;
import views.html.submitPublish;
import views.html.listedNews;
import views.html.archive;
import views.html.checkArchive;
public class NewsPublisher extends Controller {
	public static News news;
	public static Archive arch;

	public static Result publishNews() {

		return ok(publishNews.render());

	}

	public static Result submitPublish() {
		Form<News> newsForm = Form.form(News.class).bindFromRequest();
		news = newsForm.get();
		

		MultipartFormData fileForm = request().body().asMultipartFormData();
		FilePart newsFile = fileForm.getFile("file");
		if (newsFile != null) {
			File file = newsFile.getFile();
			File uploads = new File("uploads");
			if (!uploads.exists()) {
				uploads.mkdir();
			}
			news.path = uploads + "/" + newsFile.getFilename();
			try {
				archiveToDisk(file, new File(news.path));
			} catch (Exception e) {
				return ok("the file could not be uploaded");

			}
			
			news.save();

		}

		List<News> list = News.find.findList();

		return ok(submitPublish.render(list));
	}

	public static void archiveToDisk(File source, File destination)
			throws Exception {

		InputStream src = new FileInputStream(source);

		OutputStream dest = new FileOutputStream(destination);

		byte buf[] = new byte[1024];
		int read = -1;
		while ((read = src.read(buf)) != -1)
			dest.write(buf, 0, read);

		src.close();
		dest.close();
	}

	public static Result checkNews() {
		List<News> list = News.find.findList();

		return ok(listedNews.render(list));
	}

	public static Result archive() {
		Form<Archive> archiveForm = Form.form(Archive.class).bindFromRequest();
		arch = archiveForm.get();
		arch.save();
		News.find.ref(arch.title).delete();
		return ok(archive.render());
	}
	public static Result checkArchive() {
		List<Archive> list = Archive.find.findList();

		return ok(checkArchive.render(list));
	}
	
	}
	
	
	
