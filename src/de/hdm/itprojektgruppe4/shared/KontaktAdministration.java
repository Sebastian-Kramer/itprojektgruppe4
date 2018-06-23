package de.hdm.itprojektgruppe4.shared;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.hdm.itprojektgruppe4.client.EigenschaftAuspraegungWrapper;
import de.hdm.itprojektgruppe4.shared.bo.Eigenschaft;
import de.hdm.itprojektgruppe4.shared.bo.Eigenschaftauspraegung;
import de.hdm.itprojektgruppe4.shared.bo.Kontakt;
import de.hdm.itprojektgruppe4.shared.bo.Kontaktliste;
import de.hdm.itprojektgruppe4.shared.bo.Nutzer;
import de.hdm.itprojektgruppe4.shared.bo.Person;
import de.hdm.itprojektgruppe4.shared.bo.Teilhaberschaft;
import de.hdm.itprojektgruppe4.shared.bo.KontaktKontaktliste;

@RemoteServiceRelativePath("kontaktmanager")
public interface KontaktAdministration extends RemoteService {

	/**
	 * Initialisierung des Objekts. Wird direkt nach der Instantiierung
	 * aufgerufen.
	 * 
	 * @throws IllegalArgumentException
	 */
	public void init() throws IllegalArgumentException;

	/**
	 * Einen Kontakt anlegen
	 * 
	 * @param name,
	 *            der Name des Kontakts
	 * @param erzeugungsdatum,
	 *            das Erzeugungsdatum des Kontakts
	 * @param modifikationsdatum,
	 *            das Datum an dem Eigenschaften oder Auspraegungen des
	 *            Kontaktes ge�ndert wurden
	 * @param status,
	 *            der Status ob der Kontakt geteilt wurde oder nicht
	 * @param nutzerID,
	 *            Fremdschl�sselbeziehung zum Ersteller des Kontakes
	 * @return Kontakt-Objekt
	 * @throws IllegalArgumentException
	 */
	public Kontakt insertKontakt(String name, Date erzeugungsdatum, Date modifikationsdatum, int status, int nutzerID)
			throws IllegalArgumentException;

	/**
	 * Einen Nutzer anlegen
	 * 
	 * @param mail
	 * @return Nutzer-Objekt
	 * @throws IllegalArgumentException
	 */
	public Nutzer insertNutzer(String mail) throws IllegalArgumentException;

	/**
	 * Einen Kontakt l�schen
	 * 
	 * @param k
	 *            das zu l�schende Kontakt-Objekt
	 * @throws IllegalArgumentException
	 */
	public void deleteKontakt(Kontakt k) throws IllegalArgumentException;

	/**
	 * Einen Kontakt anhand seines Prim�rschl�ssel anzeigen lassen.
	 * 
	 * @param id
	 *            der Prim�rschl�ssel des Objekts
	 * @return Kontakt-Objekt mit dem �bergebenen Prim�rschl�ssel
	 * @throws IllegalArgumentException
	 */
	public Kontakt findKontaktByID(int id) throws IllegalArgumentException;

	/**
	 * Einen Kontakt anhand seines Namens anzeigen lassen.
	 * 
	 * @param name,
	 *            der Name des Kontakts
	 * @return Kontakt-Objekt mit dem �bergebenen Namen
	 * @throws IllegalArgumentException
	 */
	public Kontakt findKontaktByName(String name) throws IllegalArgumentException;
	
	
	/**
	 * Einen Kontakt anhand seiner KontaktID in der Auspraegung anzeigen lassen.
	 * 
	 * @param id,
	 *            
	 * @return Kontakt-Objekt mit der übergebenen kontaktID
	 * @thro
	 * */
	public Kontakt findKontaktByAuspraegungID(int id) throws IllegalArgumentException;
	
	
	/**
	 * Alle Kontakte auslesen und in einem Vector ausgeben lassen.
	 * 
	 * @return Vector aller Kontakte
	 * @throws IllegalArgumentException
	 */
	public Vector<Kontakt> findAllKontakte() throws IllegalArgumentException;

	/**
	 * 
	 */

	public Vector<Kontakt> findKontaktByNameAndNutzerID(Kontakt kontakt) throws IllegalArgumentException;

