package com.example.cesijeujura.EJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;



import com.example.cesijeujura.Entities.Module;
import com.example.cesijeujura.IDAO.ModuleIDAO;
import com.example.cesijeujura.IEJB.ModuleIEJB;

@Stateless
public class ModuleEJB implements ModuleIEJB{
	
	@Inject
	private ModuleIDAO moduleDAO;
	
	@Override
	public Module create(Module t) {
		// TODO Auto-generated method stub
		return moduleDAO.create(t);
	}

	@Override
	public Module find(int id) {
		// TODO Auto-generated method stub
		return moduleDAO.find(id);
	}

	@Override
	public Module update(Module t) {
		// TODO Auto-generated method stub
		return moduleDAO.update(t);
	}
	
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		moduleDAO.delete(id);
	}

	@Override
	public List<Module> findAllModule() {
		// TODO Auto-generated method stub
		return moduleDAO.findAllModule();
	}

}
