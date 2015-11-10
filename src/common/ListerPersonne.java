package common;

import java.io.Serializable;

public class ListerPersonne implements Requete, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1178456591485909596L;

	public BaseDeDonnees process(BaseDeDonnees bd) {
		System.out.println("Liste des utilisateurs : ");
		for (Personne personne : bd.getListePersonnes()) {
			System.out.println("Nom : " + personne.getNom() + " --- Pseudo : "
					+ personne.getSurnoms());
		}
		return bd;
	}

}