	/**
	 * �berschreiben eines <code>Kontakt</code>-Objekts.
	 * 
	 * @param k
	 *            das zu bearbeitende Kontakt-Objekt
	 * @return das bearbeitete Kontakt-Objekt
	 * @throws IllegalArgumentException
	 */
	public Kontakt updateKontakt(Kontakt k) throws IllegalArgumentException;

	/**
	 * L�schen einer Person.
	 * 
	 * @param p
	 *            das zu l�schende Personen-Objekt
	 * @throws IllegalArgumentException
	 */
	public void deletePerson(Person p) throws IllegalArgumentException;

	/**
	 * Eine Person anhand der ID auslesen.
	 * 
	 * @param ID,
	 *            der Prim�rschl�ssel
	 * @throws IllegalArgumentException
	 */
	public Person findPersonByID(int ID) throws IllegalArgumentException;

	/**
	 * L�schen eines Nutzers.
	 * 
	 * @param n
	 *            das zu l�schende Nutzer-Objekt
	 * @throws IllegalArgumentException
	 */
	public void deleteNutzer(Nutzer n) throws IllegalArgumentException;

	/**
	 * �berschreiben eines Nutzer-Objekts.
	 * 
	 * @param n
	 *            das zu bearbeitende Nutzer-Objekt
	 * @return n das bearbeitete Nutzer Objekt
	 * @throws IllegalArgumentException
	 */
	public Nutzer updateNutzer(Nutzer n) throws IllegalArgumentException;

	/**
	 * Einen Nutzer anhand seiner E-Mail auslesen.
	 * 
	 * @param email
	 * @return Nutzer-Objekt
	 * @throws IllegalArgumentException
	 */
	public Nutzer findNutzerByEmail(String email) throws IllegalArgumentException;

	/**
	 * Einen Nutzer anhand seiner ID auslesen.
	 * 
	 * @param id
	 *            der Prim�rschl�ssel des Nutzer-Objekts
	 * @return Nutzer-Objekt
	 * @throws IllegalArgumentException
	 */
	public Nutzer findNutzerByID(int id) throws IllegalArgumentException;

	Nutzer findNutzerByID(String string);

	/**
	 * Alle Nutzer auslesen.
	 * 
	 * @return Vector s�mtlicher Nutzer
	 * @throws IllegalArgumentException
	 */
	public Vector<Nutzer> findAllNutzer() throws IllegalArgumentException;

	/**
	 * Eine Kontaktliste anhand der ID auslesen.
	 * 
	 * @param id
	 *            der Prim�rschl�ssel des Kontaktlisten-Objekts
	 * @return Kontaktlisten-Objekt
	 * @throws IllegalArgumentException
	 */
	public Kontaktliste findKontaktlisteByID(int id) throws IllegalArgumentException;

	/**
	 * Eine Kontaktliste anhand der Bezeichnung auslesen.
	 * 
	 * @param bezeichnung,
	 *            die Bezeichnung der Kontaktliste
	 * @return Kontaktlisten-Objekt
	 * @throws IllegalArgumentException
	 */
	public Kontaktliste findKontaktlisteByBezeichnung(String bezeichnung) throws IllegalArgumentException;

	/**
	 * 
	 * @param bez,
	 *            die Bezeichnung der Kontaktliste
	 * @param status,
	 *            der Status, der anzeigt ob die Kontaktliste geteilt wurde oder
	 *            nicht
	 * @param nutzerID,
	 *            der Fremdschl�ssel stellt die Beziehung zum Ersteller dar
	 * @return Kontaktlisten-Objekt
	 * @throws IllegalArgumentException
	 */
	public Kontaktliste insertKontaktliste(String bez, int status, int nutzerID) throws IllegalArgumentException;

	/**
	 * Eine Kontaktliste �berschreiben.
	 * 
	 * @param k
	 *            das zu bearbeitende Kontaktlisten-Objekt
	 * @return
	 * @throws IllegalArgumentException
	 */
	public Kontaktliste updateKontaktliste(Kontaktliste k) throws IllegalArgumentException;

	/**
	 * Eine Kontaktliste l�schen.
	 * 
	 * @param k
	 *            das zu l�schende Kontaktlisten-Objekt
	 * @throws IllegalArgumentException
	 */
	public void deleteKontaktliste(Kontaktliste k) throws IllegalArgumentException;

