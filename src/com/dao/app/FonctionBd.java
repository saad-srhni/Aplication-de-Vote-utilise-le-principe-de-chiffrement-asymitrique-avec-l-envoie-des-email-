package com.dao.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class FonctionBd {

	public Collection<CoVotant> getAllCo() {
		// TODO Auto-generated method stub
		Connection connection = Dao.getInstance().getConnection();

		try {   //crée table CoVotant
			PreparedStatement stmt;
			stmt = connection.prepareStatement("SELECT * FROM  CoVotant");
			ResultSet result = stmt.executeQuery();
			Collection<CoVotant> listco = new ArrayList<CoVotant>();

			while (result.next()) { //fih les column kolhom string ykono fihom iden bulltinvote  500 charactere
				int id = result.getInt("id");
				String nom = result.getString("nom");
				String prenom = result.getString("prenom");
				String datenaissance = result.getString("datenaissance");
				String identification = result.getString("iden");
				String bulltinvote = result.getString("bulltinvote");
				CoVotant co = new CoVotant(nom, prenom, datenaissance, identification, bulltinvote);
				co.setId(id);
				listco.add(co);
			}
			return listco;

		} catch (SQLException e) {
			System.out.println("Erreur SQL " + e.getMessage());
		}
		return null;
	}

	public Collection<DeVotant> getAllDe() {
		// TODO Auto-generated method stub
		Connection connection = Dao.getInstance().getConnection();

		try {
			PreparedStatement stmt; // table 2  DeVotant
			//cols string b7al table lwl
			stmt = connection.prepareStatement("SELECT * FROM DeVotant ");
			ResultSet result = stmt.executeQuery();
			Collection<DeVotant> listde = new ArrayList<DeVotant>();
			while (result.next()) {
				int id = result.getInt("id");
				String nom = result.getString("nom");
				String prenom = result.getString("prenom");
				String datenaissance = result.getString("datenaissance");
				String identification = result.getString("iden");
				String bulltinvote = result.getString("bulltinvote");
				DeVotant de = new DeVotant(nom, prenom, datenaissance, identification, bulltinvote);
				de.setId(id);
				listde.add(de);
			}
			return listde;

		} catch (SQLException e) {
			System.out.println("Erreur SQL " + e.getMessage());
		}
		return null;
	}

	public Boolean setCoVotant(CoVotant covotant) {
		Connection connection = Dao.getInstance().getConnection();
		try {
			PreparedStatement stmt;
			Statement st = connection.createStatement();
			String sql1 = "select * from CoVotant where iden ='" + covotant.getIdentification() +"'";
			System.out.println(sql1);
			ResultSet rs = st.executeQuery(sql1);
			rs.last();
			if (rs.getRow() == 0) {
				System.out.println(covotant);
				stmt = connection.prepareStatement("INSERT INTO CoVotant VALUES(NULL,?,?,?,?,?)");
				stmt.setString(1, covotant.getNom());
				stmt.setString(2, covotant.getPrenom());
				stmt.setString(3, covotant.getDatenaissance());
				stmt.setString(4, covotant.getIdentification());
				stmt.setString(5, covotant.getBulltinvote());
				stmt.execute();
				return true;
			} else {
				System.out.println("ce personne est deja voter");
			}
		} catch (SQLException e) {
			System.out.println("Erreur SQL " + e.getMessage());
		}
		return false;
	}

	public Boolean setDeVotant(DeVotant devotant) {
		Connection connection = Dao.getInstance().getConnection();
		try {
			Statement st = connection.createStatement();
			String sql1 = "select * from DeVotant where iden ='" + devotant.getIdentification() +"'";
			ResultSet rs = st.executeQuery(sql1);
			rs.last();
			if (rs.getRow() == 0) {
				PreparedStatement stmt;
				stmt = connection.prepareStatement("INSERT INTO DeVotant VALUES(NULL,?,?,?,?,?)");
				stmt.setString(1, devotant.getNom());
				stmt.setString(2, devotant.getPrenom());
				stmt.setString(3, devotant.getDatenaissance());
				stmt.setString(4, devotant.getIdentification());
				stmt.setString(5, devotant.getBulltinvote());
				stmt.execute();
			}
		} catch (SQLException e) {
			System.out.println("Erreur SQL " + e.getMessage());
			return false;
		}
		return true;
	}

}
