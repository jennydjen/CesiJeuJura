package com.example.cesijeujura.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.example.cesijeujura.Entities.Client;
import com.example.cesijeujura.Entities.Devis;
import com.example.cesijeujura.IDAO.DevisIDAO;

public class DevisDAO implements DevisIDAO{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Devis create(Devis t) {
		// TODO Auto-generated method stub
		this.em.persist(t);
		return t;
	}

	@Override
	public Devis update(Devis t) {
		// TODO Auto-generated method stub
		return em.merge(t);
	}

	@Override
	public Devis find(int id) {
		// TODO Auto-generated method stub
		Devis t= this.em.find(Devis.class, id);
		return t;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Devis> findDevisByStatuts(String statut) {
		// TODO Auto-generated method stub
		TypedQuery<Devis> query = em.createNamedQuery("devis.findDevisByStatuts", Devis.class);
		query.setParameter(1, statut);
		
		return query.getResultList();
	}

	@Override
	public List<Devis> findAllDevis() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("devis.findAll", Devis.class).getResultList();
	}

	@Override
	public List<Devis> findDevisByClient(Client client) {
		// TODO Auto-generated method stub
		TypedQuery<Devis> query = em.createNamedQuery("devis.findDevisByClient", Devis.class);
		query.setParameter(1, client);
		
		return query.getResultList();
	}

}
