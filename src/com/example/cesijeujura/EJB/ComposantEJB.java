package com.example.cesijeujura.EJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.example.cesijeujura.Entities.Composant;
import com.example.cesijeujura.Entities.Module;
import com.example.cesijeujura.IDAO.ComposantIDAO;
import com.example.cesijeujura.IEJB.ComposantIEJB;

@Stateless
public class ComposantEJB implements ComposantIEJB{
	
	@Inject
	private ComposantIDAO composantDAO;

	@Override
	public Composant create(Composant t) {
		// TODO Auto-generated method stub
		return composantDAO.create(t);
	}

	@Override
	public Composant update(Composant t) {
		// TODO Auto-generated method stub
		return composantDAO.update(t);
	}

	@Override
	public Composant find(int id) {
		// TODO Auto-generated method stub
		return composantDAO.find(id);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		composantDAO.delete(id);
		
	}

	@Override
	public List<Composant> findAllComposant() {
		// TODO Auto-generated method stub
		return composantDAO.findAllComposant();
	}
	
	@Override
	public List<Composant> findComposantByModule(Module module ) {
		// TODO Auto-generated method stub
		return composantDAO.findComposantByModule(module);
	}

}
