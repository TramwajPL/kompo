package logic;

import java.util.TimerTask;

public class TravelTasks extends TimerTask {

    private Speed speed;
    private TravelInformation distance;

    TravelTasks(Speed s, TravelInformation d) {
        speed = s;
        distance = d;
    }

    @Override
    public void run() {
        airResistanceEffect();
        averageSpeedSampler();
    }

    private void airResistanceEffect(){
        try {
            speed.airResistanceEffect();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void averageSpeedSampler(){
        try {
            distance.updateDistance(speed.getSpeedAsInt());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
