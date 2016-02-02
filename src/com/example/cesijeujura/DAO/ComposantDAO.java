package com.example.cesijeujura.DAO;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.cesijeujura.Entities.Client;
import com.example.cesijeujura.Entities.Composant;
import com.example.cesijeujura.Entities.Module;
import com.example.cesijeujura.IDAO.ComposantIDAO;

public class ComposantDAO implements ComposantIDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Composant create(Composant t) {
		// TODO Auto-generated method stub
		this.em.persist(t);
		return t;
	}

	@Override
	public Composant update(Composant t) {
		// TODO Auto-generated method stub
		return em.merge(t);
	}

	@Override
	public Composant find(int id) {
		// TODO Auto-generated method stub
		Composant t= this.em.find(Composant.class, id);
		return t;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Composant> findAllComposant() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("composant.findAll", Composant.class).getResultList();
	}
	
	@Override
	public List<Composant> findComposantByModule(Module module) {
		// TODO Auto-generated method stub
		List<Composant> composant = findAllComposant();

		List<Composant> result = new LinkedList<Composant>();

		for (Composant c : composant) {
			System.out.println("  TEST ------------ TETS "
					+ ((Client) c.getModules()).getId());
			if (((Client) c.getModules()).getId() == module.getId()) {
				result.add(c);
			}
		}

		return result;
	}


}
