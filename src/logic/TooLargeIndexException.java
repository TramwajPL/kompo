package logic;

public class TooLargeIndexException extends Exception{
	private static final long serialVersionUID = 1L;

	
	public TooLargeIndexException() {
		System.err.println("Value is greater than size of the container");
	}
}