	/**
	 * Alle Kontaktlisten auslesen.
	 * 
	 * @return Vector s�mtlicher Kontaktlisten
	 * @throws IllegalArgumentException
	 */
	public Vector<Kontaktliste> findKontaktlisteAll() throws IllegalArgumentException;

	public Vector<Eigenschaft> getEigenschaftByBezeichnung(String bez) throws IllegalArgumentException;

	/**
	 * Eine Eigenschaft anhand der ID auslesen.
	 * 
	 * @param id,
	 *            Prim�rschl�ssel der Eigenschaft
	 * @return Eigenschaft-Objekt
	 * @throws IllegalArgumentException
	 */
	public Eigenschaft getEigenschaftByID(int id) throws IllegalArgumentException;

	/**
	 * Eine Eigenschaft anlegen.
	 * 
	 * @param bez,
	 *            die Bezeichnung der Eigenschaft
	 * @param status,
	 *            Status der anzeigt, ob die Eigenschaft geteilt wurde oder
	 *            nicht
	 * @return Eigenschaft Objekt
	 * @throws IllegalArgumentException
	 */
	public Eigenschaft insertEigenschaft(String bez, int status) throws IllegalArgumentException;

	/**
	 * Eine Eigenschaft �berschreiben.
	 * 
	 * @param e
	 *            das Eigenschaft-Objekt
	 * @return
	 * @throws IllegalArgumentException
	 */
	public Eigenschaft updateEigenschaft(Eigenschaft e) throws IllegalArgumentException;

	/**
	 * Eine Eigenschaft l�schen.
	 * 
	 * @param e
	 *            das zu l�schende Eigenschaft-Objekt
	 * @throws IllegalArgumentException
	 */
	public void deleteEigenschaft(Eigenschaft e) throws IllegalArgumentException;

	/**
	 * Alle Objekte vom Typ Eigenschaft ausgeben
	 * 
	 * @return
	 * @throws IllegalArgumentException
	 */

	public Vector<Eigenschaft> findAllEigenschaft() throws IllegalArgumentException;

	public Vector<Eigenschaftauspraegung> findAllEigenschaftauspraegung() throws IllegalArgumentException;

	public Vector<Eigenschaft> getEigenschaftbyKontaktID(int id);

	/**
	 * 
	 * @param wert,
	 *            die Auspraegung der Eigenschaft
	 * @param status,
	 *            zeigt an ob die Auspraegung geteilt wurde oder nicht
	 * @param eigenschaftsID,
	 *            Fremschl�sselbeziehung zur Eigenschaft
	 * @param kontaktID,
	 *            Fremdschl�sselbeziehung zum Kontakt auf den sich die
	 *            Eigenschaft bezieht
	 * @return Eigenschaft-Objekt
	 * @throws IllegalArgumentException
	 */
	public Eigenschaftauspraegung insertAuspraegung(String wert, int status, int eigenschaftsID, int kontaktID)
			throws IllegalArgumentException;

	/**
	 * Eine Eigenschaftsauspraegung �berschreiben.
	 * 
	 * @param ea
	 * @return
	 * @throws IllegalArgumentException
	 */
	public Eigenschaftauspraegung updateAuspraegung(Eigenschaftauspraegung ea) throws IllegalArgumentException;

	/**
	 * Eine Eigenschaftsauspraegung l�schen.
	 * 
	 * @param ea
	 *            das Eigenschaftsauspraegung-Objekt
	 * @throws IllegalArgumentException
	 */
	public void deleteAuspraegung(Eigenschaftauspraegung ea) throws IllegalArgumentException;

	/**
	 * Eine Eigenschaftsauspraegung anhand des Wertes auslesen.
	 * 
	 * @param wert,
	 *            der die Auspraegung beschreibt
	 * @return Eigenschafts-Objekt mit gesuchtem Wert
	 * @throws IllegalArgumentException
	 */
	public Vector<EigenschaftAuspraegungWrapper> getAuspraegungByWert(String wert) throws IllegalArgumentException;

