package common;

import java.io.Serializable;

public abstract class Requete implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6061523072172561788L;

	public abstract BaseDeDonnees process(BaseDeDonnees l1) throws Exception;
}
