package common;



public class ListerPersonne implements Requete {

	@Override
	public BaseDeDonnees process(BaseDeDonnees bd) {
		for (Personne personne : bd.getListePersonnes()) {
			
		}
		return bd;
	}

}
