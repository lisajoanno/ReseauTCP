package exception;

public class SurnomDejaExistant extends Exception {

	public SurnomDejaExistant() {
		System.err.println("Ce surnom est deja pris !");
	}

}
