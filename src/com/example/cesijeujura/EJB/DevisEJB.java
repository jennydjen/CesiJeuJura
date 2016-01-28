package com.example.cesijeujura.EJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.example.cesijeujura.Entities.Client;
import com.example.cesijeujura.Entities.Devis;
import com.example.cesijeujura.Entities.Etat;
import com.example.cesijeujura.IDAO.DevisIDAO;
import com.example.cesijeujura.IEJB.DevisIEJB;

@Stateless
public class DevisEJB implements DevisIEJB {

	@Inject
	private DevisIDAO devisDAO;

	@Override
	public Devis create(Devis t) {
		// TODO Auto-generated method stub
		return devisDAO.create(t);
	}

	@Override
	public Devis find(int id) {
		// TODO Auto-generated method stub
		return devisDAO.find(id);
	}

	@Override
	public Devis update(Devis t) {
		// TODO Auto-generated method stub
		return devisDAO.update(t);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		devisDAO.delete(id);
	}

	@Override
	public List<Devis> findDevisByStatuts(Etat etat) {
		// TODO Auto-generated method stub
		return devisDAO.findDevisByStatuts(etat);
	}

	@Override
	public List<Devis> findAllDevis() {
		// TODO Auto-generated method stub
		return devisDAO.findAllDevis();
	}

	@Override
	public List<Devis> findDevisByClient(Client client) {
		// TODO Auto-generated method stub
		return devisDAO.findDevisByClient(client);
	}

	@Override
	public List<Devis> findDevisByFiltre(Client client, Etat etat) {
		// TODO Auto-generated method stub
		return devisDAO.findDevisByFiltre(client, etat);
	}

}
