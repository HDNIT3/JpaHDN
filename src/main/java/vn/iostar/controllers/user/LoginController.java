package vn.iostar.controllers.user;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iostar.entity.User;
import vn.iostar.services.CategoryService;
import vn.iostar.services.UserService;
import vn.iostar.services.impl.CategoryServiceImpl;
import vn.iostar.services.impl.UserServiceImpl;

@WebServlet(urlPatterns = {"/login","/waiting","/logout"})
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userSer = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		if (url.contains("login")) {
			HttpSession session = req.getSession(false);
			if (session != null && session.getAttribute("account") != null) {
				resp.sendRedirect(req.getContextPath() + "/waiting");
				return;
			}
			try {
				Cookie[] cookies = req.getCookies();
				if (cookies != null) {
					for (Cookie cookie : cookies) {
						if (cookie.getName().equals("username")) {
							session = req.getSession(true);
							session.setAttribute("username", cookie.getValue());
							resp.sendRedirect(req.getContextPath() + "/waiting");
							return;
						}
					}
				}
				req.getRequestDispatcher("/views/user/login.jsp").forward(req, resp);
			} catch (Exception e) {
				req.getRequestDispatcher("/views/user/login.jsp").forward(req, resp);
				e.printStackTrace();
			}
		}
		else if (url.contains("waiting")) {
			HttpSession session = req.getSession();
			CategoryService cate = new CategoryServiceImpl();
			if (session != null && session.getAttribute("account") != null) {
				User u = (User) session.getAttribute("account");
		        if (u.getRole() == 1) {
		        	req.setAttribute("listcate", cate.findAll());
		            req.getRequestDispatcher("/views/user/home.jsp").forward(req, resp);
		        }
				else if (u.getRole() == 2){
					req.setAttribute("listcate", cate.findByIdUser(u.getId()));
					req.getRequestDispatcher("/views/manager/Home.jsp").forward(req, resp);
				}
				else if (u.getRole() == 3){
					req.setAttribute("listcate", cate.findAll());
					req.getRequestDispatcher("/views/admin/categories.jsp").forward(req, resp);
				}
			} else {
				resp.sendRedirect(req.getContextPath() + "/login");
			}
		}
		else if (url.contains("logout")) {
			 HttpSession session = req.getSession(false);
		     if (session != null) {
		            session.invalidate();
		     }
		     resp.sendRedirect(req.getContextPath() + "/login");
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		if (url.contains("login")) {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			String username = req.getParameter("username");
			String password = req.getParameter("password");

			String alertMsg = "";
			if (username.isEmpty() || password.isEmpty()) {
				alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
				req.setAttribute("alert", alertMsg);
				req.getRequestDispatcher("/views/user/login.jsp").forward(req, resp);
				return;
			}
			User user = userSer.findByName(username);
			if (user != null) {
				HttpSession session = req.getSession(true);
				session.setAttribute("account", user);
				resp.sendRedirect(req.getContextPath() + "/waiting");
			} else {
				alertMsg = "Tài khoản hoặc mật khẩu không đúng";
				req.setAttribute("alert", alertMsg);
				req.getRequestDispatcher("/views/user/login.jsp").forward(req, resp);
			}
		}
	}
}
