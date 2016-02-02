package com.example.cesijeujura.IDAO;

import java.util.List;

import com.example.cesijeujura.Entities.Composant;
import com.example.cesijeujura.Entities.Module;

public interface ComposantIDAO extends GenericIDAO<Composant>{

	public List<Composant> findAllComposant();

	public List<Composant> findComposantByModule(Module module);
}