package logic;

/**
 * Klasa wyj�tku zwracanego w trakcie z�ego wyboru u�ytkownika w 
 * interfejsie konsolowym
 */
public class ChoiceNotAvailableException extends Exception{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Bezparametrowy konstruktor klasy ChoiceNotAvailableException
	 */
	public ChoiceNotAvailableException() {
		System.err.println("The choice is out of range");
	}

}
