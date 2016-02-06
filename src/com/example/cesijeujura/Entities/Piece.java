package com.example.cesijeujura.Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Piece {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private	int surface;
	private int nb_Porte;
	private int nb_Fenetre;
	private String forme;
	private String finition;
	private int num_Etage;
	
	@ManyToOne
	private Projet projet;
	@ManyToOne
	private Type_Piece type_Piece;
	@OneToMany(mappedBy="piece")
	private List<Carac_fenetre> detailsFenetre;
	
	public Piece() {
	
	}
	
	public int getId() {
		return id;
	}

	public int getSurface() {
		return surface;
	}

	public void setSurface(int surface) {
		this.surface = surface;
	}

	public int getNbPorte() {
		return nb_Porte;
	}

	public void setNbPorte(int nbPorte) {
		this.nb_Porte = nbPorte;
	}

	public int getNbFenetre() {
		return nb_Fenetre;
	}

	public void setNbFenetre(int nbFenetre) {
		this.nb_Fenetre = nbFenetre;
	}

	public String getForme() {
		return forme;
	}

	public void setForme(String forme) {
		this.forme = forme;
	}

	public String getFinition() {
		return finition;
	}

	public void setFinition(String finition) {
		this.finition = finition;
	}

	public int getNumEtage() {
		return num_Etage;
	}

	public void setNumEtage(int numEtage) {
		this.num_Etage = numEtage;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Type_Piece getType() {
		return type_Piece;
	}

	public void setType(Type_Piece type) {
		this.type_Piece = type;
	}
	
	public List<Carac_fenetre> getDetailsFenetre() {
		return detailsFenetre;
	}
}
