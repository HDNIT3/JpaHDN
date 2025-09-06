package vn.iostar.controllers.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/image")
public class CategoryImageController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String duongdan = "D:\\upload";
		String imagename = req.getParameter("imagename");
		File file = new File(duongdan+"/"+imagename);
		if(file.exists()) {
			IOUtils.copy(new FileInputStream(file),resp.getOutputStream());
		}
	}
}
