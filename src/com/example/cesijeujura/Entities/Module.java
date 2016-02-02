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
@NamedQueries(value = { @NamedQuery(name = "module.findAll", query = "Select c from Module c") })
public class Module {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;

	@OneToMany(mappedBy = "module")
	private List<Quantite_Composant_Module> composants;
	@OneToMany(mappedBy = "module")
	private List<Gamme_module> gammes;

	public Module() {

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

	public List<Quantite_Composant_Module> getComposants() {
		return composants;
	}

	public List<Gamme_module> getGammes() {
		return gammes;
	}

	@Override
	public String toString() {
		return nom;
	}
}
