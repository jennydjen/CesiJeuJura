package com.example.cesijeujura.IDAO;

import java.util.List;

import com.example.cesijeujura.Entities.Piece;
import com.example.cesijeujura.Entities.Projet;


public interface PieceIDAO extends GenericIDAO<Piece> {

	public List<Piece> findAllType_Piece();
	public List<Piece> findByProjet(Projet projet);
}
