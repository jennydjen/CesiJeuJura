package com.example.cesijeujura.IHM.devis;

import java.util.ArrayList;
import java.util.List;

import com.example.cesijeujura.EJB.ClientEJB;
import com.example.cesijeujura.EJB.DevisEJB;
import com.example.cesijeujura.EJB.Type_PieceEJB;
import com.example.cesijeujura.Entities.Client;
import com.example.cesijeujura.Entities.Devis;
import com.example.cesijeujura.Entities.Devis_gamme;
import com.example.cesijeujura.Entities.Etat;
import com.example.cesijeujura.Entities.Gamme;
import com.example.cesijeujura.Entities.Piece;
import com.example.cesijeujura.Entities.Projet;
import com.example.cesijeujura.Entities.Type_Piece;
import com.example.cesijeujura.IEJB.DevisIEJB;
import com.example.cesijeujura.IEJB.Type_PieceIEJB;
import com.example.cesijeujura.IHM.MenuView;
import com.example.cesijeujura.IHM.client.FicheClient;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.data.Item;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.declarative.Design;

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
public class FicheDevis extends VerticalLayout {
	protected VerticalLayout layoutGauche;
	protected HorizontalLayout layoutProjetClient;
	protected TextField projectName;
	protected TextField clientNum;
	protected HorizontalLayout layoutAjout;
	protected ComboBox typePiece;
	protected Button btnAjout;
	protected HorizontalLayout layoutTableau;
	protected Table tabItem;
	protected VerticalLayout layoutDroit;
	protected MenuBar etatProjet;
	protected DateField dateLancement;
	protected DateField datePreDevis;
	protected DateField dateDevis;
	protected Button btnFicheClient;
	private Projet projet = new Projet();
	private Client client = new Client();
	private List<Type_Piece> listTypePiece = new ArrayList<Type_Piece>();
	private Type_PieceIEJB typePieceIEJB ;

	@SuppressWarnings("unchecked")
	public FicheDevis(DevisIEJB devisEJB,int id) {
		Design.read(this);
		
		//listTypePiece=typePieceIEJB.findAllType_Piece();
		
		//typePiece.addItems(listTypePiece);
				
		Devis devis = devisEJB.find(id);
	
		projet = devis.getProjet();
		client = projet.getClient();
		List<Piece> listPiece=projet.getPieces();
		projectName.setEnabled(false);
		projectName.setValue(projet.getNom());
		clientNum.setEnabled(false);
		clientNum.setValue(client.getRef());
		dateLancement.setValue(devis.getDateCreation());
		
		MenuBar.Command projet = new Command() {
			@Override
			public void menuSelected(MenuItem selectedItem) {
				devis.setEtat(Etat.CREER);
			}
		};
		
		MenuBar.Command predevis = new Command() {
			@Override
			public void menuSelected(MenuItem selectedItem) {
				devis.setEtat(Etat.A_TRAITER);
			}
		};
		
		MenuBar.Command etatdevis = new Command() {
			@Override
			public void menuSelected(MenuItem selectedItem) {
				devis.setEtat(Etat.DEVIS);
			}
		};
	
		etatProjet.addItem("Projet", projet);
		etatProjet.addItem("Pr�-devis", predevis);
		etatProjet.addItem("Devis", etatdevis);
		
		tabItem.setSizeFull();
		tabItem.setSelectable(true);
		tabItem.addContainerProperty("Type de pi�ces", String.class, "");
		tabItem.addContainerProperty("Nom", String.class, "");
		tabItem.addContainerProperty("R�ference", String.class, "");
		tabItem.addContainerProperty("Surface", String.class, "");
		tabItem.addContainerProperty("Nb Portes", String.class, "");
		tabItem.addContainerProperty("Nb Fenetres", String.class, "");
		tabItem.addContainerProperty("Prix", String.class, "");
		
		for( Piece piece: listPiece){
			Object newItemId = tabItem.addItem();
			Item row = tabItem.getItem(newItemId);
			String nomTypePiece = piece.getType().getNom();
			String nomPiece = nomTypePiece+" "+piece.getFinition();
			String surfPiece = piece.getSurface()+" m3";
			String nbPortePiece = piece.getNbPorte()+"";
			String nbFenetrePiece = piece.getNbFenetre()+"";
			
			row.getItemProperty("Type de pi�ces").setValue(nomTypePiece);
			row.getItemProperty("Nom").setValue(nomPiece);
			row.getItemProperty("R�ference").setValue("");
			row.getItemProperty("Surface").setValue(surfPiece);
			row.getItemProperty("Nb Portes").setValue(nbPortePiece);
			row.getItemProperty("Nb Fenetres").setValue(nbFenetrePiece);
			row.getItemProperty("Prix").setValue("");
			
			
			
		}
		btnFicheClient.addClickListener(new Button.ClickListener() {
		
			@Override
			public void buttonClick(ClickEvent event) {
				
				removeAllComponents();
				addComponent(new FicheClient(devisEJB, client));
			}
		});
		
		
	}
}
