package com.example.cesijeujura.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Devis_gamme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "id_gamme")
	private Gamme gamme;

	@ManyToOne
	@JoinColumn(name = "id_devis")
	private Devis devis;

	public Devis_gamme() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public Devis getDevis() {
		return devis;
	}

	public Gamme getGamme() {
		return gamme;
	}

	public void setDevis(Devis devis) {
		this.devis = devis;
	}

	public void setGamme(Gamme gamme) {
		this.gamme = gamme;
	}
}
