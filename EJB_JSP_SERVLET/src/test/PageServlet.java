package test;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import module.dao.IVillage;

@WebServlet(name="page",urlPatterns = {"*.pages"})
public class PageServlet extends HttpServlet {
	@EJB
	private IVillage ivillage;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
			if(req.getServletPath().equalsIgnoreCase("/villages.pages")) {
				req.getRequestDispatcher("/WEB-INF/views/home/village.jsp").forward(req, resp);
			}else if(req.getServletPath().equalsIgnoreCase("/client.pages")) {
				req.setAttribute("villages", ivillage.getAllVillage());
				req.getRequestDispatcher("/WEB-INF/views/home/client.jsp").forward(req, resp);
			}
	}
	
	
	
	
	
	

}
