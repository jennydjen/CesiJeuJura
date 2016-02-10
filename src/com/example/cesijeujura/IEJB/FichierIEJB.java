package com.example.cesijeujura.IEJB;

import java.util.List;

import com.example.cesijeujura.Entities.Fichier;

public interface FichierIEJB extends GenericEJBInterface<Fichier> {

	public List<Fichier> findAllFichiers();
}