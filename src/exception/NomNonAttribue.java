package exception;

public class NomNonAttribue extends Exception {
	
	public NomNonAttribue() {
		System.err.println("Ce nom n'est pas attribué.");
	}

}
