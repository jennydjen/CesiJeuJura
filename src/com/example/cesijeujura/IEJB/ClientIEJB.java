package com.example.cesijeujura.IEJB;

import java.util.List;

import com.example.cesijeujura.IEJB.GenericEJBInterface;
import com.example.cesijeujura.Entities.Client;

public interface ClientIEJB extends GenericEJBInterface<Client> {
	
	public List<Client> findAllClient();
}
