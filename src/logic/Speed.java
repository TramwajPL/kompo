package logic;

/**
 * Klasa Speed odpowiada za tworzenie i obliczanie pr�dko�ci
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
     * Funkcja ustawiaj�ca BRAKE_MULTIPLIER na podan� warto��
     * @param bRAKE_MULTIPLIER
     */
    public void setBRAKE_MULTIPLIER(double bRAKE_MULTIPLIER) {
		BRAKE_MULTIPLIER = bRAKE_MULTIPLIER;
	}

    /**
     * Funkcja ustawiaj�ca ACC_MULTIPLIER na podan� warto��
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
     * Konstruktor klasy Speed wpisuj�cy w odpowiednie pola 
     * warto�ci przyj�te przez uzytwkonika
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
     * Funkcja zwracaj�ca przyspieszenie
     * @return acceleration
     */
    public double getAcceleration() {
        return acceleration;
    }

    /**
     * Funkcja zwracaj�ca op�r powietrza
     * @return airResistance
     */
    public double getAirResistance() {
        return airResistance;
    }

    /**
     * Funkcja ustawiaj�ca odpowiedni op�r powietrza
     * @param airResistance
     */
    public void setAirResistance(double airResistance) {
        this.airResistance = airResistance;
    }

    /**
     * Funkcja obliczaj�ca przyspieszenie
     */
    private void calculateAcceleration() {
        acceleration = (MAX_SPEED_LIMIT - speed) * ACC_MULTIPLIER;
    }

    /**
     * Funkcja ustawiaj�ca acceleration na podan� warto��
     * @param acceleration
     */
    public void setAcceleration(double acceleration) {
		this.acceleration = acceleration;
	}

	/**
     * Funkcja odpowiadaj�ca za przyspieszanie
     */
    public void accelerate() {
        calculateAcceleration();
        speed += acceleration;
    }

    /**
     * Funkcja odpowiadaj�ca za hamowanie
     */
    public void brake() {
        speed -= BRAKE_MULTIPLIER * acceleration;
        speedNoLowerThanZero();
    }

    /**
     * Funkcja odpowiadaj�ca za obliczanie wp�ywu opor�w
     * powietrza na aktualn� pr�dko��
     */
    public void airResistanceEffect() {
        speed -= airResistance;
        speedNoLowerThanZero();
    }

    /**
     * Funkcja ustawiaj�ca pole speed na podan� warto��
     * @param speed
     */
    public void setSpeed(double speed) {
		this.speed = speed;
	}

	/**
     * Funkcja spradzaj�ca jak� ma aktualn� pr�dko�� pojazd i 
     * ustawiaj�c� j� na zero je�li wed�ug oblicze� wynikaj�cych z opor�w 
     * powietrza mia�a by by� rowna zero.
     */
    private void speedNoLowerThanZero() {
        if (speed < MIN_SPEED_LIMIT) {
            speed = MIN_SPEED_LIMIT;
        }
    }

    /**
     * Funkcja zwracaj�ca szybko��
     * @return speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Funkcja parsuj�ca szybko�� na string
     */
    public String getSpeedAsString() {
        return String.valueOf((int)speed);
    }

    /**
     * Funkcja parsuj�ca szybko�� na int
     */
    public int getSpeedAsInt() {
        return (int) speed;
    }
}