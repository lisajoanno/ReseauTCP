package serveur;

import java.io.Serializable;

public class ListerPersonne implements Requete, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1178456591485909596L;

	public String process(BaseDeDonnees bd) {
		return bd.toString();
	}

}
