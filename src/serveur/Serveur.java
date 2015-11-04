package serveur;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Serveur extends ServerSocket {

	private static ArrayList<Personne> listePersonnes;
	
	public Serveur(int port) throws IOException {
		super(port);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the listePersonnes
	 */
	public ArrayList<Personne> getListePersonnes() {
		return listePersonnes;
	}
	/**
	 * @param listePersonnes the listePersonnes to set
	 */
	public void setListePersonnes(ArrayList<Personne> listePersonnes) {
		this.listePersonnes = listePersonnes;
	}

}
