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
import java.util.Arrays;

import common.*;
import common.AjouterSurnom;
import exception.*;

public class Serveur  {

	private static BaseDeDonnees bd;
	
	public Serveur(int port) throws Exception {
		 
		        ServerSocket s = new ServerSocket(port);
		        System.out.println("Socket serveur: " + s);
		 
		        Socket soc = s.accept();
		 
		        System.out.println("Serveur a accepte connexion: " + soc);
		 
		        ObjectOutputStream out = new ObjectOutputStream(soc.getOutputStream());
		        out.flush();
		 
		        ObjectInputStream in = new ObjectInputStream(soc.getInputStream());
		 
		 
		        System.out.println("Serveur a cree les flux");
		 
		        out.writeObject("Bienvenue");
		        out.flush();
		 
		        System.out.println("Serveur: donnees emises");
		        
		        Requete objetRecu = (Requete) in.readObject();
		        System.out.println(objetRecu);
		        Requete r = objetRecu;
		        out.writeObject(r.process(bd));
		 
		        in.close();
		        out.close();
		        soc.close();
		    }
			
}
