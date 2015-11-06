package common;



public class AjouterSurnom implements Requete {
	private String surnomAajouter;
	private String nomDestination;

	@Override
	public BaseDeDonnees process(BaseDeDonnees bd) throws Exception {
		return bd.ajouterSurnom(surnomAajouter, nomDestination);
	}
}
