package logic;

/**
 * Klasa Speed odpowiada za tworzenie i obliczanie prêdkoœci
 * Posiada on a pola:
 * -speed
 * -acceleration
 * -airResistance
 * -ACC_MULTIPLIER
 * -BRAKE_MULTIPLIER
 */
public class Speed {
    private double speed = 0.0;
    private double acceleration = 0.0;
    private double airResistance = 0.6;
    private final double MAX_SPEED_LIMIT = 200.0;
    private final double MIN_SPEED_LIMIT = 0.0;
    private double ACC_MULTIPLIER = 0.002;
    private double BRAKE_MULTIPLIER = 3.0;
    
    /**
     * Funkcja ustawiaj¹ca BRAKE_MULTIPLIER na podan¹ wartoœæ
     * @param bRAKE_MULTIPLIER
     */
    public void setBRAKE_MULTIPLIER(double bRAKE_MULTIPLIER) {
		BRAKE_MULTIPLIER = bRAKE_MULTIPLIER;
	}

    /**
     * Funkcja ustawiaj¹ca ACC_MULTIPLIER na podan¹ wartoœæ
     * @param aCC_MULTIPLIER
     */
	public void setACC_MULTIPLIER(double aCC_MULTIPLIER) {
		ACC_MULTIPLIER = aCC_MULTIPLIER;
	}

    /**
     * Bezparametrowy kostruktor klasy Speed
     */
    Speed() {}

    /**
     * Konstruktor klasy Speed wpisuj¹cy w odpowiednie pola 
     * wartoœci przyjête przez uzytwkonika
     * @param speed
     * @param acceleration
     * @param airResistance
     */
    public Speed(double speed, double acceleration, double airResistance) {
        this.speed = speed;
        this.acceleration = acceleration;
        this.airResistance = airResistance;
    }

    /**
     * Funkcja zwracaj¹ca przyspieszenie
     * @return acceleration
     */
    public double getAcceleration() {
        return acceleration;
    }

    /**
     * Funkcja zwracaj¹ca opór powietrza
     * @return airResistance
     */
    public double getAirResistance() {
        return airResistance;
    }

    /**
     * Funkcja ustawiaj¹ca odpowiedni opór powietrza
     * @param airResistance
     */
    public void setAirResistance(double airResistance) {
        this.airResistance = airResistance;
    }

    /**
     * Funkcja obliczaj¹ca przyspieszenie
     */
    private void calculateAcceleration() {
        acceleration = (MAX_SPEED_LIMIT - speed) * ACC_MULTIPLIER;
    }

    /**
     * Funkcja ustawiaj¹ca acceleration na podan¹ wartoœæ
     * @param acceleration
     */
    public void setAcceleration(double acceleration) {
		this.acceleration = acceleration;
	}

	/**
     * Funkcja odpowiadaj¹ca za przyspieszanie
     */
    public void accelerate() {
        calculateAcceleration();
        speed += acceleration;
    }

    /**
     * Funkcja odpowiadaj¹ca za hamowanie
     */
    public void brake() {
        speed -= BRAKE_MULTIPLIER * acceleration;
        speedNoLowerThanZero();
    }

    /**
     * Funkcja odpowiadaj¹ca za obliczanie wp³ywu oporów
     * powietrza na aktualn¹ prêdkoœæ
     */
    public void airResistanceEffect() {
        speed -= airResistance;
        speedNoLowerThanZero();
    }

    /**
     * Funkcja ustawiaj¹ca pole speed na podan¹ wartoœæ
     * @param speed
     */
    public void setSpeed(double speed) {
		this.speed = speed;
	}

	/**
     * Funkcja spradzaj¹ca jak¹ ma aktualn¹ prêdkoœæ pojazd i 
     * ustawiaj¹c¹ j¹ na zero jeœli wed³ug obliczeñ wynikaj¹cych z oporów 
     * powietrza mia³a by byæ rowna zero.
     */
    private void speedNoLowerThanZero() {
        if (speed < MIN_SPEED_LIMIT) {
            speed = MIN_SPEED_LIMIT;
        }
    }

    /**
     * Funkcja zwracaj¹ca szybkoœæ
     * @return speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Funkcja parsuj¹ca szybkoœæ na string
     */
    public String getSpeedAsString() {
        return String.valueOf((int)speed);
    }

    /**
     * Funkcja parsuj¹ca szybkoœæ na int
     */
    public int getSpeedAsInt() {
        return (int) speed;
    }
}