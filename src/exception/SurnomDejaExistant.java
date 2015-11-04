package exception;

public class SurnomDejaExistant extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -32473973890863542L;

	public SurnomDejaExistant() {
		System.err.println("Ce surnom est deja pris !");
	}

}
