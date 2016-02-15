package com.example.cesijeujura.IEJB;

import java.util.List;

import com.example.cesijeujura.Entities.Piece;
import com.example.cesijeujura.Entities.Projet;

public interface PieceIEJB extends GenericEJBInterface<Piece> {
	
	public List<Piece> findByProjet(Projet projet);
}
