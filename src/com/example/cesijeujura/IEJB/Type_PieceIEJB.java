package com.example.cesijeujura.IEJB;

import java.util.List;


import com.example.cesijeujura.Entities.Type_Piece;

public interface Type_PieceIEJB extends GenericEJBInterface<Type_Piece> {
	
	public List<Type_Piece> findAllType_Piece();
}