	/**
	 * Eine Eigenschaftsauspraegung anhand der ID auslesen.
	 * 
	 * @param id
	 *            der Prim�rschl�ssel der Auspraegung
	 * @return Eigenschaftsauspraegung-Objekt
	 * @throws IllegalArgumentException
	 */
	public Eigenschaftauspraegung getAuspraegungByID(int id) throws IllegalArgumentException;

	/**
	 * Alle Eigenschaftsauspraegungen eines Kontaktes auslesen
	 * 
	 * @param kontaktID
	 * @return Vector mit s�mtlichen Eigenschaftsauspraegungen mit der
	 *         uebergebenen KontaktID
	 * @throws IllegalArgumentException
	 */
	public Vector<Eigenschaftauspraegung> findEigenschaftauspraegungByKontaktID(int kontaktID)
			throws IllegalArgumentException;

	public Vector<Eigenschaftauspraegung> getAuspraegungByKontaktID(int id) throws IllegalArgumentException;

	public Vector<EigenschaftAuspraegungWrapper> findHybrid(Person pers) throws IllegalArgumentException;

	public void deleteEigenschaftUndAuspraegung(EigenschaftAuspraegungWrapper ea) throws IllegalArgumentException;

	/**
	 * Eine Teilhaberschaft anhand der ID auslesen.
	 * 
	 * @param id
	 *            der Prim�rschl�ssel der Teilhaberschaft
	 * @return Teilhaberschaft-Objekt
	 * @throws IllegalArgumentException
	 */
	public Teilhaberschaft findByID(int id) throws IllegalArgumentException;

	/**
	 * Eine Teilhaberschaft anlegen
	 * 
	 * @param kontaktID,
	 *            Fremdschl�sselbeziehung zum Kontakt
	 * @param kontaktListeID,
	 *            Fremdschl�sselbeziehung zur Kontaktliste
	 * @param eigenschaftsauspraegungID,
	 *            Fremdschl�sselbeziehung zur Eingenschaftsauspraegung
	 * @param teilhaberID,
	 *            Fremdschl�sselbeziehung zum Teilhaber
	 * @return Teilhaberschaft-Objekt
	 * @throws IllegalArgumentException
	 */
	public Teilhaberschaft insertTeilhaberschaft(int kontaktListeID, int kontaktID, int eigenschaftsauspraegungID,
			int teilhaberID, int nutzerID) throws IllegalArgumentException;

	/**
	 * Eine Teilhaberschaft für ein geteilten Kontakt anlegen
	 * 
	 * @param kontaktID
	 * @param eigenschaftsauspraegungID
	 * @param teilhaberID
	 * @return
	 */
	public Teilhaberschaft insertTeilhaberschaftKontakt(int kontaktID, int teilhaberID,
			int nutzerID);

	public int insertTeilhaberschaftAuspraegungenKontakt(Kontakt kon, String selectedValue, int id)
			throws IllegalArgumentException;

	public int insertTeilhaberschaftAusgewaehlteAuspraegungenKontakt(Kontakt kon,
			Vector<EigenschaftAuspraegungWrapper> eaw, String selectedValue, int id);

	/**
	 * Eine Teilhaberschaft l�schen.
	 * 
	 * @param t
	 *            das zu l�schende Teilhaberschaft-Objekt
	 * @throws IllegalArgumentException
	 */
	public void deleteTeilhaberschaft(Teilhaberschaft t) throws IllegalArgumentException;

	/**
	 * Eine Teilhaberschaft an einem Kontakt l�schen.
	 * 
	 * @param t
	 *            das zur l�schende Teilhaber-Objekt
	 * @throws IllegalArgumentException
	 */
	public void deleteKontaktFromTeilhaberschaft(Teilhaberschaft t) throws IllegalArgumentException;

	/**
	 * Eine Teilhaberschaft an einer Kontaktliste l�schen.
	 * 
	 * @param t
	 *            das zu l�schende Teilhaberschaft-Objekt
	 * @throws IllegalArgumentException
	 */
	public void deleteKontaktlisteFromTeilhaberschaft(Teilhaberschaft t) throws IllegalArgumentException;

	public void deleteEigenschaftsauspraegungFromTeilhaberschaft(Eigenschaftauspraegung ea, Nutzer n)
			throws IllegalArgumentException;

