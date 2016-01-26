package com.example.cesijeujura;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;

import com.example.cesijeujura.IEJB.DevisIEJB;
import com.example.cesijeujura.IHM.MenuView;
import com.example.cesijeujura.IHM.client.FicheClient;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.cdi.CDIUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("cesijeujura")
@CDIUI("")
public class CesijeujuraUI extends UI {

	@Inject
	private DevisIEJB devisEJB;
	
	/*@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = CesijeujuraUI.class)
	public static class Servlet extends VaadinServlet {
	}*/

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new MenuView(devisEJB);
		//layout.setMargin(true);
		setContent(layout);

		/*Button button = new Button("Click Me");
		button.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				layout.addComponent(new Label("Thank you for clicking"));
			}
		});
		layout.addComponent(button);*/
	}

}