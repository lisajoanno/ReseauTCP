package common;

import java.io.Serializable;



public interface Requete extends Serializable {
	public BaseDeDonnees process(BaseDeDonnees l1) throws Exception;
}