	/**
	 * 
	 * @param teilhaberID
	 * @return
	 * @throws IllegalArgumentException
	 */
	public Vector<Nutzer> getAllTeilhaberfromAuspraegung(int auspraegungID) throws IllegalArgumentException;

	/**
	 * 
	 * 
	 * @return
	 * @throws IllegalArgumentException
	 */
	
	
	public Vector<Nutzer> getAllTeilhaberFromKontakt (int kontaktID) throws IllegalArgumentException;
	
	public List<Kontakt> findAllKontaktNames() throws IllegalArgumentException;

	/**
	 * Anlegen eines Objekts der Klasse KontaktKontaktliste um eine Beziehung
	 * zwischen Kontakt und Kontaktliste in der Datenbank herzustellen.
	 * 
	 * @param k
	 * @return KontaktKontaktliste-Objekt
	 */
	public KontaktKontaktliste insertKontaktKontaktliste(int kontaktID, int kontaktlisteID)
			throws IllegalArgumentException;

	/**
	 * Aufhebung der Beziehung zwischen Kontakt und Kontaktliste.
	 * 
	 * @param k
	 *            das zu l�schende KontaktKontaktliste-Objekt
	 * @throws IllegalArgumentException
	 */
	public void deleteKontaktKontaktliste(KontaktKontaktliste k) throws IllegalArgumentException;

	public List<Kontakt> findKontaktByNutzerID(int nutzerID);

	/**
	 * Auslesen der Kontaktlisten anhand der ID des Kontaktlistenerstellers
	 * 
	 * @param nutzerID
	 * @return Vector mit s�mtlichen Kontaktlisten mit der �bergebenen NutzerID
	 * @throws IllegalArgumentException
	 */
	public Vector<Kontaktliste> findKontaktlisteByNutzerID(int nutzerID) throws IllegalArgumentException;

	/**
	 * 
	 * @param i
	 * @return Vector mit sämtlichen Kontakten einer ausgewählten Kontaktliste
	 * @throws IllegalArgumentException
	 */

	/**
	 * 
	 * @param bez
	 * @param status
	 * @param nutzerID
	 * @return
	 * @throws IllegalArgumentException
	 */
	public KontaktKontaktliste insertKontaktinMeineGeteiltenKontakte(int konID, int kListID)
			throws IllegalArgumentException;

	/**
	 * 
	 * @param i
	 * @return
	 * @throws IllegalArgumentException
	 */
	public Vector<Integer> findAllKontakteFromKontaktliste(int i) throws IllegalArgumentException;

	/**
	 *
	 * 
	 * @param kontaktlisteID
	 *            die ID der Kontaktliste
	 * @return Vector mit s�mtlichen Kontakten einer Kontaktliste
	 * @throws IllegalArgumentException
	 */
	public Vector<Kontakt> getAllKontakteFromKontaktliste(int kontaktlisteID) throws IllegalArgumentException;

	public Vector<Eigenschaftauspraegung> insertBasicAuspraegung(String wert, int status, int kontaktID)
			throws IllegalArgumentException;

	/**
	 * 
	 * @param nutzerID
	 *            die ID des Nutzers
	 * @return Vector mit s�mtlichen erstellten und geteilten Kontaktlisten
	 *         eines Users
	 * @throws IllegalArgumentException
	 */
	public Vector<Kontaktliste> getAllKontaktlistenFromUser(int nutzerID) throws IllegalArgumentException;

	/**
	 * Ausgabe aller Teilhaberschaften eines Nutzers
	 * 
	 * @param nutzerID
	 * @return Vector mit allen Teilhaberschaften eines Nutzers
	 */
	public Vector<Teilhaberschaft> getAllTeilhaberschaftenFromUser(int nutzerID) throws IllegalArgumentException;

	/**
	 * 
	 * @param kontaktlisteID
	 * @return Vector mit KontaktKontaktlisten-Objekten die �bergebene
	 *         KontaktlisteID als Fremdschl�ssel besitzen
	 * @throws IllegalArgumentException
	 */
	public Vector<KontaktKontaktliste> getKontaktKontaktlisteFromKontaktliste(int kontaktlisteID)
			throws IllegalArgumentException;

