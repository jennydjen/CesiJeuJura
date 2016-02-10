package com.example.cesijeujura;

import javax.inject.Inject;

import com.example.cesijeujura.IEJB.ClientIEJB;
import com.example.cesijeujura.IEJB.ComposantIEJB;
import com.example.cesijeujura.IEJB.DevisIEJB;
import com.example.cesijeujura.IEJB.FichierIEJB;
import com.example.cesijeujura.IEJB.ModuleIEJB;
import com.example.cesijeujura.IEJB.Type_PieceIEJB;
import com.example.cesijeujura.IEJB.UserIEJB;
import com.example.cesijeujura.IHM.MenuView;
import com.vaadin.annotations.Theme;
import com.vaadin.cdi.CDIUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("cesijeujura")
@CDIUI("")
public class CesijeujuraUI extends UI {

	@Inject
	private DevisIEJB devisEJB;
	
	@Inject
	private ClientIEJB clientEJB;
	
	@Inject
	private ModuleIEJB moduleEJB;
	
	@Inject
	private UserIEJB userEJB;
	
	@Inject
	private ComposantIEJB composantEJB;
	
	@Inject
	private Type_PieceIEJB type_PieceEJB;
	
	@Inject
	private FichierIEJB fichiersEJB;
	
	private static MenuView menuView;
	
	/*@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = CesijeujuraUI.class)
	public static class Servlet extends VaadinServlet {
	}*/

	@Override
	protected void init(VaadinRequest request) {
		menuView = new MenuView(devisEJB, clientEJB, moduleEJB, userEJB, composantEJB, type_PieceEJB,fichiersEJB);
		setContent(menuView);

		/*Button button = new Button("Click Me");
		button.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				layout.addComponent(new Label("Thank you for clicking"));
			}
		});
		layout.addComponent(button);*/
	}

	public static MenuView getInstanceMenuView(){
		return menuView;
	}
}