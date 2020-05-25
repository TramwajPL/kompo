package logic;

public class ChoiceNotAvailableException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public ChoiceNotAvailableException() {
		System.err.println("The choice is out of range");
	}

}
