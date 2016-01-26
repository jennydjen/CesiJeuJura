package com.example.cesijeujura.IEJB;

import java.util.List;
import com.example.cesijeujura.Entities.Client;
import com.example.cesijeujura.Entities.Devis;

public interface DevisIEJB extends GenericEJBInterface<Devis>{

	public List<Devis> findDevisByStatuts(String statut);
	
	public List<Devis> findAllDevis();
	
	public List<Devis> findDevisByClient(Client client);
}
