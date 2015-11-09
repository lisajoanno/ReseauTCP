package common;

import java.io.Serializable;



public class AjouterSurnom implements Requete, Serializable {
	private String surnomAajouter;
	private String nomDestination;

	@Override
	public BaseDeDonnees process(BaseDeDonnees bd) throws Exception {
		return bd.ajouterSurnom(surnomAajouter, nomDestination);
	}
}
