package serveur;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
                ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
                ObjectInputStream input = new ObjectInputStream(client.getInputStream());

                System.out.println("New client, address " + client.getInetAddress() + " on " + client.getPort() + ".");

                // Write the message and close the connection
                output.writeObject("xoxoxo");
				
				Requete requete = (Requete) input.readObject();
				bd = requete.process(bd);
                
				PrintStream outputS = new PrintStream(client.getOutputStream());
				outputS.println("hello");
			} catch (Exception e) {
				System.out.println(e);
			};
		}
		
	}
	
}