	/**
	 * Dient zur Erstellung einer Basis-Kontaktliste namens "Meine Kontakte",
	 * die bei der Anmeldung eines Nutzers erstellt wird.
	 * 
	 * @param bez
	 * @param status
	 * @param nutzerID
	 * @return Kontaktliste mit der Bezeichnung "Meine Kontakte"
	 * @throws IllegalArgumentException
	 */
	public Kontaktliste insertMeineKontakte(String bez, int status, int nutzerID) throws IllegalArgumentException;

	/**
	 * Ausgabe eines Vectors mit s�mtlichen geteilten und erstellten Kontakten
	 * eines Nutzers
	 * 
	 * @param nutzerID
	 * @return Vector mit s�mtlichen geteilten und erstellten Kontakten des
	 *         Nutzers
	 * @throws IllegalArgumentException
	 */
	public Vector<Kontakt> findAllKontaktFromNutzer(int nutzerID) throws IllegalArgumentException;

	/**
	 * Eine Teilhaberschaft an einer Kontaktliste l�schen
	 * 
	 * @param kontaktlisteID
	 *            die ID der Kontaktliste, an der die Teilhaberchaft aufgel�st
	 *            werden soll
	 * @throws IllegalArgumentException
	 */
	public void deleteTeilhaberschaftByKontaktlisteID(int kontaktlisteID) throws IllegalArgumentException;

	public Kontaktliste findBasicKontaktliste(int nutzerID) throws IllegalArgumentException;

	public Kontaktliste findKontaktliste(int nutzerID, String bez) throws IllegalArgumentException;

	/**
	 * Ausgabe eines Vectors mit s�mtlichen Kontakten, die mit einem bestimmten
	 * Nutzer geteilt wurden.
	 * 
	 * @param nutzerID
	 *            die ID des Nutzers
	 * @return Vector mit s�mtlichen geteilten Kontakten eines Nutzers
	 * @throws IllegalArgumentException
	 */
	public Vector<Kontakt> findAllSharedKontakteVonNutzer(int nutzerID) throws IllegalArgumentException;

	Teilhaberschaft insertTeilhaberschaftKontaktliste(int kontaktlisteID, String email, int nutzerID);

	/**
	 * Ausgabe s�mtlicher Teilhaberschaften an einer Kontaktliste
	 * 
	 * @param kontaktlisteID
	 *            die ID der Kontaktliste deren Teilhaberschaften gesucht werden
	 * @return Vector mit s�mtlichen Teilhaberschaften an einer Kontaktliste
	 * @throws IllegalArgumentException
	 */
	public Vector<Teilhaberschaft> findTeilhaberschaftByKontaktlisteID(int kontaktlisteID)
			throws IllegalArgumentException;

	/**
	 * Vector mit s�mtlichen Nutzern, die eine Teilhaberschaft an einer
	 * Kontaktliste haben
	 * 
	 * @param nutzerID
	 *            die ID des Nutzers
	 * @return Vector mit Nutzern die
	 * @throws IllegalArgumentException
	 */
	public Vector<Nutzer> findAllTeilhaberFromKontaktliste(int kontaktlisteID) throws IllegalArgumentException;

	/**
	 * L�schen eines Kontaktes aus einer Kontaktliste
	 * 
	 * @param kontaktID
	 *            die ID des zu l�schenden Kontaktes
	 * @throws IllegalArgumentException
	 */
	public void deleteKontaktKontaktlisteByKontaktID(int kontaktID) throws IllegalArgumentException;

	/**
	 * L�schen einer Teilhaberschaft anhand der TeilhaberID
	 * 
	 * @param teilhaberID
	 *            die ID des Teilhabers dessen ID gel�scht werden soll
	 * @throws IllegalArgumentException
	 */
	public void deleteTeilhaberschaftByTeilhaberID(int teilhaberID) throws IllegalArgumentException;

	public Vector<Kontaktliste> findKontaktlisteByNutzerIDexceptBasicList(int nutzerID) throws IllegalArgumentException;

	/**
	 * Auslesen einer Teilhaberschaft anhand einer TeilhaberID und einer
	 * KontaktlisteID
	 * 
	 * @param teilhaberID
	 *            die ID des Teilhabers
	 * @return gesuchte Teilhaberschaft
	 * @throws IllegalArgumentException
	 */
	public Teilhaberschaft findTeilhaberschaftByTeilhaberID(int teilhaberID, int kontaktlisteID)
			throws IllegalArgumentException;

