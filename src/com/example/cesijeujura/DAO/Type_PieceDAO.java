package com.example.cesijeujura.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.cesijeujura.Entities.Type_Piece;
import com.example.cesijeujura.IDAO.Type_PieceIDAO;

public class Type_PieceDAO implements Type_PieceIDAO{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Type_Piece create(Type_Piece t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type_Piece update(Type_Piece t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type_Piece find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Type_Piece> findAllType_Piece() {
		// TODO Auto-generated method stub
		List<Type_Piece> list =em.createNamedQuery("type_piece.findAll", Type_Piece.class).getResultList();
		return list;
	}

}
