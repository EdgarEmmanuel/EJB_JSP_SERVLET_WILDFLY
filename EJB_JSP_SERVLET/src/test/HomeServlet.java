package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import module.dao.IUser;
import module.entities.User;

@WebServlet(name="home",urlPatterns = {"/home","*.connex","*.conne"})
public class HomeServlet extends HttpServlet {
	@EJB
	private IUser iuser;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("base", "http://localhost:8080/EJB_JSP_SERVLET/");
		HttpSession session = req.getSession();
		
		
			if(req.getServletPath().equalsIgnoreCase("/deconnex.connex")) {
				session.setAttribute("nom_admin", null);
				req.getRequestDispatcher("/WEB-INF/views/home/login.jsp").forward(req, resp);
			}else {
				req.getRequestDispatcher("/WEB-INF/views/home/login.jsp").forward(req, resp);
			}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
			if(req.getServletPath().equalsIgnoreCase("/connex.conne")) {
				String login = req.getParameter("login");
				String password = req.getParameter("password");
				String role = req.getParameter("role");
				
					switch(role) {
						case "administrateur":
							User u = iuser.getUserByParams(login, password);
							if(u!=null) {
								session.setAttribute("nom_admin", u.getNom()+" "+u.getPrenom());
								req.getRequestDispatcher("/WEB-INF/views/home/Home.jsp").forward(req, resp);
							}else {
								session.setAttribute("message", "LOGIN OU MOT DE PASSE INCORRECTE(S)");
								resp.sendRedirect("home");
							}
							break;
					}
			}
		
	}
	
	
}
