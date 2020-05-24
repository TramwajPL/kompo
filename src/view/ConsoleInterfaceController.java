package view;

import data.SpeedContainer;
import logic.Speed;

public class ConsoleInterfaceController {
	private SpeedContainer speeds;
	
	public ConsoleInterfaceController() {
		this.speeds = new SpeedContainer();
	}
	
	public void createSpeed(double speed, double acceleration, double airResistance) {
		Speed speede = new Speed(speed, acceleration, airResistance);
		speeds.add(speede);
	}
	
	public String showSpeeds() {
		
		return speeds.toString();
	}
	
	public void deleteSpeed(int index) {
		if(index<speeds.size() && index>-1) {
    		speeds.remove(index);
		}
		else {
        	System.out.println("Podano nieprawid³owe dane");
    	}
	}

}
