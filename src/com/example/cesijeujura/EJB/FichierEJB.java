package com.example.cesijeujura.EJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.example.cesijeujura.IDAO.FichierIDAO;
import com.example.cesijeujura.Entities.Fichier;
import com.example.cesijeujura.IEJB.FichierIEJB;

@Stateless
public class FichierEJB implements FichierIEJB{
	
	@Inject
	private FichierIDAO FichierDao;

	@Override
	public Fichier create(Fichier object) {
		// TODO Auto-generated method stub
		return FichierDao.create(object);
	}

	@Override
	public Fichier update(Fichier object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fichier find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Fichier> findAllFichiers() {
		// TODO Auto-generated method stub
		return FichierDao.findAllFichiers();
	}
	
	

}
