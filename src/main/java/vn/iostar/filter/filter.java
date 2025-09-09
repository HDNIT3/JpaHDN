package vn.iostar.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iostar.entity.User;

@WebFilter("/*")
public class filter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);
		User u = (session != null) ? (User) session.getAttribute("account") : null;
		String uri = req.getRequestURI();
		if (uri.endsWith("/login")) {
			chain.doFilter(req, res);
			return;
		}
		if (uri.endsWith(".jsp")) {
		    res.sendRedirect(req.getContextPath() + "/login");
		    return;
		}
		if (u == null) {
			res.sendRedirect(req.getContextPath() + "/login");
			return;
		}	
		if(uri.contains("/admin/") && u.getRole()==3) {
			chain.doFilter(request, response);
			return;
		}
		if(uri.contains("/user/") && u.getRole()==1) {
			chain.doFilter(request, response);
			return;
		}
		if(uri.contains("/manager/") && u.getRole()==2) {
			chain.doFilter(request, response);
			return;
		}
		chain.doFilter(request, response);
	}

}
