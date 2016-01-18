package com.example.cesijeujura.Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Gamme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	
	@ManyToMany
	private List<Devis> devis;
	@ManyToMany
	private List<Module> modules;
	
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
	
	public List<Devis> getDevis() {
		return devis;
	}
	
	public List<Module> getModules() {
		return modules;
	}
	
	@Override
	public String toString() {
		return nom;
	}
}
