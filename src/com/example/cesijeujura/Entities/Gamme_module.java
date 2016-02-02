package com.example.cesijeujura.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Gamme_module {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "id_module")
	private Module module;

	@ManyToOne
	@JoinColumn(name = "id_gamme")
	private Gamme gamme;

	public Gamme_module() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public Gamme getGamme() {
		return gamme;
	}

	public Module getModule() {
		return module;
	}

	public void setGamme(Gamme gamme) {
		this.gamme = gamme;
	}

	public void setModule(Module module) {
		this.module = module;
	}

}
