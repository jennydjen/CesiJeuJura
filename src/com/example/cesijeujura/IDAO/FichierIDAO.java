package com.example.cesijeujura.IDAO;

import java.util.List;

import com.example.cesijeujura.Entities.Fichier;;

public interface FichierIDAO extends GenericIDAO<Fichier> {
	
	public List<Fichier> findAllFichiers();

}