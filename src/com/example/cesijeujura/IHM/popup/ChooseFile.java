package com.example.cesijeujura.IHM.popup;

import java.io.OutputStream;

import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Window;
import com.vaadin.ui.Notification.Type;

public class ChooseFile extends Window{

	public ChooseFile() {
		setWidth(600.0f, Unit.PIXELS);
		setHeight(150.0f, Unit.PIXELS);
		setModal(true);
		FormLayout layout = new FormLayout();
		layout.setMargin(true);
		
		layout.addComponent(new Upload("File", new Upload.Receiver() {

            public OutputStream receiveUpload(String filename, String MIMEType) {
            	// TODO : faire le code pour récupérer le fichier et le mettre dans le tableau
            	Notification.show("Récupérer le fichier "+ filename,
						Type.TRAY_NOTIFICATION);
            	close();
                return null;
            }
        }));

		setContent(layout);
	}
}
