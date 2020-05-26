package logic;

import java.util.ArrayList;

/**
 * Interfejs ContainerInterface implementuje klase EventContainer
 */
public interface ContainerInterface<T> {
	
	/**
	 * funkcja dodaj�ca element do kontenera danych
	 * @param t
	 */
	public void add(T t);
	
	/**
	 * Funkcja zwracaj�ca wielko�� tablicy
	 * @return
	 */
	public int size();
	
	/**
	 * Funkcja zwracaj�ca wszystkie elementy listy
	 * @return
	 */
	public ArrayList<T> getAll();
	
	/**
	 * Funkcja zwracaj�ca elemnt tablicy o danym indeksie
	 * @param index
	 * @return
	 * @throws TooLargeIndexException
	 */
	public T get(int index) throws TooLargeIndexException;
}
