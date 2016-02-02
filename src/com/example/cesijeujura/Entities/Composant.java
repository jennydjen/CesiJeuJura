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
@NamedQueries(value = { @NamedQuery(name = "composant.findAll", query = "Select c from Compoosant c"), })
public class Composant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;

	@OneToMany(mappedBy = "composant")
	private List<Quantite_Composant_Module> modules;

	public Composant() {

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

	public List<Quantite_Composant_Module> getModules() {
		return modules;
	}

	@Override
	public String toString() {
		return nom;
	}
}
