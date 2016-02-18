package com.example.cesijeujura.IHM;

import com.example.cesijeujura.CesijeujuraUI;
import com.example.cesijeujura.IEJB.UserIEJB;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification.Type;

public class LoginView extends VerticalLayout {

	private TextField textLogin;
	private PasswordField textPassword;
	private UserIEJB userEJB;
	private Label labelLoginPasswordIncorrect;
	private CesijeujuraUI view;

	public LoginView(CesijeujuraUI view, UserIEJB userEJB) {
		this.userEJB = userEJB;
		this.view = view;
		
		setMargin(true);

		Label labelLogin = new Label("Email");
		addComponent(labelLogin);

		textLogin = new TextField();
		addComponent(textLogin);

		Label labelPassword = new Label("Mot de passe");		
		addComponent(labelPassword);

		textPassword = new PasswordField();

		addComponent(textPassword);

		Button button = new Button("Se connecter");
		addComponent(button);

		labelLoginPasswordIncorrect = new Label("<p style=\"color:rgb(255,0,0)\">Email / Mot de passe incorrect</p>", Label.CONTENT_RAW);
		labelLoginPasswordIncorrect.setVisible(false);
		addComponent(labelLoginPasswordIncorrect);

		textPassword.addValueChangeListener(new ValueChangeListener() {

			@Override
			public void valueChange(ValueChangeEvent event) {
				checkPassword();
			}
		});

		button.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				checkPassword();
			}
		});
	}

	private void checkPassword() {
		String login = textLogin.getValue();
		String password = textPassword.getValue();

		if (userEJB.isUserExist(login, password)) {
			Notification.show("Bienvenue", Type.TRAY_NOTIFICATION);
			view.afficherMenuView();
		} else {
			labelLoginPasswordIncorrect.setVisible(true);
		}
	}
}
