package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import metier.entities.Produit;

public class ProduitdaoImpl implements IProduitdao {

	@Override
	public Produit add(Produit p) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("INSERT INTO produit(designation,prix,quantite) VALUES(?,?,?)");
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.executeUpdate();
			
			PreparedStatement ps2 = connection.prepareStatement
					("SELECT MAX(id) AS MAX_ID FROM PRODUIT");
			ResultSet rs = ps2.executeQuery();
			if(rs.next()) {
				p.setId(rs.getInt("MAX_ID"));
			}
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return p;
	}

	@Override
	public List<Produit> produitParmc(String mc) {
		List<Produit> produit = new ArrayList<Produit>();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM PRODUIT WHERE DESIGNATION LIKE ?");
			ps.setString(1, mc);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Produit p = new Produit();
				p.setId(rs.getInt("id"));
				p.setDesignation(rs.getString("designation"));
				p.setPrix(rs.getDouble("prix"));
				p.setQuantite(rs.getInt("quantite"));
				produit.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return produit;
	}

	@Override
	public Produit getProduit(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit update(Produit p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
