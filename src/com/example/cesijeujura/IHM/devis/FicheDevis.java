package com.example.cesijeujura.IHM.devis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.remote.server.handler.RefreshPage;

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
import com.vaadin.ui.CheckBox;
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
	private List<Integer> listPieceUpdate = new ArrayList<Integer>();
	private List<Integer> listPieceAjout = new ArrayList<Integer>();
	private Map<Integer,Type_Piece> mapTypePiece;
	private Map<Integer,Piece> mapPiece;
	private int idMap=0;
	
	
	@SuppressWarnings("unchecked")
	public FicheDevis(DevisIEJB devisEJB,int id,Type_PieceIEJB typePieceEJB, PieceIEJB pieceEJB) {
		Design.read(this);
		
		listTypePiece=typePieceEJB.findAllType_Piece();
		//typePiece = new ComboBox("Piece", listTypePiece);
		typePiece.addItems(listTypePiece);
		//typePiece.addContainerProperty("selection", Type_Piece.class, "");
		
		
		
				
		Devis devis = devisEJB.find(id);
	
		projet = devis.getProjet();
		client = projet.getClient();
		
		projectName.setEnabled(false);
		projectName.setValue(projet.getNom());
		clientNum.setEnabled(false);
		clientNum.setValue(client.getRef());
		dateLancement.setValue(devis.getDateCreation());
		

		CheckBox editable = new CheckBox("Editable", false);
		editable.addValueChangeListener(valueChange -> // Java 8
		tabItem.setEditable((Boolean) editable.getValue()));
		
		layoutGauche.addComponent(editable);
		Button save = new Button("Enregistrer");
		layoutGauche.addComponent(save);
		
		save.addClickListener(new Button.ClickListener() {
			
			public void buttonClick(ClickEvent event) {
				
				Collection<?> tab= tabItem.getItemIds();	
				
				for(Object item:tab){
					Item itemTemp= tabItem.getItem(item);
					Type_Piece type_piece= mapTypePiece.get(item);
					
					if(listPieceUpdate.contains(item)){
						Piece pieceUp = mapPiece.get(item);
						pieceUp.setType(type_piece);
						pieceUp.setSurface((int) itemTemp.getItemProperty("Surface").getValue());
						pieceUp.setNbFenetre((int) itemTemp.getItemProperty("Nb Fenetres").getValue());
						pieceUp.setNbPorte((int) itemTemp.getItemProperty("Nb Portes").getValue());
						pieceEJB.update(pieceUp);
						
					}else if(listPieceAjout.contains(item)){
						Piece pieceAdd = new Piece();
						pieceAdd.setProjet(projet);
						pieceAdd.setType(type_piece);
						pieceAdd.setSurface((int) itemTemp.getItemProperty("Surface").getValue());
						pieceAdd.setNbFenetre((int) itemTemp.getItemProperty("Nb Fenetres").getValue());
						pieceAdd.setNbPorte((int) itemTemp.getItemProperty("Nb Portes").getValue());
						pieceAdd.setFinition("vide");
						pieceAdd.setForme("triangle");
						pieceAdd.setNumEtage(1);
						
						projet.getPieces().add(pieceAdd);
						pieceEJB.create(pieceAdd);
						mapPiece.put((int)item, pieceAdd);
					}
					
				}
				
				generateTable(devisEJB, id);
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
		//tabItem.setEditable(true);
		tabItem.addContainerProperty("Type de pi�ces", String.class, "");
		tabItem.addContainerProperty("Nom", String.class, "");
		tabItem.addContainerProperty("R�ference", String.class, "");
		tabItem.addContainerProperty("Surface", Integer.class, 0);
		tabItem.addContainerProperty("Nb Portes", Integer.class, 0);
		tabItem.addContainerProperty("Nb Fenetres", Integer.class, 0);
		tabItem.addContainerProperty("Prix", String.class, "");
		
		
		generateTable(devisEJB, id);
		
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
					/*Piece piece = new Piece();
					piece.setType(type_piece);*/
					
					Object newItemId = new Object();
					try{
						newItemId = tabItem.addItem();
						
					}catch(Exception e){
						System.out.println(e.getMessage()+" "+e);
					}
					Item row = tabItem.getItem(newItemId);
					//Item row = tabItem.getItem(idMap);
					String nomTypePiece = type_piece.getNom();
					row.getItemProperty("Type de pi�ces").setValue(nomTypePiece);
					listPieceAjout.add(idMap);
					mapTypePiece.put(idMap, type_piece);
					idMap++;
					
					
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


	private void generateTable(DevisIEJB devisEJB, int id) {
		Devis devis = devisEJB.find(id);
		
		projet = devis.getProjet();
		tabItem.removeAllItems();
		List<Piece> listPiece=projet.getPieces();
		mapTypePiece = new HashMap<Integer, Type_Piece>();
		mapPiece = new HashMap<Integer,Piece>();
		idMap=1;
		for( Piece piece: listPiece){
			Object newItemId = tabItem.addItem();
			Item row = tabItem.getItem(newItemId);
			listPieceUpdate.add(idMap);
			String nomTypePiece = piece.getType().getNom();
			String nomPiece = nomTypePiece+" "+piece.getFinition();
			int surfPiece = piece.getSurface();
			int nbPortePiece = piece.getNbPorte();
			int nbFenetrePiece = piece.getNbFenetre();
			
			row.getItemProperty("Type de pi�ces").setValue(nomTypePiece);
			row.getItemProperty("Nom").setValue(nomPiece);
			row.getItemProperty("R�ference").setValue("");
			row.getItemProperty("Surface").setValue(surfPiece);
			row.getItemProperty("Nb Portes").setValue(nbPortePiece);
			row.getItemProperty("Nb Fenetres").setValue(nbFenetrePiece);
			row.getItemProperty("Prix").setValue("");
			mapTypePiece.put(idMap, piece.getType());
			mapPiece.put(idMap, piece);
			idMap++;
			
		}
	}
}
