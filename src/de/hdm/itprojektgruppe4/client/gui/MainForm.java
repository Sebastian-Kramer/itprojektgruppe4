package de.hdm.itprojektgruppe4.client.gui;

import java.util.Vector;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import de.hdm.itprojektgruppe4.client.ClientsideSettings;
import de.hdm.itprojektgruppe4.client.ImpressumSeite;
import de.hdm.itprojektgruppe4.shared.KontaktAdministrationAsync;
import de.hdm.itprojektgruppe4.shared.bo.Kontakt;
import de.hdm.itprojektgruppe4.shared.bo.Kontaktliste;
import de.hdm.itprojektgruppe4.shared.bo.Nutzer;

/**
 * 
 * @author Sebi_
 *
 */

public class MainForm extends VerticalPanel {

	private static KontaktAdministrationAsync verwaltung = ClientsideSettings.getKontaktVerwaltung();

	Kontakt kon = new Kontakt();
	Kontaktliste konList = new Kontaktliste();
	Kontaktliste selectedKontaktlist = null;
	Nutzer nutzer = new Nutzer();

	private VerticalPanel vpanelDetails = new VerticalPanel();
	private HorizontalPanel hpanelDetails = new HorizontalPanel();

	private FlexTable anordnung = new FlexTable();
	private Image logo = new Image("Image/Logo.png");
	private Button newKontakt = new Button("Neuen Kontakt anlegen");
	private Button newKontaktliste = new Button("Neue Kontaktliste anlegen");
	private Button suchen = new Button("Suchen");
	private HTML greetHTML2 = new HTML(
			"Herzlich Willkommen auf <b>WYNWYN</b>, Ihrer <b>Kontaktverwaltung</b>. "
					+ "<br> Hier können Sie neue Kontakte anlegen, "
					+ "<br> diese in verschiedene Listen organisieren und "
					+ "<br> sowohl Kontakte als auch Kontaktlisten mit anderen Nutzern teilen.");

	
//	private KontaktCell kontaktCell = new KontaktCell();
//	private CellList<Kontakt> cellList = new CellList<Kontakt>(kontaktCell);
//	final SingleSelectionModel<Kontakt> selectionModel = new SingleSelectionModel<Kontakt>();
//	private ScrollPanel scrollPanel = new ScrollPanel();
	private Image startImage = new Image();
	private Image newKonPic = new Image();
	private Image newKonlistPic = new Image();
	private Image suchenPic = new Image();
	
	
	
	
	
	
	public MainForm() {

		
		greetHTML2.setStyleName("BegrueßungsText");
		hpanelDetails.setStyleName("HPanel");
		newKonPic.setStyleName("ButtonICON");
		newKonlistPic.setStyleName("ButtonICON");
		suchenPic.setStyleName("ButtonICON");
		newKonPic.setUrl("Image/Neuer_Kontakt.png");
		newKonlistPic.setUrl("Image/Neue_Liste_2.png");
		suchenPic.setUrl("Image/Suchen.png");
	}
 
	public void onLoad() {

		super.onLoad();
		nutzer.setID(Integer.parseInt(Cookies.getCookie("id")));
		nutzer.setEmail(Cookies.getCookie("email"));

		RootPanel.get("Buttonbar").add(newKontaktliste);
		RootPanel.get("Buttonbar").add(newKontakt);
		RootPanel.get("Buttonbar").add(suchen);

		anordnung.setWidget(0, 0, greetHTML2);

		hpanelDetails.add(startImage);
		logo.setStyleName("LogoStartseite");
		
		vpanelDetails.add(hpanelDetails);
		vpanelDetails.add(anordnung);
		this.add(logo);
		this.add(vpanelDetails);
		newKontakt.getElement().appendChild(newKonPic.getElement());
		newKontaktliste.getElement().appendChild(newKonlistPic.getElement());
		suchen.getElement().appendChild(suchenPic.getElement());
		newKontaktliste.addClickHandler(new NewListClickHandler());
		newKontakt.addClickHandler(new NewKontaktClickHandler());
		suchen.addClickHandler(new SuchenClickHandler());

	}


	class ImpressumButton implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			ImpressumSeite imp = new ImpressumSeite();
			RootPanel.get("Details").clear();
			RootPanel.get("Details").add(imp);
		}

	}

	class NewListClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			DialogBoxNewKontaktliste dbk = new DialogBoxNewKontaktliste();
			dbk.center();
		}

	}

	class NewKontaktClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			NewKontaktForm nkf = new NewKontaktForm();
			RootPanel.get("Details").clear();
			RootPanel.get("Details").add(nkf);
		}

	}

	class SuchenClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {

			SuchenForm sf = new SuchenForm();
			RootPanel.get("Details").clear();
			RootPanel.get("Details").add(sf);

		}
	}



	
	class KontakteVonKontaktlisteAnzeigenCallBack implements AsyncCallback<Kontakt> {

		@Override
		public void onFailure(Throwable caught) {

		}

		@Override
		public void onSuccess(Kontakt result) {

		}

	}

}
