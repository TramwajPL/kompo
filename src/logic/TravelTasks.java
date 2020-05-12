package logic;

import java.util.TimerTask;

public class TravelTasks extends TimerTask {

    private Speed speed;
    private Distance distance = new Distance();

    TravelTasks(Speed s) {
        speed = s;
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
            distance.saveSpeed(speed.getSpeed());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


}
