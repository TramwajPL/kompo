package view;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;

public class LightsController {

    private Group lightsGroup = new Group();
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

    LightsController() {
        double scale = 0.5;
        BorderPane.setMargin(lightsGroup, new Insets(5));
        lightsGroup.getChildren().add(hbl.getGroup());
        lightsGroup.getChildren().add(dbl.getGroup());
        lightsGroup.getChildren().add(sdl.getGroup());
        lightsGroup.getChildren().add(rfl.getGroup());
        lightsGroup.getChildren().add(ffl.getGroup());
        lightsGroup.setScaleX(scale);
        lightsGroup.setScaleY(scale);
    }

    public void hblController(){
        if(isDblActive || isSdlActive){
            isDblActive = false;
            dbl.changeMode(isDblActive);
            isSdlActive = false;
            sdl.changeMode(isSdlActive);
        }
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
        if(isHblActive || isSdlActive){
            isHblActive = false;
            hbl.changeMode(isHblActive);
            isSdlActive = false;
            sdl.changeMode(isSdlActive);
        }
        if(!isDblActive) {
            isDblActive = true;
            dbl.changeMode(isDblActive);
        }
        else {
            isDblActive = false;
            dbl.changeMode(isDblActive);
        }
    }

    public void sdlController(){
        if(isHblActive || isDblActive){
            isHblActive = false;
            hbl.changeMode(isHblActive);
            isDblActive = false;
            dbl.changeMode(isDblActive);
        }
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

    public Group getLightsGroup(){
        return lightsGroup;
    }

}
