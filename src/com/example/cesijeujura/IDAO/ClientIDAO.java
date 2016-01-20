package com.example.cesijeujura.IDAO;

import java.util.List;

import com.example.cesijeujura.Entities.Client;

public interface ClientIDAO extends GenericIDAO<Client>{

	public List<Client> findAllClient();
}
