package com.example.cesijeujura.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.cesijeujura.Entities.Module;
import com.example.cesijeujura.IDAO.ModuleIDAO;

public class ModuleDAO implements ModuleIDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Module create(Module t) {
		// TODO Auto-generated method stub
		this.em.persist(t);
		return t;
	}

	@Override
	public Module update(Module t) {
		// TODO Auto-generated method stub
		return em.merge(t);
	}

	@Override
	public Module find(int id) {
		// TODO Auto-generated method stub
		Module t= this.em.find(Module.class, id);
		return t;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Module> findAllModule() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("module.findAll", Module.class).getResultList();
	}

}
