package common;

import java.util.ArrayList;


import exception.NomNonAttribue;
import exception.SurnomDejaExistant;

public class BaseDeDonnees {

	public ArrayList<Personne> listePersonnes;

	/**
	 * @param surnomAajouter
	 * @param nomDestination
	 * @return this
	 * @throws Exception
	 */
	public BaseDeDonnees ajouterSurnom(String surnomAajouter,
			String nomDestination) throws Exception {
		for (Personne p : listePersonnes) {
			if (p.getSurnoms().contains(surnomAajouter)) {
				throw new SurnomDejaExistant();
			}
			if (nomDestination.equals(p.getNom())) {
				p.addSurnom(surnomAajouter);
				return this;
			}
		}
		throw new NomNonAttribue();
	}

	/**
	 * @return the listePersonnes
	 */
	public ArrayList<Personne> getListePersonnes() {
		return listePersonnes;
	}

	/**
	 * @param listePersonnes
	 *            the listePersonnes to set
	 */
	public void setListePersonnes(ArrayList<Personne> listePersonnes) {
		this.listePersonnes = listePersonnes;
	}

}
