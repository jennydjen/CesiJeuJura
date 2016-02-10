package com.example.cesijeujura.Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(value = { @NamedQuery(name = "fichier.findAll", query = "Select f from Fichier f") })
public class Fichier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String path;
	private List<Fichier> fichiers;
	
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
	
	public List<Fichier> getFichiers() {
		return fichiers;
	}
}
