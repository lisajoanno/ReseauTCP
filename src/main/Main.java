package main;

/**
 * Classe de lancement côté serveur.
 * 
 * @author Arnaud GARNIER et Lisa JOANNO.
 * 
 */
public class Main {

	/**
	 * Main de l'application.
	 * 
	 * @param args
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		new Serveur(2222);
	}

}
