package com.example.cesijeujura.IEJB;

import com.example.cesijeujura.Entities.Utilisateur;
import com.example.cesijeujura.IDAO.GenericIDAO;

public interface UserIEJB extends GenericIDAO<Utilisateur> {

		public boolean isUserExist(String login, String password);

		public boolean isMailUserExist(String mail);
}		
