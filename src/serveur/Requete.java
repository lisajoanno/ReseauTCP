package serveur;

import java.util.*;

import exception.SurnomDejaExistant;

public interface Requete {
	public ArrayList<Personne> process(ArrayList<Personne> l1) throws Exception;
}
