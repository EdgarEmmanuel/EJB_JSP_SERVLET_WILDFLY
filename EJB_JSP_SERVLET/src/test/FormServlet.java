package test;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import module.dao.IClient;
import module.dao.IVillage;
import module.entities.Client;
import module.entities.Village;
@WebServlet(urlPatterns = {"*.act"})
public class FormServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private IClient iclient;
	
	@EJB
	private IVillage ivillage;
	
	public void redirectView(int val, HttpServletRequest req,HttpSession session,
			String entity,HttpServletResponse resp) throws ServletException, IOException {
		if(val==1) {
			session.setAttribute("message", "INSERTION "+entity.toUpperCase()+" EFFECTUE(E) AVEC SUCCESS");
		}else {
			session.setAttribute("message", "ERREUR INSERTION "+entity.toUpperCase()+" OUPS!");
		}
		req.getRequestDispatcher("/WEB-INF/views/home/message.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
			if(req.getServletPath().equalsIgnoreCase("/village.act")) {
				String nom = req.getParameter("libelle");
				String localisation = req.getParameter("localisation");
				
				//initiate the village 
				Village v = new Village();
				v.setNom(nom);
				v.setLocalisation(localisation);
				
				
				//insert and redirect
				redirectView(ivillage.insertVillage(v), req,session,"VILLAGE",resp) ;
			}else if(req.getServletPath().equalsIgnoreCase("/insert_client.act")) {
				//get from the form
				String nom = req.getParameter("nom");
				String prenom = req.getParameter("prenom");
				String email = req.getParameter("email");
				String adresse = req.getParameter("addresse");
				String telephone = req.getParameter("telephone");
				int id_village = Integer.parseInt(req.getParameter("id_village"));
				
				//instantiate the Client 
				Client cl =  new Client();
				cl.setAdresse(adresse);
				cl.setTelephone(telephone);
				cl.setEmail(email);
				cl.setNom(nom);
				cl.setPrenom(prenom);
				cl.setVillage(ivillage.getOneByiD(id_village));
				
				//insert and redirect
				redirectView(iclient.insertClient(cl), req,session,"CLIENT",resp) ;
			}
		
	}
	
}
