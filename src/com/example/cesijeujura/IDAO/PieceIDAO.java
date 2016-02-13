package com.example.cesijeujura.IDAO;

import java.util.List;

import com.example.cesijeujura.Entities.Piece;


public interface PieceIDAO extends GenericIDAO<Piece> {

	public List<Piece> findAllType_Piece();
}
