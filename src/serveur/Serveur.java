package serveur;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import common.BaseDeDonnees;
import common.ListerPersonne;
import common.Requete;

public class Serveur extends ServerSocket {

	private static BaseDeDonnees bd;

	public Serveur(int port) throws Exception {

		super(port);
		System.out.println("Socket serveur: " + port);

		Socket soc = this.accept();

		System.out.println("Serveur a accepte connexion: " + soc);

		ObjectOutputStream out = new ObjectOutputStream(soc.getOutputStream());
		out.flush();

		ObjectInputStream in = new ObjectInputStream(soc.getInputStream());

		System.out.println("Serveur a cree les flux");

		out.writeObject("Bienvenue");
		out.flush();

		System.out.println("Serveur: donnees emises");

		Object objetRecu = in.readObject();
		System.out.println(objetRecu);
		Requete r = (Requete) objetRecu;
		out.writeObject(r.process(bd));

		in.close();
		out.close();
		soc.close();
	}

}
