package view;

import javafx.scene.Group;

public class DirectionIndicatorsController {



    private LeftIndicatorLight lil = new LeftIndicatorLight();
    private RightIndicatorLight ril = new RightIndicatorLight();

    private boolean rilIsActive = false;
    private boolean lilIsActive = false;

    public DirectionIndicatorsController(){

    }

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


    public Group getLil() {
        return lil.getGroup();
    }

    public Group getRil() {
        return ril.getGroup();
    }

}
