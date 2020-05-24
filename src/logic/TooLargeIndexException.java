package logic;

/**
 * Klasa TooLargeIndexException rzuca wyjatek, gdy indeks wydarzenia przekracza
 * wielkosc kontenera danych
 */
public class TooLargeIndexException extends Exception{
	private static final long serialVersionUID = 1L;

	/**
	 * Wyswietla komunikat o podaniu zbyt duzego indeksu wydarzenia
	 */
	public TooLargeIndexException() {
		System.err.println("Value is greater than size of the container");
	}
}
