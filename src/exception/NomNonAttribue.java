package exception;

public class NomNonAttribue extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -816352165336575609L;

	public NomNonAttribue() {
		System.err.println("Ce nom n'est pas attribué.");
	}

}
