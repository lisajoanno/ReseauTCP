package serveur;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ConnexionThread extends Thread {

	private Socket soc;

	public ConnexionThread(Socket soc) {
		super("ConnexionThread");
		this.soc = soc;
	}

	public void run() {
		try {
			System.out.println("Serveur a accepte la connexion: " + soc);

			ObjectOutputStream out = new ObjectOutputStream(
					soc.getOutputStream());

			ObjectInputStream in = new ObjectInputStream(soc.getInputStream());

			out.writeObject("Bienvenue");

			Object objetRecu = in.readObject();
			Requete r = (Requete) objetRecu;
			out.writeObject(r.process(Serveur.bd));

			in.close();
			out.close();
			soc.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
