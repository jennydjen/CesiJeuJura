package com.example.cesijeujura.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Quantite_Composant_Module {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int nb;

	@ManyToOne
	private Composant composant;
	@ManyToOne
	private Module module;

	public Quantite_Composant_Module() {

	}

	public int getId() {
		return id;
	}

	public int getNb() {
		return nb;
	}

	public void setNb(int nb) {
		this.nb = nb;
	}

	public Composant getComposant() {
		return composant;
	}

	public void setComposant(Composant composant) {
		this.composant = composant;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}
}
