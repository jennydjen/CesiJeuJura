package com.example.cesijeujura.IHM.devis;

import java.util.List;

import com.example.cesijeujura.Entities.Composant;
import com.example.cesijeujura.Entities.Module;
import com.example.cesijeujura.Entities.Quantite_Composant_Module;
import com.example.cesijeujura.IEJB.ComposantIEJB;
import com.example.cesijeujura.IEJB.ModuleIEJB;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;

public class PopupAjoutComposant extends Window {
	private EditionComposant view;

	public PopupAjoutComposant(Module module, ModuleIEJB moduleiejb, ComposantIEJB composantEJB) {
		setWidth(450.0f, Unit.PIXELS);
		setHeight(450.0f, Unit.PIXELS);
		setModal(true);
		FormLayout layout = new FormLayout();
		layout.setMargin(true);
		Label lblnomcomposant = new Label("Nom Du Composant");
		ComboBox composantCombo = new ComboBox();
		List<Composant> composants = composantEJB.findAllComposant();
		for(Composant c : composants){
			composantCombo.addItem(c);
		}
				
		Label lblquantitecomposant = new Label("Quantité");
		TextField txtquantitecomposant = new TextField();
		Button buttonvalider = new Button("Valider");

		layout.addComponent(lblnomcomposant);
		layout.addComponent(composantCombo);
		layout.addComponent(lblquantitecomposant);
		layout.addComponent(txtquantitecomposant);
		layout.addComponent(buttonvalider);
		buttonvalider.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				Composant composant = (Composant) composantCombo.getValue();
				Quantite_Composant_Module quantitecomposant = new Quantite_Composant_Module();
				quantitecomposant.setComposant(composant);
				quantitecomposant.setNb(Integer.parseInt(txtquantitecomposant
						.getValue()));
				quantitecomposant.setModule(module);
				module.getComposants().add(quantitecomposant);
				moduleiejb.update(module);
				if(view != null){
					view.refreshTable();
				}
				Notification.show("Votre composant a été ajouté",
						Type.TRAY_NOTIFICATION);
				close();
			}
		});

		setContent(layout);
	}
	
	public void setView(EditionComposant view) {
		this.view = view;
	}
}
