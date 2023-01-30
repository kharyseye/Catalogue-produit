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
			req.getRequestDispatcher("saisie.jsp").forward(req, resp);
		}
		else {
			resp.sendError(org.apache.catalina.connector.Response.SC_NOT_FOUND);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
