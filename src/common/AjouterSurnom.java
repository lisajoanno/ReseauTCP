package common;

import java.io.Serializable;

public class AjouterSurnom implements Requete, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String surnomAajouter;
	private String nomDestination;

	public BaseDeDonnees process(BaseDeDonnees bd) throws Exception {
		return bd.ajouterSurnom(surnomAajouter, nomDestination);
	}
}
