package view;

import javafx.scene.Group;

/**
 * Klasa służąca jako kontroler obsługi świateł kierunkowskazów. W momencie naciśnięcia lewej lub prawej strzałki
 * klawiatury następuję włączenie odpowiedniego kierunkowskazu i wyłączenie kierunkowskazu przeciwnego kierunku, o ile
 * był wcześniej włączony.
 */


public class DirectionIndicatorsController {

    private LeftIndicatorLight lil = new LeftIndicatorLight();
    private RightIndicatorLight ril = new RightIndicatorLight();

    /**
     * rilIsActive to atrybut typu boolean, który zależny jest od stanu prawego kierunkowskazu. Przyjmuje wartość
     *                    true, gdy jest włączony oraz false, gdy kierunkowskaz jest wyłączony.
     * lilIsActive to atrybut typu boolean, który zależny jest od stanu lewego kierunkowskazu. Przyjmuje wartość
     *                    true, gdy jest włączony oraz false, gdy kierunkowskaz jest wyłączony.
     */
    private boolean rilIsActive = false;
    private boolean lilIsActive = false;

    public DirectionIndicatorsController(){}

    /**
     * metoda odpowiedzialna za włączanie prawego kierunkowskazu
     */

    public void rilController(){
        if (lilIsActive) {
            lil.turnOff();
            lilIsActive = false;
        }
        if (rilIsActive) {
            ril.turnOff();
            rilIsActive = false;
        } else {
            ril.turnOn();
            rilIsActive = true;
        }
    }

    /**
     * metoda odpowiedzialna za włączanie lewego kierunkowskazu
     */

    public void lilController(){
        if (rilIsActive) {
            ril.turnOff();
            rilIsActive = false;
        }

        if (lilIsActive) {
            lil.turnOff();
            lilIsActive = false;
        } else {
            lil.turnOn();
            lilIsActive = true;
        }
    }

    /**
     * @return grupa obiektów reprezentujących lewy kierunkowskaz
     */

    public Group getLil() {
        return lil.getGroup();
    }

    /**
     * @return grupa obiektów reprezentujących prawy kierunkowskaz
     */

    public Group getRil() {
        return ril.getGroup();
    }

}
