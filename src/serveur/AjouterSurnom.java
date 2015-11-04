package serveur;

import exception.SurnomDejaExistant;
import java.util.*;

public class AjouterSurnom implements Requete {
	private String nomAajouter;

	@Override
	public ArrayList<Personne> process(ArrayList<Personne> lp) throws SurnomDejaExistant {
		for (Personne p : lp) {
			if (p.getSurnoms().contains(nomAajouter)) {
				throw new SurnomDejaExistant();
			}
		}
		return lp;
	}
}
