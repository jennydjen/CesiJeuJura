package com.example.cesijeujura.EJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.example.cesijeujura.DAO.Type_PieceDAO;
import com.example.cesijeujura.Entities.Module;
import com.example.cesijeujura.Entities.Type_Piece;
import com.example.cesijeujura.IEJB.Type_PieceIEJB;

@Stateless
public class Type_PieceEJB implements Type_PieceIEJB{
	
	@Inject
	private Type_PieceDAO typePieceDao;

	@Override
	public Type_Piece create(Type_Piece object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type_Piece update(Type_Piece object) {
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
		return typePieceDao.findAllType_Piece();
	}
	
	

}
