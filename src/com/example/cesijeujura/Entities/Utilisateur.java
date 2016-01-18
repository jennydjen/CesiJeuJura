package com.example.cesijeujura.Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String tel;
	private String mail;
	
	@ManyToMany
	private List<Droit> droits;
	
	@OneToMany(mappedBy="commercial")
	private List<Projet> projets;
	
	public Utilisateur(){
		
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public List<Droit> getDroits() {
		return droits;
	}
	
	public List<Projet> getProjets() {
		return projets;
	}
	
	@Override
	public String toString() {
		return nom.toUpperCase() + " " + prenom;
	}
}
