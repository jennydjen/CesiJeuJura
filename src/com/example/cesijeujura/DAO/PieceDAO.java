package com.example.cesijeujura.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.example.cesijeujura.Entities.Devis;
import com.example.cesijeujura.Entities.Module;
import com.example.cesijeujura.Entities.Piece;
import com.example.cesijeujura.Entities.Projet;
import com.example.cesijeujura.IDAO.PieceIDAO;

public class PieceDAO implements PieceIDAO{

	@PersistenceContext
	private EntityManager em;

	@Override
	public Piece create(Piece t) {
		// TODO Auto-generated method stub
		this.em.persist(t);
		return null;
	}

	@Override
	public Piece update(Piece t) {
		// TODO Auto-generated method stub
		
		return em.merge(t);
	}

	@Override
	public Piece find(int id) {
		Piece t = this.em.find(Piece.class, id);
		return t;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Piece> findAllType_Piece() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("piece.findAll", Piece.class)
				.getResultList();
	}
	
	public List<Piece> findByProjet(Projet projet){
		
		TypedQuery<Piece> query = em.createNamedQuery("piece.findByProjet", Piece.class);
		query.setParameter(1, projet);
		return query.getResultList();
		
	}
	

}
