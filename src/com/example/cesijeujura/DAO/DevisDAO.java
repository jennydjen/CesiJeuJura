package com.example.cesijeujura.DAO;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.example.cesijeujura.Entities.Client;
import com.example.cesijeujura.Entities.Devis;
import com.example.cesijeujura.Entities.Etat;
import com.example.cesijeujura.IDAO.DevisIDAO;

public class DevisDAO implements DevisIDAO {

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
		Devis t = this.em.find(Devis.class, id);
		return t;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Devis> findDevisByStatuts(Etat etat) {
		// TODO Auto-generated method stub
		TypedQuery<Devis> query = em.createNamedQuery(
				"devis.findDevisByStatuts", Devis.class);
		query.setParameter(1, etat);

		return query.getResultList();
	}

	@Override
	public List<Devis> findAllDevis() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("devis.findAll", Devis.class)
				.getResultList();
	}

	@Override
	public List<Devis> findDevisByClient(Client client) {
		// TODO Auto-generated method stub
		List<Devis> devis = findAllDevis();

		List<Devis> result = new LinkedList<Devis>();

		for (Devis d : devis) {
			System.out.println("  TEST ------------ TETS "
					+ d.getProjet().getClient().getId());
			if (d.getProjet().getClient().getId() == client.getId()) {
				result.add(d);
			}
		}

		return result;
	}

	public List<Devis> findDevisByFiltre(Client client, Etat etat) {
		List<Devis> result = new LinkedList<Devis>();
		List<Devis> devis = new LinkedList<Devis>();

		if (etat != null) {
			devis = findDevisByStatuts(etat);
		} else {
			devis = findAllDevis();
		}

		if (client != null) {
			for (Devis d : devis) {
				if (d.getProjet().getClient().getId() == client.getId()) {
					result.add(d);
				}
			}
		}else{
			result.addAll(devis);
		}

		return result;
	}
}
