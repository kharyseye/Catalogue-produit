package controleur;

import java.io.IOException;
import java.util.List;

import javax.xml.ws.Response;

import dao.IProduitdao;
import dao.ProduitdaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.entities.Produit;
import model.ProduitModel;

@WebServlet(name="controleur", urlPatterns ="*.php")
public class ControleurServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	IProduitdao metier;
	
	@Override
	public void init() throws ServletException {
		metier = new ProduitdaoImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		if(path.equals("/index.php"))
		{
			req.getRequestDispatcher("produit.jsp").forward(req, resp);
			
		}else if(path.equals("/chercher.php")){
			String motCle = req.getParameter("motcle");
			ProduitModel model = new ProduitModel();
			model.setMotCle(motCle);
			List<Produit> produit = metier.produitParmc("%"+motCle+"%");
			model.setProduit(produit);
			req.setAttribute("model", model);
			req.getRequestDispatcher("produit.jsp").forward(req, resp);
			
		}else if(path.equals("/saisie.php")) {
			req.setAttribute("produit", new Produit());
			req.getRequestDispatcher("saisie.jsp").forward(req, resp);
			
		}else if(path.equals("/ajouter.php") && (req.getMethod().equals("POST"))){
			String designation = req.getParameter("designation");
			double prix = Double.parseDouble(req.getParameter("prix"));
			int quantite = Integer.parseInt(req.getParameter("quantite"));
			Produit p = metier.add(new Produit(designation, prix, quantite));
			req.setAttribute("produit", p);
			
			req.getRequestDispatcher("confirmationajout.jsp").forward(req, resp);
			
		}else if(path.equals("/supprimer.php")){
			int id = Integer.parseInt(req.getParameter("id"));
			metier.delete(id);
			resp.sendRedirect("chercher.php?motcle=");	
			
		}else if(path.equals("/edit.php")){
			int id = Integer.parseInt(req.getParameter("id"));
			Produit p = metier.getProduit(id);
			req.setAttribute("produit", p);
			req.getRequestDispatcher("edit.jsp").forward(req, resp);
			
		}else if(path.equals("/update.php") && (req.getMethod().equals("POST"))){
			int id = Integer.parseInt(req.getParameter("id"));
			String designation = req.getParameter("designation");
			double prix = Double.parseDouble(req.getParameter("prix"));
			int quantite = Integer.parseInt(req.getParameter("quantite"));
			Produit p = new Produit(designation, prix, quantite);
			p.setId(id);
			metier.update(p);
			req.setAttribute("produit", p);
			
			req.getRequestDispatcher("confirmationajout.jsp").forward(req, resp);
			
		}
		else {
			resp.sendError(org.apache.catalina.connector.Response.SC_NOT_FOUND);
		}
	}
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
