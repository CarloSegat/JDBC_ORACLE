package com.accenture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.accenture.dbutils.ConnectionFactory;
import com.accenture.entity.Product;

public class ProductDaoImp implements ProductDao {

	@Override
	public List<Product> getAll() {
		List<Product> elenco = new ArrayList<Product>();
		Connection conn = ConnectionFactory.getConnection();// ottengo connessione dalla classe apposita
		// preparo query lettura
		String sql = "select product_id, product_name, description, standard_cost, "
				   + "list_price, category_id from products";
		Statement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()) {// scorro result set
				int id = rs.getInt(1);// estraggo valori che uso per creare nuovo Studente
				String name = rs.getString(2);
				String description = rs.getString(3);
				double cost = rs.getDouble(4);
				double price = rs.getDouble(5);
				String catID = rs.getString(6);
				elenco.add( new Product(description, name, cost, price, catID, id) );
			}
		} catch (SQLException e) {
			System.out.println("Errore SQL: "+e.getMessage());
		}
		if(conn != null) {// chiudo la connessione
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Errore chiusura connessione: "+e.getMessage());
			}
		}
		return elenco;
	}

	@Override
	public boolean create(Product s) {
		boolean controllo = false;
		Connection conn = ConnectionFactory.getConnection();
		String sql = "insert into PRODUCTS (product_name, description, standard_cost, list_price, category_id) values (?, ?, ?, ?, ?)";
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, s.getName());
			pstm.setString(2, s.getDescription());
			pstm.setDouble(3, s.getStandardCost());
			pstm.setDouble(4, s.getListPrice());
			pstm.setString(5, s.getCategoryId());
			int i = pstm.executeUpdate();
			System.out.println("Inseriti "+i+" prodotti");
			controllo = true;
		} catch (SQLException e) {
			System.out.println("Errore SQL: "+e.getMessage());
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Errore chiusura connessione: "+e.getMessage());
			}
		}
		return controllo;
	}

	@Override
	public Product getById(String i) {
		Product s = null;
		Connection conn = ConnectionFactory.getConnection();
		String sql = "select id,cognome,nome from profitti_studenti where id= ?";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, i);
			rs = pstm.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String c = rs.getString(2);
				String n = rs.getString(3);
				s = new Product(id,c,n);
			} 
		} catch (SQLException e) {
			System.out.println("Errore SQL: "+e.getMessage());
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Errore chiusura connessione: "+e.getMessage());
			}
		}
		return s;
	}

	@Override
	public boolean deleteById(String id) {
		boolean controllo = false;
		Connection conn = ConnectionFactory.getConnection();
		String sql = "delete from profitti_studenti where id= ?";
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			int i = pstm.executeUpdate();
			System.out.println("Eliminati "+i+" studente/i");
			controllo = true;
		} catch (SQLException e) {
			System.out.println("Errore SQL: "+e.getMessage());
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Errore chiusura connessione: "+e.getMessage());
			}
		}
		return controllo;
	}
	@Override
	public boolean update(Product s) {
		boolean controllo = false;
		int id = s.getId();
		String c = s.getCognome();
		String n = s.getNome();
		Connection conn = ConnectionFactory.getConnection();
		String sql = "update profitti_studenti set cognome = ?, nome = ? where id = ?  ";
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,c);
			pstm.setString(2,n);
			pstm.setInt(3,id);
			int i = pstm.executeUpdate();
			System.out.println("Modificati "+i+" studente/i");
		} catch (SQLException e) {
			System.out.println("Errore SQL: "+e.getMessage());
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Errore chiusura connessione: "+e.getMessage());
			}
		}
		return controllo;
	}

	@Override
	public List<Product> search(String s) {
		List<Product> elenco = new ArrayList<Product>();
		Connection conn = ConnectionFactory.getConnection();// ottengo connessione dalla classe apposita
		// preparo query lettura
		String sql = "select id,cognome,nome from profitti_studenti where cognome like ? or nome like ?";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, "%"+s+"%");
			pstm.setString(2, "%"+s+"%");
			rs = pstm.executeQuery();
			while(rs.next()) {// scorro result set
				int id = rs.getInt(1);// estraggo valori che uso per creare nuovo Studente
				String c = rs.getString(2);
				String n = rs.getString(3);
				elenco.add( new Product(id,c,n) );// aggiungo studente alla lista elenco
			}
		} catch (SQLException e) {
			System.out.println("Errore SQL: "+e.getMessage());
		}
		if(conn != null) {// chiudo la connessione
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Errore chiusura connessione: "+e.getMessage());
			}
		}
		return elenco;
	}

}
