package com.example.cesijeujura.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Quantite_Composant_Module {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int quantite;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_composant")
	private Composant composant;
	@ManyToOne
	@JoinColumn(name="id_module")
	private Module module;

	public Quantite_Composant_Module() {

	}

	public int getId() {
		return id;
	}

	public int getNb() {
		return quantite;
	}

	public void setNb(int nb) {
		this.quantite = nb;
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
