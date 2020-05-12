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

@XmlRootElement(name="szybkoœci")
public class SpeedContainer implements Serializable, ContainerInterface<Speed>{
	private static final long serialVersionUID = 1L;
	private ArrayList<Speed> speeds;
	
	public SpeedContainer(){
		speeds = new ArrayList<Speed>();
	}
	
	public void setSpeeds(ArrayList<Speed> events) {
		this.speeds = speeds;
	}
	
	@Override
	public String toString() {
		return "SpeedContainer [speeds=" + speeds + "]\n";
	}
	
	@Override
	public Speed get(int index) throws TooLargeIndexException {
		if (index> this.size()-1)
			throw new TooLargeIndexException();	
		return speeds.get(index);
	}
	
	@Override
	public int size() {
		return speeds.size();
	}
	
	@Override
	public void add(Speed speed) {
		speeds.add(speed);
	}
	
	public void remove(int index) {
		speeds.remove(index);
	}
	
	@Override
    @XmlElements(@XmlElement(name="szybkoœæ"))
	public ArrayList<Speed> getAll() {
		return speeds;
	}
	
}
