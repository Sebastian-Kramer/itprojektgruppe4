package de.hdm.itprojektgruppe4.client.gui;

import java.util.Vector;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojektgruppe4.client.ClientsideSettings;
import de.hdm.itprojektgruppe4.shared.KontaktAdministrationAsync;
import de.hdm.itprojektgruppe4.shared.bo.Kontakt;
import de.hdm.itprojektgruppe4.shared.bo.KontaktKontaktliste;
import de.hdm.itprojektgruppe4.shared.bo.Kontaktliste;
import de.hdm.itprojektgruppe4.shared.bo.Nutzer;

public class DialogBoxAddContactToList extends DialogBox {

	private static KontaktAdministrationAsync verwaltung = ClientsideSettings.getKontaktVerwaltung();


	private VerticalPanel vpanel = new VerticalPanel();
	private HorizontalPanel hpanel = new HorizontalPanel();

	private Button addKontakt = new Button("Dieser Liste Hinzufügen");
	private Nutzer nutzer = new Nutzer();
	private Kontaktliste kliste = new Kontaktliste();

	private ListBox dropBoxKontaktlisten = new ListBox();
	private Kontakt kon = new Kontakt();
	
	public DialogBoxAddContactToList(Kontakt k) {
		this.kon = k;
	}
	
	public void onLoad() {

		super.onLoad();

		nutzer.setID(Integer.parseInt(Cookies.getCookie("id")));
		nutzer.setEmail(Cookies.getCookie("email"));
	
		verwaltung.getAllKontaktlistenFromUser(nutzer.getID(), new AllKontaktlisteByNutzerCallback());
		
		
		vpanel.add(dropBoxKontaktlisten);
		vpanel.add(addKontakt);
		
		this.add(vpanel);
		this.setStyleName("DialogboxBackground");
		
		
		addKontakt.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				verwaltung.insertKontaktKontaktliste(kon.getID(), Integer.parseInt(dropBoxKontaktlisten.getSelectedValue()), new InsertKontaktKontaktlisteBeziehung());
				
			}
		});
	}
	
	
	
	
	
	
	class AllKontaktlisteByNutzerCallback implements  AsyncCallback<Vector<Kontaktliste>> {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(Vector<Kontaktliste> result) {
			// TODO Auto-generated method stub
			
			for (Kontaktliste kl : result) {
				//dropBoxKontaktlisten.addItem(kl.getBez(), kl.getID());
				dropBoxKontaktlisten.addItem(kl.getBez(), Integer.toString(kl.getID()));
				
				kliste.setID(kl.getID());
			}
			
			
		} 
	}
	
	
	class InsertKontaktKontaktlisteBeziehung implements AsyncCallback<KontaktKontaktliste> {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("Der Kontakt wurde NICHT der Liste hinzugefügt");
		}

		@Override
		public void onSuccess(KontaktKontaktliste result) {
			// TODO Auto-generated method stub
			Window.alert("Der Kontakt wurde erfolgreich der Liste hinzugefügt");
			hide();
		}
		
	}
	
	
}