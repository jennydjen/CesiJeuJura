package com.example.cesijeujura.devis;


import com.example.cesijeujura.IHM.popup.Sauvegarde;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Component;
import com.vaadin.ui.PopupView.Content;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class PopupSave extends Window {
	
	
	public PopupSave() {
		setWidth(450.0f, Unit.PIXELS);
		setModal(true);
		
       VerticalLayout layout = new VerticalLayout();
       layout.addComponent(new Sauvegarde());
       
       setContent(layout);
    }

}
