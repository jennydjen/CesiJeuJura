package com.example.cesijeujura.IDAO;

import java.util.List;

import com.example.cesijeujura.Entities.Module;
import com.example.cesijeujura.Entities.Quantite_Composant_Module;

public interface ModuleIDAO extends GenericIDAO<Module>{

	public List<Module> findAllModule();
	
	public void deleteComposant(Quantite_Composant_Module composant);
	
}
