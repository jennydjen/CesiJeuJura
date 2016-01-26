package com.example.cesijeujura.IHM.devis;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import org.vaadin.data.collectioncontainer.CollectionContainer;

import com.example.cesijeujura.Entities.Devis;
import com.example.cesijeujura.IEJB.DevisIEJB;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.cdi.CDIUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.declarative.Design;

/**
 * !! DO NOT EDIT THIS FILE !!
 * 
 * This class is generated by Vaadin Designer and will be overwritten.
 * 
 * Please make a subclass with logic and additional interfaces as needed, e.g
 * class LoginView extends LoginDesign implements View { � }
 */
@DesignRoot
@AutoGenerated
@SuppressWarnings("serial")
public class ListeDevis extends VerticalLayout {
	protected Label titleLabel;
	protected HorizontalLayout layout;
	protected VerticalLayout searchLayout;
	protected Label searchAdvanceLabel;
	protected GridLayout searchAdvanceLayout;
	protected Label clientLabel;
	protected ComboBox clientCombo;
	protected Label etatLabel;
	protected ComboBox etatCombo;
	protected Button createButton;
	protected HorizontalLayout devisLayout;
	protected Table devisTable;
	protected VerticalLayout buttonLayout;
	protected Button openButton;
	protected Button modifButton;
	protected Button validateButton;
	protected Button deleteButton;
	
	public ListeDevis(final DevisIEJB devisEJB) {
		Design.read(this);
		
		createButton.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				Notification.show("The button create was clicked",
                        Type.TRAY_NOTIFICATION);
			}
		});

		openButton.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				Notification.show("The button open was clicked",
                        Type.TRAY_NOTIFICATION);
			}
		});

		modifButton.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				Notification.show("The button modif was clicked",
                        Type.TRAY_NOTIFICATION);
			}
		});

		validateButton.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				Notification.show("The button validate was clicked",
                        Type.TRAY_NOTIFICATION);
			}
		});

		deleteButton.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				Notification.show("The button delete was clicked",
                        Type.TRAY_NOTIFICATION);
			}
		});

		List<Devis> devis = devisEJB.findAllDevis();
		System.out.println(" --------------------------------- Nbr Devis "+devis.size() + " --------------------------------- ");
		/*devisTable.setContainerDataSource(CollectionContainer.fromBeans(devis));
		devisTable.setSelectable(true);
		// selection des colonnes visibles
		devisTable.setVisibleColumns(new Object[] { "ref", "etat"});
		devisTable.setColumnHeaders(new String[] { "R�f�rence", "Etat"});*/

	}
}
