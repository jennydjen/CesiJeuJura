package com.example.cesijeujura.IHM;

import com.example.cesijeujura.EJB.Type_PieceEJB;
import com.example.cesijeujura.Entities.Client;
import com.example.cesijeujura.IEJB.ClientIEJB;
import com.example.cesijeujura.IEJB.ComposantIEJB;
import com.example.cesijeujura.IEJB.DevisIEJB;
import com.example.cesijeujura.IEJB.FichierIEJB;
import com.example.cesijeujura.IEJB.ModuleIEJB;
import com.example.cesijeujura.IEJB.Type_PieceIEJB;
import com.example.cesijeujura.IEJB.UserIEJB;
import com.example.cesijeujura.IHM.client.FicheClient;
import com.example.cesijeujura.IHM.client.ListeClients;
import com.example.cesijeujura.IHM.devis.EditionComposant;
import com.example.cesijeujura.IHM.devis.FicheDevis;
import com.example.cesijeujura.IHM.devis.ListeDevis;
import com.example.cesijeujura.IHM.devis.ListeDevisBureauEtudes;
import com.example.cesijeujura.IHM.devis.TraitementDevisView;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;

/** 
 * !! DO NOT EDIT THIS FILE !!
 * 
 * This class is generated by Vaadin Designer and will be overwritten.
 * 
 * Please make a subclass with logic and additional interfaces as needed,
 * e.g class LoginView extends LoginDesign implements View { � }
 */
@DesignRoot
@AutoGenerated
@SuppressWarnings("serial")
public class MenuView extends VerticalLayout {
	private MenuBar menuBar;
	private VerticalLayout contenu;
	private DevisIEJB devisEJB;
	private Type_PieceIEJB typePieceEJB;
	private FichierIEJB fichiersEJB;
	
	public MenuView(final DevisIEJB devisEJB, final ClientIEJB clientEJB, final ModuleIEJB moduleEJB, final UserIEJB userEJB , final ComposantIEJB composantEJB
			,final Type_PieceIEJB typePieceEJB,final FichierIEJB fichiersEJB) {
		Design.read(this);
		this.devisEJB = devisEJB;
		this.typePieceEJB = typePieceEJB;
		this.fichiersEJB = fichiersEJB;
				
		MenuBar.Command clients = new Command() {
			@Override
			public void menuSelected(MenuItem selectedItem) {
				contenu.removeAllComponents();
				ListeClients vue = new ListeClients(clientEJB);
				contenu.addComponent(vue);
			}
		};
				
		MenuBar.Command devis = new Command() {
			@Override
			public void menuSelected(MenuItem selectedItem) {
				contenu.removeAllComponents();
				contenu.addComponent(new ListeDevis(devisEJB, clientEJB));
				
			}
		};
		
		MenuBar.Command ficheClient = new Command() {
			@Override
			public void menuSelected(MenuItem selectedItem) {
				contenu.removeAllComponents();
				contenu.addComponent(new FicheClient(devisEJB, clientEJB.find(1)));
			}
		};
		
		MenuBar.Command editerComposant = new Command() {
			@Override
			public void menuSelected(MenuItem selectedItem) {
				contenu.removeAllComponents();
				contenu.addComponent(new EditionComposant(devisEJB, composantEJB, moduleEJB));
			}
		};		
		
		MenuBar.Command traitementDevis = new Command() {
			@Override
			public void menuSelected(MenuItem selectedItem) {
				contenu.removeAllComponents();
				contenu.addComponent(new TraitementDevisView(moduleEJB,fichiersEJB));
			}
		};
		MenuBar.Command ficheDevis = new Command() {
			@Override
			
			public void menuSelected(MenuItem selectedItem) {
				int id=1;
				contenu.removeAllComponents();
				contenu.addComponent(new FicheDevis(devisEJB, id, typePieceEJB));
			}
		};
		MenuBar.Command listeDevisBureau = new Command() {
			@Override
			public void menuSelected(MenuItem selectedItem) {
				contenu.removeAllComponents();
				contenu.addComponent(new ListeDevisBureauEtudes(devisEJB,typePieceEJB));
			}
		};
		
		menuBar.addItem("Clients", clients);
		menuBar.addItem("Devis", devis);
		menuBar.addItem("Fiche client (a enlever)", ficheClient);
		menuBar.addItem("Editer composant (a enlever)", editerComposant);
		menuBar.addItem("Traitement devis (a enlever)", traitementDevis);
		menuBar.addItem("Liste Devis Bureau(a enlever)", listeDevisBureau);
		menuBar.addItem("Fiche Devis(a enlever)", ficheDevis);
	}
	
	public void afficherFicheClient(Client client){
		contenu.removeAllComponents();
		contenu.addComponent(new FicheClient(devisEJB, client));
	}
	
	public void afficherFicheDevis(Integer idDevis){
		contenu.removeAllComponents();
		contenu.addComponent(new FicheDevis(devisEJB, idDevis, typePieceEJB));
	}
}
