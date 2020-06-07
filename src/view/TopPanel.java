package view;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;

/**
 * Klasa stanowiąca kontroler świateł oraz zawierająca panel z ustawieniami.
 */

public class TopPanel {
    private Group topPanel = new Group();
    private Group lightsGroup = new Group();
    private HighBeamLight hbl = new HighBeamLight();
    private DippedBeamLight dbl = new DippedBeamLight();
    private SideLight sdl = new SideLight();
    private RearFogLight rfl = new RearFogLight();
    private FrontFogLight ffl = new FrontFogLight();
    private Settings settings = new Settings();

    /**
     * isHblActive - atrybut określający aktywność świateł drogowych.
     * isDblActive - atrybut określający aktywność świateł mijania.
     * isSdlActive - atrybut określający aktywność świateł pozycyjnych.
     * isRflActive - atrybut określający aktywność świateł przeciwmgielnych tylnych.
     * isFflActive - atrybut określający aktywność świateł przeciwmgielnych przednich.
      */
    private boolean isHblActive = false;
    private boolean isDblActive = false;
    private boolean isSdlActive = false;
    private boolean isRflActive = false;
    private boolean isFflActive = false;

    /**
     * W konstruktorze następuje dodanie obiektów do grupy oraz przeskalowanie i dodanie niewielkiego marginesu.
     */
    TopPanel() {
        double scale = 0.5;
        BorderPane.setMargin(lightsGroup, new Insets(5));
        lightsGroup.getChildren().add(hbl.getGroup());
        lightsGroup.getChildren().add(dbl.getGroup());
        lightsGroup.getChildren().add(sdl.getGroup());
        lightsGroup.getChildren().add(rfl.getGroup());
        lightsGroup.getChildren().add(ffl.getGroup());
        lightsGroup.setLayoutY(10);
        lightsGroup.setScaleX(scale);
        lightsGroup.setScaleY(scale);
        topPanel.getChildren().add(lightsGroup);
        topPanel.getChildren().add(settings.getMenuBar());
    }
    /**
     * Metoda określają zachowanie świateł drogowych. W momencie włączenia ich przez użytkownika następuje równoczesne
     * sprawdzenie, czy światła mijania i światła pozycyjne są włączone i w przypadku, gdy są, następuje ich
     * wyłączenie.
     */

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

    /**
     * Metoda określają zachowanie świateł mijania. W momencie włączenia ich przez użytkownika następuje równoczesne
     * sprawdzenie, czy światła drogowe i światła pozycyjne są włączone i w przypadku, gdy są, następuje ich
     * wyłączenie.
     */
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

    /**
     * Metoda określają zachowanie świateł pozycyjnych. W momencie włączenia ich przez użytkownika następuje równoczesne
     * sprawdzenie, czy światła mijania i światła drogowe są włączone i w przypadku, gdy są, następuje ich
     * wyłączenie.
     */
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

    /**
     * Metoda odpowiedzialna za włączanie i wyłączanie świateł przeciwmgielnych przednich.
     */
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

    /**
     * Metoda odpowiedzialna za włączanie i wyłączanie świateł przeciwmgielnych tylnych.
     */
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

    public void changeLightsColor(){
        //rfl.changeColor();
        //sdl.changeColor();
        //ffl.changeColor();
        hbl.changeColor();
        //dbl.changeColor();
    }


    /**
     * @return zwraca wszystkie kontrolki wszystkich pięciu świateł jako grupę.
     */
    public Group getLightsGroup(){
        return lightsGroup;
    }

    /**
     * @return zwraca wszystkie kontrolki wraz z menu ustawienia jako grupę.
     */

    public Group getTopPanel() { return topPanel; }
}
