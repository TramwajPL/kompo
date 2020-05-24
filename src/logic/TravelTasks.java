package logic;

import java.util.TimerTask;

/**
 * Klasa s�u�aca symulacji szybko�ci w trakcie podro�y
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
     * Funkcja wywo�uj�ca funkcje odpowiadaj�ce za 
     * obliczenie opor�w powietrza i przbeyty dystans
     */
    @Override
    public void run() {
        airResistanceEffect();
        averageSpeedSampler();
    }

    /**
     * Funkcja symuluj�ca efekt �redniej szybko�ci
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
     * Funkcja aktualizuj�ca przbeyty dystans
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
