package serveur;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import common.BaseDeDonnees;
import common.Requete;

public class Serveur extends ServerSocket {

	private static BaseDeDonnees bd;
	
	public Serveur(int port) throws IOException {
		super(port);
		this.bd = new BaseDeDonnees();
		
		System.out.println("Serveur de surnoms TCP, sur le port "+port+"...");

		while(true) {
			Socket client  = this.accept();
			try {
				System.out.println("Nouveau client, à l'adresse " + client.getInetAddress() + " sur le port " + client.getPort() + ".");

                // Open output stream
                OutputStream output = client.getOutputStream();

                System.out.println("New client, address " + client.getInetAddress() + " on " + client.getPort() + ".");

                // Write the message and close the connection
                output.write("oui oui".getBytes());
                client.close();
				
				
				Requete requete = (Requete) output;
				bd = requete.process(bd);
                
//				PrintStream output = new PrintStream(client.getOutputStream());
			} catch (Exception e) {
				System.out.println(e);
			};
		}
		
	}
	
}
