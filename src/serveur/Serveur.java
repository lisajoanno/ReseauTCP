package serveur;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur extends ServerSocket {

	private static BaseDeDonnees bd;
	
	public Serveur(int port) throws IOException {
		super(port);
		this.bd = new BaseDeDonnees();
		
		Socket client = new Socket();
		while(true) {
			client = this.accept();
			try {
				DataInputStream is = new DataInputStream(client.getInputStream());
				Requete requete = (Requete) is;
				bd = requete.process(bd);
				
				PrintStream output = new PrintStream(client.getOutputStream());
			} catch (Exception e) {
				System.out.println(e);
			};
		}
	}
	
}
