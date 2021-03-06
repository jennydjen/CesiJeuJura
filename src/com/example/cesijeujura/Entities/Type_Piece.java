package com.example.cesijeujura.Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries(value = { @NamedQuery(name = "type_piece.findAll", query = "Select tp from Type_Piece tp") })
public class Type_Piece {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	
	@OneToMany(mappedBy="type_Piece")
	private List<Piece> pieces;
	
	public Type_Piece() {

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
	
	public List<Piece> getPieces() {
		return pieces;
	}
	
	@Override
	public String toString() {
		return nom;
	}
}