	public Eigenschaft findEigByBezeichnung(String bez) throws IllegalArgumentException;

	/**
	 * Auslesen aller Nutzer, mit den der angemeldete Nutzer eine Kontaktliste
	 * geteilt hat
	 * 
	 * @param nutzerID
	 *            die ID des angemeldeten Nutzers
	 * @param kontaktlisteID
	 *            die ID der Kontaktliste, deren Teilhaberschaften verwaltet
	 *            werden sollen
	 * @return Vector mit s�mtlichen Nutzern, mit denen der angemeldete Nutzer
	 *         die Kontaktliste geteilt hat
	 * @throws IllegalArgumentException
	 */
	public Vector<Nutzer> findSharedWithNutzer(int nutzerID, int kontaktlisteID) throws IllegalArgumentException;

	/**
	 * Auslesen aller Teilhaberschaften, mit der �bergebenen nutzerID und
	 * kontaktlisteID
	 * 
	 * @param nutzerID
	 *            die ID des angemeldeten Nutzers
	 * @param kontaktlisteID
	 *            die ID der gew�hlten kontaktlisteID
	 * @return Vector mit s�mtlichen Teilhaberschaften, mit den uebergebenen
	 *         Parametern
	 * @throws IllegalArgumentException
	 */
	public Vector<Teilhaberschaft> findTeilhaberschaftByNutzerIDKontaktlisteID(int nutzerID, int kontaktlisteID)
			throws IllegalArgumentException;

	public Vector<Teilhaberschaft> findTeilhaberschaftByAuspraegungID(int auspraegungID);

	public Vector<EigenschaftAuspraegungWrapper> findSharedAuspraegung(int kontaktID, int nutzerID)
			throws IllegalArgumentException;

	public void deleteUpdateTeilhaberschaft(Eigenschaftauspraegung ea, Nutzer teilhaber, Nutzer n, Kontakt k) throws IllegalArgumentException;

	public Vector<Teilhaberschaft> findTeilhaberschaftByKontaktID(int kontaktID) throws IllegalArgumentException;

	public Teilhaberschaft insertTeilhaberschaftAuspraegung(int eigenschaftauspraegungID, int teilhaberID, int nutzerID);

	public void deleteKontaktKontaktlisteByKontaktIDAndByKListID(int kontaktID, int kontaktlisteID) throws IllegalArgumentException;

	public Kontaktliste findKontaktlisteMeineGeteiltenKontakte(String kList, int nutzerID) throws IllegalArgumentException;

	public void deleteTeilhaberschaftByKontaktIDAndNutzerID(int kontaktID, int teilNutzerID) throws IllegalArgumentException;

	public void updateKontaktStatus(Kontakt k, Nutzer n) throws IllegalArgumentException;

	public Vector<Teilhaberschaft> findTeilhaberschaftByAuspraegungIDAndTeilhaberID(int auspraegungID, int teilhaberID) throws IllegalArgumentException;

	public Vector<Teilhaberschaft> findTeilhaberschaftByKontaktIDAndTeilhaberID(int kontaktID, int teilhaberID) throws IllegalArgumentException;

	public Vector<Teilhaberschaft> findTeilhaberschaftByTeilhaberIDAndNutzerID(int teilhaberID, int nutzerID) throws IllegalArgumentException;

	public KontaktKontaktliste findKontaktKontaktlisteByKontaktIDAndKlisteID(int kontaktID, int kListID) throws IllegalArgumentException;
	
	public Vector <Kontakt> findGeteilteKontakteFromNutzerAndTeilhaber ( int nutzerID, int teilhaberID) throws IllegalArgumentException;

	public Vector<Kontakt> findKontakteByEigAus(int NutzerID ,	String bez , String wert) throws IllegalArgumentException ;
	
	public Vector<Kontakt> findKontakeByEig(int NutzerID, String bez) throws IllegalArgumentException;

	public Vector<Kontakt> findKontakteByAus(int NutzerID, String wert) throws IllegalArgumentException;


