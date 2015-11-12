package serveur;

import java.io.Serializable;
import java.util.ArrayList;

import exception.NomNonAttribue;
import exception.SurnomDejaExistant;

public class BaseDeDonnees implements Serializable {

	private ArrayList<Personne> listePersonnes = new ArrayList();

	public void ajouterPersonne(Personne p) {
		listePersonnes.add(p);
	}

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

	public String toString() {
		String myStr = "";
		for (Personne personne : this.getListePersonnes()) {
			myStr = ("Nom : " + personne.getNom() + " --- Pseudo : " + personne
					.getSurnoms());
		}
		return myStr;
	}

}
