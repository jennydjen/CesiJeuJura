package com.example.cesijeujura.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.example.cesijeujura.Entities.Utilisateur;
import com.example.cesijeujura.IDAO.UserIDAO;

public class UserDAO implements UserIDAO{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Utilisateur create(Utilisateur t) {
		// TODO Auto-generated method stub
		this.em.persist(t);
		return t;
	}

	@Override
	public Utilisateur update(Utilisateur t) {
		// TODO Auto-generated method stub
		return em.merge(t);
	}

	@Override
	public Utilisateur find(int id) {
		// TODO Auto-generated method stub
		Utilisateur t= this.em.find(Utilisateur.class, id);
		return t;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isUserExist(String mail, String password) {
		// TODO Auto-generated method stub
		TypedQuery<Utilisateur> query = em.createNamedQuery("user.isUserExist", Utilisateur.class);
		query.setParameter(1, mail);
		query.setParameter(2, password);
		
		return query.getResultList().size() >=1;
	}

	@Override
	public boolean isMailUserExist(String mail) {
		// TODO Auto-generated method stub
		TypedQuery<Utilisateur> query = em.createNamedQuery("user.isMailUserExist", Utilisateur.class);
		query.setParameter(1, mail);
		
		return query.getResultList().size() >=1;
	}

}
