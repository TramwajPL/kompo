package logic;

import java.util.TimerTask;

/**
 * Klasa służaca symulacji szybkości w trakcie podroży
 */
public class TravelTasks extends TimerTask {

    private Speed speed;
    private TravelInformation distance;

    /**
     * Konstruktor klasy TravelTasks
     * @param s
     * @param d
     */
    TravelTasks(Speed s, TravelInformation d) {
        speed = s;
        distance = d;
    }

    /**
     * Funkcja wywołująca funkcje odpowiadające za 
     * obliczenie oporów powietrza i przbeyty dystans
     */
    @Override
    public void run() {
        airResistanceEffect();
        averageSpeedSampler();
    }

    /**
     * Funkcja symulująca efekt średniej szybkości
     */
    private void airResistanceEffect(){
        try {
            speed.airResistanceEffect();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Funkcja aktualizująca przbeyty dystans
     */
    private void averageSpeedSampler(){
        try {
            distance.updateDistance(speed.getSpeedAsInt());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
