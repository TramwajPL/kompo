package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import logic.ContainerInterface;
import logic.Speed;
import logic.TooLargeIndexException;

/**
 * Klasa odpowiadaj¹ca za przechowywanie zapisanych predkosci w liœcie
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
	 * Ustawia liste prêdkoœci wed³ug parametru
	 * @param speeds
	 */
	public void setSpeeds(ArrayList<Speed> speeds) {
		this.speeds = speeds;
	}
	
	/**
	 * Funkcja zapisu do stringu predkoœci znajduj¹cych siê w liœcie
	 */
	@Override
	public String toString() {
		return "SpeedContainer [speeds=" + speeds + "]\n";
	}
	
	/**
	 * Funckja zwracaj¹ca prêdkoœæ o danym indeksie z listy
	 * @param index
	 */
	@Override
	public Speed get(int index) throws TooLargeIndexException {
		if (index> this.size()-1)
			throw new TooLargeIndexException();	
		return speeds.get(index);
	}
	
	/**
	 * Funkcja zwracaj¹ca wielkoœæ listy
	 */
	@Override
	public int size() {
		return speeds.size();
	}
	
	/**
	 * Funkcja s³u¿¹ca dodaniu nowej prêdkoœci do listy
	 */
	@Override
	public void add(Speed speed) {
		speeds.add(speed);
	}
	
	/**
	 * Funkcja usuwaj¹ca element z listy o danym indeksie
	 * @param index
	 */
	public void remove(int index) {
		speeds.remove(index);
	}
	
	/**
	 * Funkcja zwracaj¹ca ca³¹ listê 
	 */
	@Override
	public ArrayList<Speed> getAll() {
		return speeds;
	}
}