	/**
	 * 
	 * 
	 * @param kontaktlisteID
	 * @return Kontaktliste-Objekt mit geändertem Status
	 * @throws IllegalArgumentException
	 */
	public Kontaktliste updateKontaktlisteStatus (int kontaktlisteID) throws IllegalArgumentException;
	
	/**
	 * Auslesen eines Vectors mit allen Nutzern, mit denen eine Kontaktliste noch nicht geteilt wurde.
	 * 
	 * @param kontaktlisteID die ID der Kontaktliste, die geteilt werden soll
	 * @return Vector mit Nutzer-Objekten
	 * @throws IllegalArgumentException
	 */
	public Vector<Nutzer> findNutzerToShareListWith (int kontaktlisteID, int nutzerID) throws IllegalArgumentException;
	
	/**
	 * Löschen einer Teilhaberschaft an einer Kontaktliste.
	 * Gleichzeitig wird überprüft, ob noch Teilhaberschaften an der Kontaktliste bestehen, ansonsten wird der Status der Kontaktliste
	 * auf 0 (= nicht geteilt) gesetzt und die Kontaktliste geupdated.
	 * 
	 * @param teilhaberID, die ID des Teilhabers, dessen Teilhaberschaft aufgelöst werden muss
	 * @param kontaktlisteID, die ID der Liste, an der die Teilhaberschaft gelöscht werden soll
	 * @throws IllegalArgumentException
	 */
	public void deleteTeilhaberschaftAnKontaktliste (int teilhaberID, int kontaktlisteID) throws IllegalArgumentException;
	

	public Teilhaberschaft findByTeilhaberschaftByKontaktlistIDAndTeilhaberID(int kontaktlisteID, int teilhaberID) throws IllegalArgumentException;

	public Vector<Eigenschaftauspraegung> findAllSharedAuspraegungenFromKontaktID(int kontaktID) throws IllegalArgumentException;
	
	/**
	 * Vector mit allen Kontakten, die zu einer Kontaktliste hinzugefügt werden können.
	 * Dabei sollen nur Kontakte angezeigt werden, die der Nutzer erstellt oder empfangen hat und die noch nicht Teil der Kontaktliste sind
	 * 
	 * @param nutzerID die ID des angemeldeten Nutzers
	 * @param kontaktlisteID die ID der Kontaktliste, zu der Kontakte hinzugefügt werden sollen
	 * @return Vector mit allen Kontakten, die zu einer Kontaktliste hinzugefuegt werden können.
	 * @throws IllegalArgumentException
	 */
	public Vector<Kontakt> hinzuzufuegendeKontakte (int nutzerID, int kontaktlisteID) throws IllegalArgumentException;

	public Teilhaberschaft findTeilhaberschaftByAuspraegungIdAndTeilhaberId(int auspraegungID, int nutzerID) throws IllegalArgumentException;

	public Eigenschaftauspraegung getAuspraegungByEigID(int eigID) throws IllegalArgumentException;
	
	/**
	 * Auslesen eines Vectors mit KontaktKontaktliste-Objekten, die die übergebene kontaktID als Fremdschlüssel besitzen
	 * 
	 * @param kontaktID die ID eines Kontaktes, dessen Zugehörigkeiten an Kontaktlisten ausgelesen werden sollen
	 * @return Vector mit KontaktKontaktliste-Objekten, die die übergebene kontaktID als Fremdschlüssel besitzen
	 * @throws IllegalArgumentException
	 */
	public Vector<KontaktKontaktliste> findKontaktKontaktlisteByKontaktID(int kontaktID) throws IllegalArgumentException;
	
	
	/**
	 * Auslesen eines Vectors mit allen Kontaktlisten, zu denen ein Kontakt hinzugefügt werden kann.
	 * 
	 * @param kontaktID die ID des Kontaktes der zu einer Kontaktliste hinzugefügt werden soll
	 * @param nutzerID die ID des angemeldeten Nutzers
	 * @return	Vector mit allen Kontaktlisten-Objekten, zu denen der Kontakt noch nicht hinzugefügt wurde
	 * @throws IllegalArgumentException
	 */
	public Vector<Kontaktliste> findKontaktlistenToAddKontakt (int kontaktID, int nutzerID) throws IllegalArgumentException;


	

}