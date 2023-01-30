package presentation;

import java.util.List;

import dao.ProduitdaoImpl;
import metier.entities.Produit;

public class Main {

	public static void main(String[] args) {
		ProduitdaoImpl dao = new ProduitdaoImpl();
		Produit p1 = dao.add(new Produit("Photocopieuse HP", 30000, 10));
		Produit p2 = dao.add(new Produit("Scanner HP Epson", 75000, 35));
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		
		System.out.println("chercher les produit");
		List<Produit> produit = dao.produitParmc("%H%");
		for(Produit p:produit) {
			System.out.println(p.toString());
		}
		
	
	
	}

}
