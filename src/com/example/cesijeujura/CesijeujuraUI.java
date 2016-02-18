package com.example.cesijeujura;

import javax.inject.Inject;

import com.example.cesijeujura.Entities.Utilisateur;
import com.example.cesijeujura.IEJB.ClientIEJB;
import com.example.cesijeujura.IEJB.ComposantIEJB;
import com.example.cesijeujura.IEJB.DevisIEJB;
import com.example.cesijeujura.IEJB.FichierIEJB;
import com.example.cesijeujura.IEJB.ModuleIEJB;
import com.example.cesijeujura.IEJB.PieceIEJB;
import com.example.cesijeujura.IEJB.Type_PieceIEJB;
import com.example.cesijeujura.IEJB.UserIEJB;
import com.example.cesijeujura.IHM.LoginView;
import com.example.cesijeujura.IHM.MenuView;
import com.vaadin.annotations.Theme;
import com.vaadin.cdi.CDIUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
@Theme("cesijeujura")
@CDIUI("")
public class CesijeujuraUI extends UI {

	@Inject
	private DevisIEJB devisEJB;
	
	@Inject
	private ClientIEJB clientEJB;
	
	@Inject
	private ModuleIEJB moduleEJB;
	
	@Inject
	private UserIEJB userEJB;
	
	@Inject
	private ComposantIEJB composantEJB;
	
	@Inject
	private Type_PieceIEJB type_PieceEJB;
	
	@Inject
	private PieceIEJB pieceEJB;
	
	@Inject
	private FichierIEJB fichiersEJB;
	
	private static MenuView menuView;
	private static CesijeujuraUI instance;
	private Utilisateur user;
	
	@Override
	protected void init(VaadinRequest request) {
		instance = this;
		LoginView login = new LoginView(this, userEJB);
		setContent(login);
	}

	public void afficherMenuView(){
		menuView = new MenuView(devisEJB, clientEJB, moduleEJB, userEJB, composantEJB, type_PieceEJB,fichiersEJB, pieceEJB);
		setContent(menuView);
	}
	
	public void afficherLoginView(){
		setUser(null);
		LoginView login = new LoginView(this, userEJB);
		setContent(login);
	}
	
	public static MenuView getInstanceMenuView(){
		return menuView;
	}
	
	public static CesijeujuraUI getInstance() {
		return instance;
	}
	
	public void setUser(Utilisateur user) {
		this.user = user;
	}
	
	public Utilisateur getUser() {
		return user;
	}
}