package com.example.cesijeujura.IHM.client;

import java.util.HashMap;
import java.util.Map;

import com.example.cesijeujura.CesijeujuraUI;
import com.example.cesijeujura.Entities.Client;
import com.example.cesijeujura.IEJB.ClientIEJB;
import com.vaadin.data.Item;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Table;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.VerticalLayout;

public class ListeClients extends HorizontalLayout {

	/** */
	private static final long serialVersionUID = 1L;
	private Table clientsTable;
	private Button ficheClientButton;
	private ClientIEJB clientEJB;
	private Map<Integer, Client> mapsClient;

	public ListeClients(ClientIEJB clientEJB) {
		this.clientEJB = clientEJB;
		VerticalLayout tableLayout = new VerticalLayout();

		clientsTable = new Table();
		clientsTable.setHeight(500, Unit.PIXELS);
		tableLayout.addComponent(clientsTable);

		addComponent(tableLayout);

		clientsTable.addValueChangeListener(new ValueChangeListener() {

			@Override
			public void valueChange(ValueChangeEvent event) {
				// TODO Auto-generated method stub
				if (clientsTable.getValue() != null) {
					ficheClientButton.setEnabled(true);
				} else {
					ficheClientButton.setEnabled(false);
				}
			}
		});

		VerticalLayout buttonLayout = new VerticalLayout();

		ficheClientButton = new Button("Voir fiche client");
		ficheClientButton.setEnabled(false);
		buttonLayout.addComponent(ficheClientButton);

		addComponent(buttonLayout);

		ficheClientButton.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub	
				CesijeujuraUI.getInstanceMenuView().afficherFicheClient(mapsClient.get((Integer) clientsTable
								.getValue()));
			}
		});
		
		initialiseComposant();
	}

	private void initialiseComposant() {
		clientsTable.setSizeFull();
		clientsTable.setSelectable(true);

		clientsTable.addContainerProperty("Civilité", String.class, "");
		clientsTable.addContainerProperty("Nom Prenom", Client.class, null);
		clientsTable.addContainerProperty("Adresse", String.class, "");
		clientsTable.addContainerProperty("Code postal", String.class, "");
		clientsTable.addContainerProperty("Ville", String.class, "");

		mapsClient = new HashMap<Integer, Client>();
		int i = 1;
		for (Client c : clientEJB.findAllClient()) {
			mapsClient.put(i, c);
			String civilite = "";

			switch (c.getCivilite()) {
			case 1:
				civilite = "M";
				break;
			case 2:
				civilite = "Mme";
				break;
			case 3:
				civilite = "Mlle";
				break;
			}

			Object newItemId = clientsTable.addItem();
			Item row1 = clientsTable.getItem(newItemId);
			row1.getItemProperty("Civilité").setValue(civilite);
			row1.getItemProperty("Nom Prenom").setValue(c);
			row1.getItemProperty("Adresse").setValue(c.getAdresse());
			row1.getItemProperty("Code postal").setValue(c.getCp());
			row1.getItemProperty("Ville").setValue(c.getVille());
			i++;
		}
	}
}
