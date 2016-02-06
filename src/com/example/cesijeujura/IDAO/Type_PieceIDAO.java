package com.example.cesijeujura.IDAO;

import java.util.List;

import com.example.cesijeujura.Entities.Type_Piece;


public interface Type_PieceIDAO extends GenericIDAO<Type_Piece> {

	public List<Type_Piece> findAllType_Piece();
}
