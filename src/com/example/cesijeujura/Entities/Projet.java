package com.example.cesijeujura.Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Projet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String ref;
	private double surface;
	private String forme;
	private int hauteur;
	private int nbEtage;
	private String com;
	private String maquette;
	
	@ManyToOne
	@JoinColumn(name="fk_idcommercial")
	private Utilisateur commercial;
	@ManyToOne
	@JoinColumn(name="fk_idclient")
	private Client client;
	@OneToMany(mappedBy="projet")
	private List<Piece> pieces;
	@OneToMany(mappedBy="projet")
	private List<Devis> devis;
	
	public Projet(){
		
	}
	
	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public double getSurface() {
		return surface;
	}

	public void setSurface(double surface) {
		this.surface = surface;
	}

	public String getForme() {
		return forme;
	}

	public void setForme(String forme) {
		this.forme = forme;
	}

	public int getHauteur() {
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	public int getNbEtage() {
		return nbEtage;
	}

	public void setNbEtage(int nbEtage) {
		this.nbEtage = nbEtage;
	}

	public String getCommentaire() {
		return com;
	}

	public void setCommentaire(String commentaire) {
		this.com = commentaire;
	}

	public String getMaquette() {
		return maquette;
	}

	public void setMaquette(String maquette) {
		this.maquette = maquette;
	}

	public Utilisateur getCommercial() {
		return commercial;
	}

	public void setCommercial(Utilisateur commercial) {
		this.commercial = commercial;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public List<Devis> getDevis() {
		return devis;
	}
	
	public List<Piece> getPieces() {
		return pieces;
	}
	
	@Override
	public String toString() {
		return nom;
	}
}
