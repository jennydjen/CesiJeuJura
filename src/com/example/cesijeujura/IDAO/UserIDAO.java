package com.example.cesijeujura.IDAO;

import com.example.cesijeujura.Entities.Utilisateur;

public interface UserIDAO extends GenericIDAO<Utilisateur> {

	public boolean isUserExist(String login, String password);

	public boolean isMailUserExist(String mail);
}
