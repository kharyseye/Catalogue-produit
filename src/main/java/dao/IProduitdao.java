package dao;

import java.util.List;

import metier.entities.Produit;

public interface IProduitdao {
	public Produit add(Produit p);
	public List<Produit> produitParmc(String mc);
	public Produit getProduit(int id);
	public Produit update(Produit p);
	public Produit delete(int id);

}
