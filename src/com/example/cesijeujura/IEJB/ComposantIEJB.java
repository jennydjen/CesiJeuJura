package com.example.cesijeujura.IEJB;

import java.util.List;

import com.example.cesijeujura.Entities.Composant;
import com.example.cesijeujura.Entities.Module;


public interface ComposantIEJB extends GenericEJBInterface<Composant>{
	
	public List<Composant> findAllComposant();
	
	public List<Composant> findComposantByModule(Module module );
	
}