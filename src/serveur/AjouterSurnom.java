package serveur;

import exception.SurnomDejaExistant;
import exception.NomNonAttribue;
import java.util.*;

public class AjouterSurnom implements Requete {
	private String surnomAajouter;
	private String nomDestination;

	@Override
	public ArrayList<Personne> process(ArrayList<Personne> lp) throws Exception {
		for (Personne p : lp) {
			if (p.getSurnoms().contains(surnomAajouter)) {
				throw new SurnomDejaExistant();
			}
			if (nomDestination.equals(p.getNom())) {
				p.addSurnom(surnomAajouter);
				return lp;
			}
		}
		throw new NomNonAttribue();
	}
}
