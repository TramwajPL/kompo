package logic;

import java.util.TimerTask;

public class TravelTasks extends TimerTask {

    private Speed speed;
    private Distance distance;

    TravelTasks(Speed s, Distance d) {
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
            distance.calculateTotalDistance(speed.getSpeedAsInt());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
