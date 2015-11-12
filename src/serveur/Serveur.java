package serveur;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import exception.SurnomDejaExistant;

public class Serveur extends ServerSocket {

	private static BaseDeDonnees bd = new BaseDeDonnees();

	public Serveur(int port) throws Exception {

		super(port);
		System.out.println("Socket serveur: " + port);

		Personne p = new Personne();
		ArrayList<String> list = new ArrayList();
		list.add("JP");
		p.setNom("Jean-Paul");
		p.setSurnoms(list);
		p.addSurnom("Popol");
		bd.ajouterPersonne(p);
		Socket soc = this.accept();

		System.out.println("Serveur a accepte connexion: " + soc);

		ObjectOutputStream out = new ObjectOutputStream(soc.getOutputStream());

		ObjectInputStream in = new ObjectInputStream(soc.getInputStream());

		out.writeObject("Bienvenue");

		Object objetRecu = in.readObject();
		Requete r = (Requete) objetRecu;
		out.writeObject(r.process(bd));

		in.close();
		out.close();
		soc.close();
	}

}
