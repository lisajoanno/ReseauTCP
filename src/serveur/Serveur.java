package serveur;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Serveur extends ServerSocket {

	static BaseDeDonnees bd = new BaseDeDonnees();

	private boolean ok = true;
	ServerSocket ss;

	public Serveur(int port) throws Exception {

		System.out.println("Socket serveur: " + port);

		Personne p = new Personne();
		ArrayList<String> list = new ArrayList<String>();
		list.add("JP");
		p.setNom("Jean-Paul");
		p.setSurnoms(list);
		p.addSurnom("Popol");
		bd.ajouterPersonne(p);

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
