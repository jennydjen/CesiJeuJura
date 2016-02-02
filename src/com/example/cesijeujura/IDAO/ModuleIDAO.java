package com.example.cesijeujura.IDAO;

import java.util.List;

import com.example.cesijeujura.Entities.Module;

public interface ModuleIDAO extends GenericIDAO<Module>{

	public List<Module> findAllModule();
	
}
