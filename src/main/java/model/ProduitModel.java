package model;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Produit;

public class ProduitModel {
	private String MotCle;
	private List<Produit> produit = new ArrayList<Produit>();
	
	public String getMotCle() {
		return MotCle;
	}
	public void setMotCle(String motCle) {
		MotCle = motCle;
	}
	public List<Produit> getProduit() {
		return produit;
	}
	public void setProduit(List<Produit> produit) {
		this.produit = produit;
	}
	
	

}
