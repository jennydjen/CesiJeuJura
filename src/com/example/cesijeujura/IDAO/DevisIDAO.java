package com.example.cesijeujura.IDAO;

import java.util.List;

import com.example.cesijeujura.Entities.Client;
import com.example.cesijeujura.Entities.Devis;

public interface DevisIDAO extends GenericIDAO<Devis>{

	public List<Devis> findDevisByStatuts(String statut);
	
	public List<Devis> findAllDevis();
	
	public List<Devis> findDevisByClient(Client client);
}
