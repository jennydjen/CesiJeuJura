package com.example.cesijeujura.IHM.client;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;

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
public class FicheClient extends VerticalLayout {
	protected Label titleLabel;
	protected Panel identityPanel;
	protected VerticalLayout identiteLayout;
	protected HorizontalLayout nameLayout;
	protected ComboBox civiliteCombo;
	protected TextField nameField;
	protected TextField firstNameField;
	protected TextField referenceField;
	protected HorizontalLayout adresseLayout;
	protected TextField adresseField;
	protected TextField codePostalField;
	protected TextField villeField;
	protected HorizontalLayout contactLayout;
	protected TextField mailField;
	protected TextField phoneField;
	protected Table projectTable;
	protected HorizontalLayout buttonLayout;
	protected Button seeDevisButton;

	public FicheClient() {
		Design.read(this);
	}
}
