package com.example.cesijeujura.IHM.devis;

import java.util.ArrayList;
import java.util.Collection;
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
import com.example.cesijeujura.IEJB.PieceIEJB;
import com.example.cesijeujura.IEJB.Type_PieceIEJB;
import com.example.cesijeujura.IHM.MenuView;
import com.example.cesijeujura.IHM.client.FicheClient;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.data.Item;
import com.vaadin.ui.AbstractSelect.ItemCaptionMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
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
	private List<Piece> listPieceAjout = new ArrayList<Piece>();

	@SuppressWarnings("unchecked")
	public FicheDevis(DevisIEJB devisEJB,int id,Type_PieceIEJB typePieceEJB, PieceIEJB pieceEJB) {
		Design.read(this);
		
		
		
		listTypePiece=typePieceEJB.findAllType_Piece();
		//typePiece = new ComboBox("Piece", listTypePiece);
		typePiece.addItems(listTypePiece);
		//typePiece.addContainerProperty("selection", Type_Piece.class, "");
		
		/*for(Type_Piece piece:listTypePiece){
			Object itemId = typePiece.addItem();
			Item row = typePiece.getItem(itemId);
			row.getItemProperty("selection").setValue(piece);
			
			//typePiece.setItemCaptionPropertyId(piece.getId());
			//typePiece.setItemCaptionMode(ItemCaptionMode.PROPERTY);
			//(piece, piece.getNom());
		}*/
		
				
		Devis devis = devisEJB.find(id);
	
		projet = devis.getProjet();
		client = projet.getClient();
		List<Piece> listPiece=projet.getPieces();
		projectName.setEnabled(false);
		projectName.setValue(projet.getNom());
		clientNum.setEnabled(false);
		clientNum.setValue(client.getRef());
		dateLancement.setValue(devis.getDateCreation());
		Button save = new Button("Enregistrer");
		layoutGauche.addComponent(save);
		
		save.addClickListener(new Button.ClickListener() {
			
			public void buttonClick(ClickEvent event) {
				
				Collection<?> tab= tabItem.getItemIds();
				for(Object item:tab){
					tabItem.getItem(item);
				}
				
				// id similaire avec liste donc v�rifier avec la liste pour update 
				
				//Liste de nouvelle entr�e � ins�rer 
			}
		});
		
		MenuBar.Command btnprojet = new Command() {
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
	
		etatProjet.addItem("Projet", btnprojet);
		etatProjet.addItem("Pr�-devis", predevis);
		etatProjet.addItem("Devis", etatdevis);
		
		tabItem.setSizeFull();
		tabItem.setSelectable(true);
		tabItem.setEditable(true);
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
		
		btnAjout.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				boolean selected = typePiece.isSelected(typePiece.getValue());
		
				Type_Piece type_piece =  (Type_Piece) typePiece.getValue();
				if(selected){
					typePiece.getValue();
					Notification.show(typePiece.getValue().toString()+" "+typePiece.getItem(typePiece.getValue()).toString(),
							Type.TRAY_NOTIFICATION);
					Piece piece = new Piece();
					piece.setType(type_piece);
					piece.setProjet(projet);
				
					Object newItemId = tabItem.addItem();
					Item row = tabItem.getItem(newItemId);
					String nomTypePiece = piece.getType().getNom();
					row.getItemProperty("Type de pi�ces").setValue(nomTypePiece);
					
				}
				
			}
		});
		btnFicheClient.addClickListener(new Button.ClickListener() {
		
			@Override
			public void buttonClick(ClickEvent event) {
				
				removeAllComponents();
				addComponent(new FicheClient(devisEJB, client));
			}
		});
		
		
	}
}
