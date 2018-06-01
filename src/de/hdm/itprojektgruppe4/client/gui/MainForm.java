package de.hdm.itprojektgruppe4.client.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.google.appengine.api.images.Image;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import de.hdm.itprojektgruppe4.client.ClientsideSettings;
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

	private VerticalPanel vpanelDetails = new VerticalPanel();
	// private VerticalPanel vpanelNavigator = new VerticalPanel();
	private HorizontalPanel hpanelDetails = new HorizontalPanel();
	private HorizontalPanel hpanelButtonBar = new HorizontalPanel();

	private Button newKontakt = new Button("Neuer Kontakt anlegen");
	private Button newKontaktliste = new  Button("Neue Kontaktliste anlegen");
	
	private HTML html1 = new HTML("<h2>Meine Kontakte</h2>");

	private KontaktCell kontaktCell = new KontaktCell();

	private CellList<Kontakt> cellList = new CellList<Kontakt>(kontaktCell);

	private List<Kontakt> kList = new ArrayList<>();

	private Tree kontaktListTree = new Tree();

	private TreeItem kontaktListTreeItem = new TreeItem();

	final SingleSelectionModel<Kontakt> selectionModel = new SingleSelectionModel<Kontakt>();
	final SingleSelectionModel<TreeItem> selectionTreeItem = new SingleSelectionModel<TreeItem>();
	
	private ScrollPanel scrollPanel = new ScrollPanel();

	public MainForm() {

		
		Nutzer nutzer = new Nutzer();
		nutzer.setID(Integer.parseInt(Cookies.getCookie("id")));
		nutzer.setEmail(Cookies.getCookie("email"));

		Window.alert(nutzer.getEmail());

		verwaltung.findKontaktByNutzerID(nutzer.getID(), new KontaktCallBack());
		
	
		cellList.setSelectionModel(selectionModel);
		selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {

			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				Kontakt selected = selectionModel.getSelectedObject();
				Window.alert("Sie haben folgenden Kontakt ausgewählt: " + selected.getName());
				KontaktForm kf = new KontaktForm(selected);
				RootPanel.get("Details").clear();
				RootPanel.get("Details").add(kf);
				// if (selected != null) {
				// updateKontakt.setVisible(true);

				// }
			}
		});

		kontaktListTree.addSelectionHandler(new SelectionHandler<TreeItem>() {

			@Override
			public void onSelection(SelectionEvent<TreeItem> event) {

				TreeItem it = event.getSelectedItem();
				verwaltung.findKontaktlisteByBezeichnung(it.getText(), new KontaktlisteKontaktCallBack());

			}

		});

		kontaktListTreeItem.setText("Meine Kontaktlisten");

		kontaktListTree.addItem(kontaktListTreeItem);

		// Navigator Panels & Widgets

		/**
		 * 
		 * vpanelNavigator.add(html2); vpanelNavigator.add(kontaktListTree);
		 * vpanelNavigator.add(profil); vpanelNavigator.add(showKontakt);
		 * RootPanel.get("Navigator").add(vpanelNavigator);
		 */

		// Details Panels & Widgets
		
		newKontaktliste.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				DialogBoxNewKontaktliste dbk = new DialogBoxNewKontaktliste();
				dbk.center();
			}
			
		});

		newKontakt.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				NewKontaktForm nkf = new NewKontaktForm();
				RootPanel.get("Details").clear();
				RootPanel.get("Details").add(nkf);
			}
		});
		
		hpanelButtonBar.add(newKontaktliste);
		hpanelButtonBar.add(newKontakt);
		
		scrollPanel.setSize("450px", "200px");
		scrollPanel.setStyleName("scrollPanel");
		cellList.setStyleName("cellListKontakte");
		scrollPanel.add(cellList);

		RootPanel.get("Buttonbar").add(hpanelButtonBar);

		vpanelDetails.add(html1);
		vpanelDetails.add(hpanelDetails);
		vpanelDetails.add(scrollPanel);
		this.add(vpanelDetails);

	}

	class KontaktCallBack implements AsyncCallback<List<Kontakt>> {

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Beim Laden der Kontakte ist ein Fehler aufgetreten");

		}

		@Override
		public void onSuccess(List<Kontakt> result) {

			Window.alert("Es wurden " + result.size() + " Kontakte geladen");

			for (Kontakt kon : result) {
				kList.add(kon);
			}

			cellList.setRowCount(kList.size(), true);
			cellList.setRowData(0, kList);
		}

	}

	/**
	class KontaktlistCallBack implements AsyncCallback<Vector<Kontaktliste>> {

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Beim Laden der Kontaktlisten ist ein Fehler aufgetreten");

		}

		@Override
		public void onSuccess(Vector<Kontaktliste> result) {

			Window.alert("Alle Kontaktlsiten wurden gefunden");

			for (Kontaktliste kList : result) {
				kontaktListTreeItem.addTextItem(kList.getBez());
			}

		}

	}
*/
	class KontaktlisteKontaktCallBack implements AsyncCallback<Kontaktliste> {

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Beim Laden der Kontakte ist ein Fehler aufgetreten");

		}

		@Override
		public void onSuccess(Kontaktliste result) {

			konList = result;
			Window.alert(
					" Bezeichnung der Liste: " + konList.getBez() + "\n" + " und ID der Liste: " + konList.getID());

			AllKontakteForm allKontakts = new AllKontakteForm(konList);
			RootPanel.get("Details").clear();
			RootPanel.get("Details").add(allKontakts);

		}

	}

	class KontakteVonKontaktlisteAnzeigenCallBack implements AsyncCallback<Kontakt> {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onSuccess(Kontakt result) {
			// TODO Auto-generated method stub

		}

	}

	

}
