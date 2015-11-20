package main;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * La thread de connexion permettant de faire se connecter plusieurs clients au
 * serveur
 * 
 */
public class ConnexionThread extends Thread {

	private Socket soc;
	public boolean b = true;

	public ConnexionThread(Socket soc) {
		super("ConnexionThread");
		this.soc = soc;
	}

	/**
	 * 
	 */
	public void run() {
		try {
			System.out.println("Le client " + soc + " vient de se connecter.");

			ObjectOutputStream out = new ObjectOutputStream(
					soc.getOutputStream());

			ObjectInputStream in = new ObjectInputStream(soc.getInputStream());

			out.writeObject("Bienvenue");

			while (b) {

				Object objetRecu = in.readObject();
				Requete r = (Requete) objetRecu;
				if (r == null) {
					System.out.println("Le client " + soc
							+ " vient de se déconnecter.");
					out.writeObject("Au revoir et merci d'avoir utilisé notre serveur de surnoms.");
					break;
				}
				out.writeObject(r.process(Serveur.bd));
			}
			in.close();
			out.close();
			soc.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
