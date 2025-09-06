package vn.iostar.controllers.admin;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iostar.entity.Category;
import vn.iostar.services.CategoryService;
import vn.iostar.services.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = { "/admin/category/create" })
@MultipartConfig(               
	    fileSizeThreshold = 1024 * 1024,     // 1MB cache
	    maxFileSize = 1024 * 1024 * 10,      // 10MB/file
	    maxRequestSize = 1024 * 1024 * 50    // 50MB/request
)
public class CategoryAddController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	CategoryService cateser = new CategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/views/admin/adcategory.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Category category = new Category();
		category.setCategoryname(req.getParameter("name"));
		
		Part filePart = req.getPart("imagename");
        String fileName = filePart.getSubmittedFileName();
        
        String uploadPath = "D:/upload";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdirs();
        filePart.write(uploadPath + File.separator + fileName);
        category.setImages(fileName);
        
        cateser.create(category);
        
        resp.sendRedirect(req.getContextPath() + "/admin/category");
	}
}
