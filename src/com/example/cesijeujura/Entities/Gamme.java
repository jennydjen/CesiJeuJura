package com.example.cesijeujura.Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Gamme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	
	@OneToMany(mappedBy="gamme")
	private List<Devis_gamme> devis;
	@OneToMany(mappedBy="gamme")
	private List<Gamme_module> modules;
	
	public Gamme() {

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
	
	public List<Devis_gamme> getDevis() {
		return devis;
	}
	
	public List<Gamme_module> getModules() {
		return modules;
	}
	
	@Override
	public String toString() {
		return nom;
	}
}
