package com.example.cesijeujura.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Fichier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String path;
	
	@ManyToOne
	private Devis devis;

	public Fichier() {

	}

	public int getId() {
		return id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Devis getDevis() {
		return devis;
	}
	
	public void setDevis(Devis devis) {
		this.devis = devis;
	}
	
	@Override
	public String toString() {
		return path;
	}
}
