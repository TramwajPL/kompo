package view;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;

public class AdditionalLights {

    private Group additionalLightsGroup = new Group();
    private HighBeamLight hbl = new HighBeamLight();
    private DippedBeamLight dbl = new DippedBeamLight();
    private SideLight sdl = new SideLight();
    private RearFogLight rfl = new RearFogLight();
    private FrontFogLight ffl = new FrontFogLight();
    private boolean isHblActive = false;
    private boolean isDblActive = false;
    private boolean isSdlActive = false;
    private boolean isRflActive = false;
    private boolean isFflActive = false;

    AdditionalLights() {
        double scale = 0.5;
        BorderPane.setMargin(additionalLightsGroup, new Insets(5));
        additionalLightsGroup.getChildren().add(hbl.getGroup());
        additionalLightsGroup.getChildren().add(dbl.getGroup());
        additionalLightsGroup.getChildren().add(sdl.getGroup());
        additionalLightsGroup.getChildren().add(rfl.getGroup());
        additionalLightsGroup.getChildren().add(ffl.getGroup());
        additionalLightsGroup.setScaleX(scale);
        additionalLightsGroup.setScaleY(scale);
    }

    public void hblController(){
        if(!isHblActive) {
            hbl.turnOn();
            isHblActive = true;
        }
        else {
            hbl.turnOff();
            isHblActive = false;
        }
    }

    public void dblController(){
        if(!isDblActive) {
            dbl.turnOn();
            isDblActive = true;
        }
        else {
            dbl.turnOff();
            isDblActive = false;
        }
    }

    public void sdlController(){
        if(!isSdlActive) {
            sdl.turnOn();
            isSdlActive = true;
        }
        else {
            sdl.turnOff();
            isSdlActive = false;
        }
    }

    public void fflController(){
        if(!isFflActive) {
            ffl.turnOn();
            isFflActive = true;
        }
        else {
            ffl.turnOff();
            isFflActive = false;
        }
    }

    public void rflController(){
        if(!isRflActive) {
            rfl.turnOn();
            isRflActive = true;
        }
        else {
            rfl.turnOff();
            isRflActive = false;
        }
    }

    public Group getAdditionalLightsGroup(){
        return additionalLightsGroup;
    }

}
