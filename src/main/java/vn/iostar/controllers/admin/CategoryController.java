package vn.iostar.controllers.admin;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iostar.entity.Category;
import vn.iostar.services.CategoryService;
import vn.iostar.services.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = {"/admin/category"})
public class CategoryController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	CategoryService cateService = new CategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Category> listCategory = cateService.findAll();
		req.setAttribute("listcate", listCategory);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/categories.jsp");
		rd.forward(req, resp);
	}
	
}
