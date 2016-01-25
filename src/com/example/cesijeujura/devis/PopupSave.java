package com.example.cesijeujura.devis;


import com.example.cesijeujura.IHM.popup.Sauvegarde;
import com.vaadin.ui.Component;
import com.vaadin.ui.PopupView.Content;
import com.vaadin.ui.VerticalLayout;

public class PopupSave implements Content {
	
	
	public PopupSave() {
       VerticalLayout layout = new VerticalLayout();
       layout.addComponent(new Sauvegarde());
       
    }
	@Override
	public String getMinimizedValueAsHTML() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Component getPopupComponent() {
		// TODO Auto-generated method stub
		return null;
	}

}
