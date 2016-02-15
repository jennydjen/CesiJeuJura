package com.example.cesijeujura.IHM.devis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.cesijeujura.Entities.Client;
import com.example.cesijeujura.Entities.Composant;
import com.example.cesijeujura.Entities.Module;
import com.example.cesijeujura.Entities.Quantite_Composant_Module;
import com.example.cesijeujura.IEJB.ComposantIEJB;
import com.example.cesijeujura.IEJB.DevisIEJB;
import com.example.cesijeujura.IEJB.ModuleIEJB;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.data.Item;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification.Type;
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
public class EditionComposant extends VerticalLayout {
	protected Label lblTitle;
	protected HorizontalLayout composantsLayout;
	protected Table composantTable;
	protected VerticalLayout buttonLayout;
	protected Button addButton;
	protected Button deleteButton;
	// protected ComboBox composantCombo;
	protected HorizontalLayout closeLayout;
	protected Button closeButton;
	private Map<Integer, Quantite_Composant_Module> maps;
	private ModuleIEJB moduleEJB;
	private Module module;

	public EditionComposant(DevisIEJB devisEJB, ComposantIEJB composantEJB,
			ModuleIEJB moduleEJB) {
		Design.read(this);
		this.moduleEJB = moduleEJB;
		module = moduleEJB.findAllModule().get(0);

		addButton.setEnabled(true);
		addButton.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				PopupAjoutComposant popup = new PopupAjoutComposant(module,
						moduleEJB,composantEJB);
				getUI().addWindow(popup);
				popup.setView(EditionComposant.this);
				popup.setVisible(true);
			}
		});

		deleteButton.setEnabled(true);
		deleteButton.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				Integer index = (Integer) composantTable.getValue();
				Quantite_Composant_Module quantitecomposant = maps.get(index);
				module.getComposants().remove(quantitecomposant);
				moduleEJB.deleteComposant(quantitecomposant);				
				Notification.show("Votre composant a �t� supprim�",
						Type.TRAY_NOTIFICATION);
				refreshTable();
			}
		});

		refreshTable();
	}

	public void refreshTable() {
		module = moduleEJB.find(module.getId());
		composantTable.removeAllItems();
		composantTable.setSizeFull();
		composantTable.setSelectable(true);

		composantTable.addContainerProperty("Composant", String.class, "");
		composantTable.addContainerProperty("Nombre", Integer.class,
				Integer.MIN_VALUE);

		maps = new HashMap<Integer, Quantite_Composant_Module>();
		Integer tmp = 1;
		for (Quantite_Composant_Module c : module.getComposants()) {
			Object newItemId = composantTable.addItem(tmp);
			Item row1 = composantTable.getItem(tmp);
			row1.getItemProperty("Composant").setValue(c.getComposant().getNom());
			row1.getItemProperty("Nombre").setValue(c.getNb());
			maps.put(tmp, c);
			tmp++;
		}
	}
}
