package main;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

/**
 * La classe serveur pour créer le serveur.
 * 
 */
public class Serveur extends ServerSocket {

	static BaseDeDonnees bd = new BaseDeDonnees();

	private boolean ok = true;
	ServerSocket ss;

	/**
	 * Le constructeur
	 * 
	 * @param port
	 * @throws Exception
	 */
	public Serveur(int port) throws Exception {

		System.out.println("Socket serveur: " + port);

		Personne p = new Personne();
		Personne p2 = new Personne();
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("superlisa");
		p2.setNom("Lisa");
		p2.setSurnoms(list2);
		list.add("Nono");
		p.setNom("Arnaud");
		p.setSurnoms(list);
		p.addSurnom("rykii");
		bd.ajouterPersonne(p);
		bd.ajouterPersonne(p2);

		try {
			ss = new ServerSocket(2222);
		} catch (IOException e) {
			System.out.println("Erreur !");
			e.printStackTrace();
		}

		// on ne peut pas mettre while(true) sinon ss.close() est inatteignable
		while (ok) {
			new ConnexionThread(ss.accept()).start();
		}

		ss.close();
	}

}