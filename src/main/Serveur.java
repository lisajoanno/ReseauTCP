package main;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

/**
 * La classe serveur pour créer le serveur. 
 * Initialise la base de données et lance une connexionThread à 
 * chaque connexion d'un nouveau client.
 * 
 */
public class Serveur extends ServerSocket {

	static BaseDeDonnees bd = new BaseDeDonnees();

	private boolean ok = true;
	ServerSocket ss;

	/**
	 * Constructeur du serveur. 
	 * Initialisation de la base de données et acceptation des clients.
	 * 
	 * @param port
	 * @throws Exception
	 */
	public Serveur(int port) throws Exception {
		System.out.println("Lancement du serveur sur le port " + port + "...");
		// Initialisation de la base de données
		Personne p = new Personne();
		Personne p2 = new Personne();
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		list.add("superlisa");
		p.setNom("Lisa");
		p.setSurnoms(list);
		list2.add("Nono");
		p2.setNom("Arnaud");
		p2.setSurnoms(list2);
		bd.ajouterPersonne(p);
		bd.ajouterPersonne(p2);

		// Création de la socket du serveur.
		try {
			ss = new ServerSocket(2222);
		} catch (IOException e) {
			System.out.println("Erreur !");
			e.printStackTrace();
		}

		// Création d'une connexion thread à chaque connexion d'un client.
		while (ok) {
			new ConnexionThread(ss.accept()).start();
		}

		ss.close();
	}

}
