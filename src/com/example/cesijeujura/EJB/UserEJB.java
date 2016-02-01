package com.example.cesijeujura.EJB;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.example.cesijeujura.Entities.Utilisateur;
import com.example.cesijeujura.IDAO.UserIDAO;
import com.example.cesijeujura.IEJB.UserIEJB;

@Stateless
public class UserEJB implements UserIEJB{
	
	@Inject
	private UserIDAO userDAO;
	
	@Override
	public Utilisateur create(Utilisateur t) {
		// TODO Auto-generated method stub
		return userDAO.create(t);
	}

	@Override
	public Utilisateur find(int id) {
		// TODO Auto-generated method stub
		return userDAO.find(id);
	}

	@Override
	public Utilisateur update(Utilisateur t) {
		// TODO Auto-generated method stub
		return userDAO.update(t);
	}
	
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		userDAO.delete(id);
	}
	
	@Override
	public boolean isUserExist(String login, String password) {
		// TODO Auto-generated method stub
		return userDAO.isUserExist(login,password);
	}
	
	@Override
	public boolean isMailUserExist(String mail) {
		// TODO Auto-generated method stub
		return userDAO.isMailUserExist(mail);
	}


}
