package logic;

import java.util.TimerTask;

/**
 * Klasa s³u¿aca symulacji szybkoœci w trakcie podro¿y
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
     * Funkcja wywo³uj¹ca funkcje odpowiadaj¹ce za 
     * obliczenie oporów powietrza i przbeyty dystans
     */
    @Override
    public void run() {
        airResistanceEffect();
        averageSpeedSampler();
    }

    /**
     * Funkcja symuluj¹ca efekt œredniej szybkoœci
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
     * Funkcja aktualizuj¹ca przbeyty dystans
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
