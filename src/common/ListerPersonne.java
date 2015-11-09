package common;

import java.io.Serializable;



public class ListerPersonne implements Requete, Serializable {

	@Override
	public BaseDeDonnees process(BaseDeDonnees bd) {
		for (Personne personne : bd.getListePersonnes()) {
			
		}
		return bd;
	}

}
