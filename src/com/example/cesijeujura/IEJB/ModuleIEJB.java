package com.example.cesijeujura.IEJB;

import java.util.List;

import com.example.cesijeujura.Entities.Module;

public interface ModuleIEJB extends GenericEJBInterface<Module>{
	
	public List<Module> findAllModule();
}
