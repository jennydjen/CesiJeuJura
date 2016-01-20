package com.example.cesijeujura.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.cesijeujura.Entities.Client;
import com.example.cesijeujura.IDAO.ClientIDAO;

public class ClientDAO implements ClientIDAO{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Client create(Client t) {
		// TODO Auto-generated method stub
		this.em.persist(t);
		return t;
	}

	@Override
	public Client update(Client t) {
		// TODO Auto-generated method stub
		return em.merge(t);
	}

	@Override
	public Client find(int id) {
		// TODO Auto-generated method stub
		Client t= this.em.find(Client.class, id);
		return t;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Client> findAllClient() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("client.findAll", Client.class).getResultList();
	}

}
