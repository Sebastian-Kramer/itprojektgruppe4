package de.hdm.itprojektgruppe4.shared;

import java.util.List;
import java.util.Vector;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.itprojektgruppe4.shared.bo.Kontakt;
import de.hdm.itprojektgruppe4.shared.bo.Nutzer;
import de.hdm.itprojektgruppe4.shared.report.AllEigeneKontakteReport;
import de.hdm.itprojektgruppe4.shared.report.AllNutzerReport;
import de.hdm.itprojektgruppe4.shared.report.KontakteMitBestimmtenEigenschaftsAuspraegungenReport;
import de.hdm.itprojektgruppe4.shared.report.KontakteMitBestimmterTeilhaberschaftReport;

public interface ReportGeneratorAsync {

	void init(AsyncCallback<Void> callback);
	
	
	
	


	void findNutzerByEmail(String email, AsyncCallback<Nutzer> callback);






	void AllEigeneKontakteReport(AsyncCallback<AllEigeneKontakteReport> asyncCallback);










	void allNutzerReport(AsyncCallback<Vector<Nutzer>> callback);






	void AlleKontakteByNutzer(int nutzerID, AsyncCallback<AllEigeneKontakteReport> callback);






	void kontakteMitBestimmterTeilhaberschaftReport(int nutzerID,
			AsyncCallback<KontakteMitBestimmterTeilhaberschaftReport> callback);









//	void KontakteMitBestimmterTeilhaberschaftReport(AsyncCallback<AllEigeneKontakteReport> asyncCallback);







	



	



	



	
	

}
