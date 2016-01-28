package com.example.cesijeujura.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries(value = {
		@NamedQuery(name = "devis.findAll", query = "Select c from Devis c"),
		@NamedQuery(name = "devis.findDevisByStatuts", query ="Select c from Devis c where c.etat = ?1"),
}
)
public class Devis implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String ref;
	@Enumerated(EnumType.STRING)
	private Etat etat;
	private Double prix;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_creation;

	@OneToMany(mappedBy="devis")
	private List<Fichier> fichiers;
	@ManyToMany
	private List<Gamme> gammes;
	@ManyToMany
	private List<Main_Oeuvre> mainsoeuvre;
	@ManyToOne
	@JoinColumn(name="id_projet")
	private Projet projet;

	public Devis() {
		date_creation = new Date();
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

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
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
	
	public Date getDateCreation() {
		return date_creation;
	}
	
	public void setDateCreation(Date date_creation) {
		this.date_creation = date_creation;
	}
	
	@Override
	public String toString() {
		return ref;
	}
}
