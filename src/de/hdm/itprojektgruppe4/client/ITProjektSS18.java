package de.hdm.itprojektgruppe4.client;

import de.hdm.itprojektgruppe4.client.gui.MainForm;
import de.hdm.itprojektgruppe4.client.gui.Startseite;
import de.hdm.itprojektgruppe4.shared.FieldVerifier;
import de.hdm.itprojektgruppe4.shared.KontaktAdministrationAsync;
import de.hdm.itprojektgruppe4.shared.LoginService;
import de.hdm.itprojektgruppe4.shared.LoginServiceAsync;
import de.hdm.itprojektgruppe4.shared.bo.Kontakt;
import de.hdm.itprojektgruppe4.shared.bo.Nutzer;
import de.hdm.itprojektgruppe4.client.gui.KontaktlisteKontaktTreeViewModel;
import de.hdm.itprojektgruppe4.client.NavigationTree;

import java.util.Date;
import java.util.Vector;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ITProjektSS18 implements EntryPoint {
	

//	VerticalPanel vpanel = new VerticalPanel();
//	Button button = new Button("Hallo Nino");
//	TextBox tb = new TextBox();
//	
//	Button myContacts = new Button("Meine Kontakte");
//	Button myContacLists = new Button("Meine Kontaktliste");
//	Button myProfil = new Button("Mein Profil");
//	
//	TextArea textA = new TextArea();
//	//CellTable<Kontakt> allK = new CellTable<Kontakt>();
//	
//	FlexTable allK = new FlexTable();
//
//	VerticalPanel vpanel2 = new VerticalPanel();
	
	private LoginInfo loginInfo = null;
	private VerticalPanel loginPanel = new VerticalPanel();
	private Label loginLabel = new Label("Bitte melde dich mit deinem Google-Konto an");
	private Anchor signInLink = new Anchor("Anmelden");
	private Anchor signOutLink = new Anchor("Sign Out");

	private Button zurpartnerborse = new Button("Zur Partnerbörse");

	
//	LoginServiceAsync loginService = GWT.create(LoginService.class);
	private static KontaktAdministrationAsync verwaltung = ClientsideSettings.getKontaktVerwaltung();
	
	private static String editorHtmlName = "ITProjektSS18.html";

	
	@Override
	public void onModuleLoad() {
		
		LoginServiceAsync loginService = GWT.create(LoginService.class);
		loginService.login(GWT.getHostPageBaseURL() + editorHtmlName, new AsyncCallback<LoginInfo>() {
		public void onFailure(Throwable error) {
			
		}
		public void onSuccess(LoginInfo result) {
			
		loginInfo = result;
		if(loginInfo.isLoggedIn()) {
			loadStartseite();
		} else {
			loadLogin();
		}
		}
	});
	}
	
	private void loadStartseite(){
		
		MainForm mainForm = new MainForm ();
		NavigationTree navigationTree = new NavigationTree();
		signOutLink.setHref(loginInfo.getLogoutUrl());
		RootPanel.get("Details").add(mainForm);
		RootPanel.get("Navigator").add(navigationTree);

	}
	
	private void loadLogin() {
		
		signInLink.setHref(loginInfo.getLoginUrl());
		loginPanel.add(loginLabel);
		loginPanel.add(signInLink);
		RootPanel.get("Details").add(loginPanel);
		
		}
	


		
		 // loginPanel.add(signInLink);
		 // RootPanel.get("Details").add(loginPanel);;

//		
////		vpanel.add(button);
////		vpanel.add(tb);
////		RootPanel.get("Details").add(vpanel);
//		
//		
//		MainForm mv = new MainForm();
//		RootPanel.get("Details").clear();
//		RootPanel.get("Details").add(mv);
//		
//		//RootPanel.get("Navigator").add(new MainForm());
//		
//		button.addClickHandler(new ClickHandler(){
//
//			@Override
//			public void onClick(ClickEvent event) {
//				verwaltung.insertKontakt(tb.getValue(), new Date(), new Date(), 1, 1, new AsyncCallback<Kontakt>() {
//
//					@Override
//					public void onFailure(Throwable caught) {
//						Window.alert("Funktioniert nicht");
//					}
//
//					@Override
//					public void onSuccess(Kontakt result) {
//						Window.alert("Funktioniert");
//					}
//				});
//			}
//			
//		});
//		
//		
//		myContacts.addClickHandler(new ClickHandler() {
//			
//			@Override
//			public void onClick(ClickEvent event) {
//				// TODO Auto-generated method stub
//				MainForm mv = new MainForm();
////				Startseite s = new Startseite();
//				RootPanel.get("Details").clear();
//				RootPanel.get("Details").add(mv);
//				/**
//				verwaltung.findAllKontakte(new AsyncCallback<Vector<Kontakt>>() {
//
//					@Override
//					public void onFailure(Throwable caught) {
//						// TODO Auto-generated method stub
//						Window.alert("Funktioniert nicht");
//					}
//
//					@Override
//					public void onSuccess(Vector<Kontakt> result) {
//						Window.alert("Funktioniert !!!");
//						RootPanel.get("Details").add(start);
//				
//						/
//						allK.setText(0, 0, result.toString());
//						RootPanel.get("Details").add(allK);
//					}
//				});
//				 */
//			}
//		});
//	
		
//		RootPanel.get("Navigator").clear();
//		vpanel2.add(myContacts);
//		vpanel2.add(allK);
//		vpanel2.add(myContacLists);
//		vpanel2.add(myProfil);
//		RootPanel.get("Navigator").add(vpanel2);

		
		
	}
	
//	void init(){
//		
//		RootPanel.get("Navigator").clear();
//		RootPanel.get("Navigator").add(new MainForm());
//		
//	}
	

