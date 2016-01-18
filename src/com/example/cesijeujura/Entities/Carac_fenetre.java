package com.example.cesijeujura.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Carac_fenetre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int largeur;
	private int hauteur;
	private String forme;

	@ManyToOne
	private Piece piece;
	
	@ManyToOne
	private Type_fenetre type;

	public Carac_fenetre() {

	}

	public int getId() {
		return id;
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	public String getForme() {
		return forme;
	}

	public void setForme(String forme) {
		this.forme = forme;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public Type_fenetre getType() {
		return type;
	}

	public void setType(Type_fenetre type) {
		this.type = type;
	}
}
