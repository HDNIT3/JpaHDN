package vn.iostar.controllers.admin;

import java.io.File;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import vn.iostar.entity.Category;
import vn.iostar.entity.User;
import vn.iostar.services.CategoryService;
import vn.iostar.services.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = {
		"/admin/categorys",
		"/admin/category/create",
		"/admin/category/edit",
		"/admin/category/delete"
})
@MultipartConfig(
	fileSizeThreshold = 1024 * 1024,  // 1MB cache
	maxFileSize = 1024 * 1024 * 10,   // 10MB/file
	maxRequestSize = 1024 * 1024 * 50 // 50MB/request
)
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		
		if (uri.contains("categorys")) {
			resp.sendRedirect(req.getContextPath() + "/waiting");
		} else if (uri.contains("create")) {
			req.getRequestDispatcher("/views/admin/adcategory.jsp").forward(req, resp);

		} else if (uri.contains("edit")) {
			int id = Integer.parseInt(req.getParameter("id"));
			Category category = cateService.findById(id);
			req.setAttribute("name", category.getCategoryname());
			req.setAttribute("id", category.getCategory_id());
			req.setAttribute("category", category);
			req.getRequestDispatcher("/views/admin/editcategory.jsp").forward(req, resp);

		} else if (uri.contains("delete")) {
			int id = Integer.parseInt(req.getParameter("id"));
			cateService.delete(id);
			resp.sendRedirect(req.getContextPath() + "/admin/categorys");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();

		if (uri.contains("create")) {
			Category category = new Category();
			category.setCategoryname(req.getParameter("name"));

			Part filePart = req.getPart("imagename");
			String fileName = filePart.getSubmittedFileName();

			String uploadPath = "D:/upload";
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists())
				uploadDir.mkdirs();

			filePart.write(uploadPath + File.separator + fileName);
			category.setImages(fileName);
			HttpSession session = req.getSession();
			User u = (User) session.getAttribute("account");
			category.setUser(u);

			cateService.create(category);
			
			resp.sendRedirect(req.getContextPath() + "/admin/categorys");

		} else if (uri.contains("edit")) {
			System.out.print("ssss");
			int id = Integer.parseInt(req.getParameter("id"));
			Category category = cateService.findById(id);
			category.setCategoryname(req.getParameter("name"));

			Part filePart = req.getPart("imagename");
			if (filePart != null && filePart.getSize() > 0) {
				String fileName = filePart.getSubmittedFileName();
				String uploadPath = "D:/upload";
				File uploadDir = new File(uploadPath);
				if (!uploadDir.exists())
					uploadDir.mkdirs();

				filePart.write(uploadPath + File.separator + fileName);
				category.setImages(fileName);
			}

			cateService.update(category);
			resp.sendRedirect(req.getContextPath() + "/admin/categorys");
		}
	}
}
