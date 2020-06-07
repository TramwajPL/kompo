package data;

import java.io.Serializable;
import java.util.ArrayList;

import logic.ContainerInterface;
import logic.Speed;
import logic.TooLargeIndexException;

/**
 * Klasa odpowiadaj�ca za przechowywanie zapisanych predkosci w li�cie
 *
 */
public class SpeedContainer implements Serializable, ContainerInterface<Speed>{
	private static final long serialVersionUID = 1L;
	private ArrayList<Speed> speeds;
	
	/**
	 * Bezparametrowy konstruktor klasy SpeedContainer
	 */
	public SpeedContainer(){
		speeds = new ArrayList<Speed>();
	}
	
	/**
	 * Ustawia liste pr�dko�ci wed�ug parametru
	 * @param speeds
	 */
	public void setSpeeds(ArrayList<Speed> speeds) {
		this.speeds = speeds;
	}
	
	/**
	 * Funkcja zapisu do stringu predko�ci znajduj�cych si� w li�cie
	 */
	@Override
	public String toString() {
		return "SpeedContainer [speeds=" + speeds + "]\n";
	}
	
	/**
	 * Funckja zwracaj�ca pr�dko�� o danym indeksie z listy
	 * @param index
	 */
	@Override
	public Speed get(int index) throws TooLargeIndexException {
		if (index> this.size()-1)
			throw new TooLargeIndexException();	
		return speeds.get(index);
	}
	
	/**
	 * Funkcja zwracaj�ca wielko�� listy
	 */
	@Override
	public int size() {
		return speeds.size();
	}
	
	/**
	 * Funkcja s�u��ca dodaniu nowej pr�dko�ci do listy
	 */
	@Override
	public void add(Speed speed) {
		speeds.add(speed);
	}
	
	/**
	 * Funkcja usuwaj�ca element z listy o danym indeksie
	 * @param index
	 */
	public void remove(int index) {
		speeds.remove(index);
	}
	
	/**
	 * Funkcja zwracaj�ca ca�� list� 
	 */
	@Override
	public ArrayList<Speed> getAll() {
		return speeds;
	}
}
