package com.example.cesijeujura.EJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.example.cesijeujura.IDAO.ClientIDAO;
import com.example.cesijeujura.IEJB.ClientIEJB;
import com.example.cesijeujura.Entities.Client;

@Stateless
public class ClientEJB implements ClientIEJB {
	
	@Inject
	private ClientIDAO clientDAO; 

	@Override
	public Client create(Client t) {
		// TODO Auto-generated method stub
		return clientDAO.create(t);
	}

	@Override
	public Client find(int id) {
		// TODO Auto-generated method stub
		return clientDAO.find(id);
	}

	@Override
	public Client update(Client t) {
		// TODO Auto-generated method stub
		return clientDAO.update(t);
	}
	
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		clientDAO.delete(id);
	}

	@Override
	public List<Client> findAllClient() {
		// TODO Auto-generated method stub
		return clientDAO.findAllClient();
	}
	
}
