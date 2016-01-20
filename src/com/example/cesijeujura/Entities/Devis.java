package com.example.cesijeujura.Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries(value = {
		@NamedQuery(name = "devis.findAll", query = "Select c from Devis c"),
		@NamedQuery(name = "devis.findDevisByStatuts", query ="Select c from Devis c where c.etat = ?1"),
		@NamedQuery(name = "devis.findDevisByClient", query ="Select c from Devis c where c.projet.client = ?1")
}
)
public class Devis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String ref;
	private String etat;
	private Double prix;

	@OneToMany(mappedBy="devis")
	private List<Fichier> fichiers;
	@ManyToMany
	private List<Gamme> gammes;
	@ManyToMany
	private List<Main_Oeuvre> mainsoeuvre;
	@ManyToOne
	private Projet projet;

	public Devis() {

	}

	public int getId() {
		return id;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public List<Fichier> getFichiers() {
		return fichiers;
	}

	public List<Gamme> getGammes() {
		return gammes;
	}

	public List<Main_Oeuvre> getMainsoeuvre() {
		return mainsoeuvre;
	}
	
	@Override
	public String toString() {
		return ref;
	}
}
