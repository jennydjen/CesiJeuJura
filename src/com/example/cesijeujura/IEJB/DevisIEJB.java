package com.example.cesijeujura.IEJB;

import java.util.List;

import com.example.cesijeujura.Entities.Client;
import com.example.cesijeujura.Entities.Devis;
import com.example.cesijeujura.Entities.Etat;
import com.example.cesijeujura.Entities.Projet;
import com.example.cesijeujura.Entities.Utilisateur;

public interface DevisIEJB extends GenericEJBInterface<Devis> {

	public List<Devis> findDevisByStatuts(Etat etat);

	public List<Devis> findAllDevis();

	public List<Devis> findDevisByClient(Client client);

	public List<Devis> findDevisByFiltre(Client client, Etat etat);

	public void initialiseDevisTMP(Client client, Utilisateur user);

	public List<Projet> findAllProjetByClient(Client client);
}
