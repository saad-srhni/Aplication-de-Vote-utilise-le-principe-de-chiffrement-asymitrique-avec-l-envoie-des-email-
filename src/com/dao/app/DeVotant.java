package com.dao.app;

public class DeVotant {
	private int id;
	private String nom;
	private String prenom;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String datenaissance;
	private String identification;
	private String bulltinvote;

	public DeVotant(String nom, String prenom, String datenaissance, String identification, String bulltinvote) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.datenaissance = datenaissance;
		this.identification = identification;
		this.bulltinvote = bulltinvote;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDatenaissance() {
		return datenaissance;
	}

	public void setDatenaissance(String datenaissance) {
		this.datenaissance = datenaissance;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getBulltinvote() {
		return bulltinvote;
	}

	public void setBulltinvote(String bulltinvote) {
		this.bulltinvote = bulltinvote;
	}

}
