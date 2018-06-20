package de.hdm.itprojektgruppe4.client.gui;

import java.util.List;
import java.util.Vector;

import com.google.gwt.cell.client.ClickableTextCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojektgruppe4.client.ClientsideSettings;
import de.hdm.itprojektgruppe4.client.EigenschaftAuspraegungWrapper;
import de.hdm.itprojektgruppe4.shared.KontaktAdministrationAsync;
import de.hdm.itprojektgruppe4.shared.bo.Kontakt;
import de.hdm.itprojektgruppe4.shared.bo.Nutzer;

public class SuchenForm extends VerticalPanel {

	
	private static KontaktAdministrationAsync verwaltung = ClientsideSettings.getKontaktVerwaltung();
	
	private Label beschreibung = new Label("Bitte Geben sie den Kontatknamen ein");
	private TextBox tboxKontaktname = new TextBox();
	
	private Button suchen = new Button("Suchen");
	
	private VerticalPanel vpanel = new VerticalPanel();
	
	private FlexTable flextable = new FlexTable();
	
	private DecoratorPanel suchenPanel = new DecoratorPanel();
	
	private VerticalPanel vpanel1 = new VerticalPanel();
	
	private MultiWordSuggestOracle  nameoracle = new MultiWordSuggestOracle();
	
	private SuggestBox suggestionBox = new SuggestBox(nameoracle);
	
	private CellTable<Kontakt> ctfKontakt = new CellTable<Kontakt>();
	
	private Vector<Kontakt> gefundene = new Vector<Kontakt>();

	private Kontakt k = new Kontakt();
	
	private CellTable<Kontakt> ct = new CellTable<Kontakt>();

	public SuchenForm(){
	}
	
	public void onLoad(){
		
		super.onLoad();
		
		Nutzer nutzer = new Nutzer();
		nutzer.setID(Integer.parseInt(Cookies.getCookie("id")));
		nutzer.setEmail(Cookies.getCookie("mail"));
		
		Column<Kontakt, String> kontaktname = new Column<Kontakt, String>(
				new ClickableTextCell()) {

			@Override
			public String getValue(Kontakt object) {
				// TODO Auto-generated method stub
				return object.getName();
			}
		};
		
		ct.addColumn(kontaktname, "Gefundene Kontakte");
		
		flextable.setWidget(0, 0, beschreibung);
		flextable.setWidget(0, 1, suggestionBox);
		flextable.setWidget(0, 2, suchen);
		suchenPanel.add(flextable);
		
		vpanel1.add(ct);
		suchenPanel.setStyleName("DialogboxBackground");
		suggestionBox.setStyleName("DialogboxBackground");
		

		
		
		
		this.add(suchenPanel);
	
		suchen.addClickHandler(new SuchenButton());
		verwaltung.findAllKontaktFromNutzer(nutzer.getID(), new  AllKontakteCallBack());
	
		this.add(vpanel1);
		
		
	}
	
	class SuchenButton implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			Nutzer nutzer = new Nutzer();
			nutzer.setID(Integer.parseInt(Cookies.getCookie("id")));
			nutzer.setEmail(Cookies.getCookie("mail"));

			Kontakt k = new Kontakt();
			
			k.setName(tboxKontaktname.getValue());
			k.setNutzerID(nutzer.getID());
			
			
			
			
			k.setName(suggestionBox.getValue());
			k.setNutzerID(nutzer.getID());
			
			Window.alert("FLAH" + k.getName() + k.getID() + k.getNutzerID());
			
			verwaltung.findKontaktByNameAndNutzerID(k, new AsyncCallback<Vector<Kontakt>>() {

				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onSuccess(Vector<Kontakt> result) {
					// TODO Auto-generated method stub
					Window.alert(result.toString());
					ct.setRowData(0, result);
					ct.setRowCount(result.size(), true);
//					gefundene = result;
					
					
					
					
				}
			});

			

		
			
			
			
			
			
		}
		
		
		
		
		
		
		
	}

	class AllKontakteCallBack implements AsyncCallback<Vector<Kontakt>> {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
		
		}

		@Override
		public void onSuccess(Vector<Kontakt> result) {
			// TODO Auto-generated method stub
		
			Kontakt k = new Kontakt();
			
			for (Kontakt kontakt : result) {
				
				nameoracle.add(kontakt.getName());
			}
			
			
			}
		}

		
	}
	
	


