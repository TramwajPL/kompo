package logic;

import java.util.ArrayList;

/**
 * Interfejs ContainerInterface implementuje klase EventContainer
 */
public interface ContainerInterface<T> {
	
	/**
	 * funkcja dodająca element do kontenera danych
	 * @param t
	 */
	public void add(T t);
	
	/**
	 * Funkcja zwracająca wielkość tablicy
	 * @return
	 */
	public int size();
	
	/**
	 * Funkcja zwracająca wszystkie elementy listy
	 * @return
	 */
	public ArrayList<T> getAll();
	
	/**
	 * Funkcja zwracająca elemnt tablicy o danym indeksie
	 * @param index
	 * @return
	 * @throws TooLargeIndexException
	 */
	public T get(int index) throws TooLargeIndexException;
}
