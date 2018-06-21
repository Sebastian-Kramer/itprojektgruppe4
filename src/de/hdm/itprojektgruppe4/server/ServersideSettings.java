package de.hdm.itprojektgruppe4.server;

import java.util.logging.Logger;

import de.hdm.itprojektgruppe4.shared.CommonSettings;


/**
 * Klasse mit Eigenschaften und Diensten, die für alle serverseitigen Klassen relavant sind
 * 
 *
 */
public class ServersideSettings extends CommonSettings{

	private static final String LOGGER_NAME = "Projektmarktplatz Server";
	private static final Logger log = Logger.getLogger(LOGGER_NAME);
	
	/**
	 * Auslesen des serverseitigen zentralen Loggers
	 * @return Server-Seitige Logger-Insanz 
	 */
	public static Logger getLogger(){
		return log;
	}
}
