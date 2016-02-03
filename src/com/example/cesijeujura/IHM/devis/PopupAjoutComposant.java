package com.example.cesijeujura.IHM.devis;



import com.example.cesijeujura.Entities.Composant;
import com.example.cesijeujura.Entities.Module;
import com.example.cesijeujura.Entities.Quantite_Composant_Module;
import com.example.cesijeujura.IEJB.ModuleIEJB;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;

public class PopupAjoutComposant extends Window {
	
	
	public PopupAjoutComposant(Module module, ModuleIEJB moduleiejb) {
		setWidth(450.0f, Unit.PIXELS);
		setHeight(450.0f, Unit.PIXELS);
		setModal(true);
		FormLayout layout = new FormLayout();
		layout.setMargin(true);
		//setCompositionRoot(layout);
       //VerticalLayout layout = new VerticalLayout();
   	Label lblnomcomposant = new Label("Nom Du Composant");	
   	TextField txtnomcomposant = new TextField();
   	Label lblquantitecomposant = new Label("Quantité");		
   	TextField txtquantitecomposant = new TextField();
   	Button buttonvalider = new Button("Valider");
   	
   	layout.addComponent(lblnomcomposant);
   	layout.addComponent(txtnomcomposant);
   	layout.addComponent(txtnomcomposant);
   	layout.addComponent(txtquantitecomposant);
   	layout.addComponent(buttonvalider);
   	buttonvalider.addClickListener(new Button.ClickListener() {
		
		@Override
		public void buttonClick(ClickEvent event) {
			// TODO Auto-generated method stub
			Composant composant = new Composant();
			composant.setNom(txtnomcomposant.getValue());
			composant.setPrix(0F);
			Quantite_Composant_Module quantitecomposant = new Quantite_Composant_Module();
			quantitecomposant.setComposant(composant);
			quantitecomposant.setNb( Integer.parseInt(txtquantitecomposant.getValue()));
			quantitecomposant.setModule(module);
			module.getComposants().add(quantitecomposant);
			moduleiejb.update(module);		
		}
	});

       
       setContent(layout);
    }

}
