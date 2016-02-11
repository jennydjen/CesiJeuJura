package com.example.cesijeujura.IHM.popup;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.example.cesijeujura.Entities.Devis;
import com.example.cesijeujura.Entities.Fichier;
import com.example.cesijeujura.IEJB.FichierIEJB;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.FailedEvent;
import com.vaadin.ui.Upload.FinishedEvent;
import com.vaadin.ui.Upload.StartedEvent;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.Window;
import com.vaadin.ui.Notification.Type;


public class ChooseFile extends Window implements Upload.StartedListener,	

		Upload.ProgressListener, Upload.FailedListener,
		Upload.SucceededListener, Upload.FinishedListener {
		
		private Devis devis;
		private FichierIEJB fichierEJB;
		
	
	public ChooseFile(Devis devis,FichierIEJB fichierEJB) {
		setWidth(600.0f, Unit.PIXELS);
		setHeight(150.0f, Unit.PIXELS);
		setModal(true);
		FormLayout layout = new FormLayout();
		layout.setMargin(true);
		this.devis = devis;
		this.fichierEJB = fichierEJB;
		Upload upload = new Upload("File", new Upload.Receiver() {

			public OutputStream receiveUpload(String filename, String MIMEType) {

				try {
					return new FileOutputStream(filename);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
			}
		});
		
		layout.addComponent(upload);
		
		 upload.addStartedListener(this);
         upload.addProgressListener(this);
         upload.addFailedListener(this);
         upload.addSucceededListener(this);
         upload.addFinishedListener(this);

		setContent(layout);
	}

	@Override
	public void uploadFinished(FinishedEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void uploadSucceeded(SucceededEvent event) {
		// TODO : faire le code pour récupérer le fichier et le mettre		
		Fichier fichier = new Fichier();
    	fichier.setDevis(devis);
    	fichier.setPath(event.getFilename());
    	devis.getFichiers().add(fichier);
    	fichierEJB.create(fichier);

		Notification.show("Récupérer le fichier "+ event.getFilename(),
				Type.TRAY_NOTIFICATION);
		close();
	}

	@Override
	public void uploadFailed(FailedEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateProgress(long readBytes, long contentLength) {
		// TODO Auto-generated method stub

	}

	@Override
	public void uploadStarted(StartedEvent event) {
		// TODO Auto-generated method stub

	}
}
