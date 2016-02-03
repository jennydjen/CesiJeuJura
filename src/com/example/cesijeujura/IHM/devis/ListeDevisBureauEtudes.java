package com.example.cesijeujura.IHM.devis;

import java.util.Date;
import java.util.List;

import com.example.cesijeujura.Entities.Client;
import com.example.cesijeujura.Entities.Devis;
import com.example.cesijeujura.IEJB.DevisIEJB;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.data.Item;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;
import com.vaadin.ui.Notification.Type;

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
public class ListeDevisBureauEtudes extends VerticalLayout {
	protected TextField filedRecherche;
	protected Table tabDevis;
	protected Button btnOuvrir;
	protected Button btnModif;
	protected Button btnValider;
	protected Button btnSupprimer;
	

	public ListeDevisBureauEtudes(DevisIEJB devisEJB) {
 		Design.read(this);
		List<Devis> devis = devisEJB.findAllDevis();
		try{
			tabDevis.setSizeFull();
			tabDevis.setSelectable(true);
			tabDevis.setImmediate(true);
			tabDevis.addContainerProperty("Ref", String.class, "");
			tabDevis.addContainerProperty("Client", Client.class, "");
			tabDevis.addContainerProperty("Etat", String.class, "");
			tabDevis.addContainerProperty("Date", Date.class, null);
			
		}catch(Error e){
			System.out.println(e.toString());
		}
		for (Devis d : devis) {
			Object newItemId = tabDevis.addItem();
			Item row1 = tabDevis.getItem(newItemId);
			row1.getItemProperty("Ref").setValue(d.getRef());
			row1.getItemProperty("Client").setValue(d.getProjet().getClient());
			row1.getItemProperty("Etat").setValue(d.getEtat().toString());
			row1.getItemProperty("Date").setValue(d.getDateCreation());
		}
		
		btnOuvrir.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				Notification.show("The button validate was clicked",
						Type.TRAY_NOTIFICATION);
			}
		});
		
		tabDevis.addValueChangeListener(new ValueChangeListener(){

			@Override
			public void valueChange(ValueChangeEvent event) {
				// TODO Auto-generated method stub
				Notification.show(tabDevis.getItem(tabDevis.getValue()).toString(),
						Type.TRAY_NOTIFICATION);
				
			}
			
		});
		
		btnModif.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				
				Notification.show("The button validate was clicked",
						Type.TRAY_NOTIFICATION);
			}
		});
		btnSupprimer.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				Notification.show("The button validate was clicked",
						Type.TRAY_NOTIFICATION);
			}
		});
		btnValider.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				Notification.show("The button validate was clicked",
						Type.TRAY_NOTIFICATION);
			}
		});
 	}
}
