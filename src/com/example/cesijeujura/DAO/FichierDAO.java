package com.example.cesijeujura.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.cesijeujura.Entities.Fichier;
import com.example.cesijeujura.IDAO.FichierIDAO;


public class FichierDAO implements FichierIDAO{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Fichier create(Fichier t) {
		// TODO Auto-generated method stub
		this.em.persist(t);
		return t;
	}

	@Override
	public Fichier update(Fichier t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fichier find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Fichier> findAllFichiers() {
		// TODO Auto-generated method stub
		List<Fichier> list =em.createNamedQuery("fichier.findAll", Fichier.class).getResultList();
		return list;
	}

}