package com.example.cesijeujura.EJB;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.example.cesijeujura.DAO.PieceDAO;
import com.example.cesijeujura.Entities.Piece;
import com.example.cesijeujura.IEJB.PieceIEJB;

@Stateless
public class PieceEJB implements PieceIEJB{
	
	
	@Inject
	private PieceDAO pieceDao;
	
	
	@Override
	public Piece create(Piece object) {
		// TODO Auto-generated method stub
		return pieceDao.create(object) ;
	}

	@Override
	public Piece update(Piece object) {
		// TODO Auto-generated method stub
		return pieceDao.update(object);
	}

	@Override
	public Piece find(int id) {
		// TODO Auto-generated method stub
		return pieceDao.find(id);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
