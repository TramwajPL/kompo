package view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import logic.Travel;

public class Dashboard extends Application {

    private Travel travel = new Travel();
    private boolean cruiseControlFlag = true;
    private boolean rilIsActive = false;
    private boolean lilIsActive = false;


    @Override
    public void start(Stage stage) {
        BorderPane border = new BorderPane();
        border.setStyle("-fx-background-color:black;");
        Scene scene = new Scene(border);
        border.setMinSize(800,600);
        Speedometer speedometer = new Speedometer(travel);
        TravelInformation travelInformation = new TravelInformation(travel);

        KeyFrame labelUpdate = new KeyFrame(Duration.millis(5), e -> {
            travelInformation.updateSpeedLabel();
            travelInformation.updateTotalOdometerLabel();
            travelInformation.updateFirstDailyOdometerLabel();
            travelInformation.updateSecondDailyOdometerLabel();
            speedometer.updateNeedle();

        });
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(labelUpdate);

        AdditionalLights controlLight = new AdditionalLights();
        border.setTop(controlLight.getAdditionalLightsGroup());
        border.setCenter(speedometer.getSpeedometerGroup());
        border.setBottom(travelInformation.getGroup());

        LeftIndicatorLight lil = new LeftIndicatorLight();
        RightIndicatorLight ril = new RightIndicatorLight();
        border.setLeft(lil.getGroup());
        border.setRight(ril.getGroup());

        scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                //przyspieszanie
                if (ke.getCode() == KeyCode.UP) {
                    travel.accelerate();
                }
                //hamowanie
                if (ke.getCode() == KeyCode.DOWN) {
                    travel.brake();
                }

                if (ke.getCode() == KeyCode.LEFT) {
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

                if (ke.getCode() == KeyCode.RIGHT) {
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
                if (ke.getCode() == KeyCode.T) {
                    travel.cruiseController();
                }
                if(ke.getCode() == KeyCode.A) {
                    controlLight.hblController();
                }
                if(ke.getCode() == KeyCode.S) {
                    controlLight.dblController();
                }
                if(ke.getCode() == KeyCode.D){
                    controlLight.sdlController();
                }
                if(ke.getCode() == KeyCode.F) {
                    controlLight.rflController();
                }
                if(ke.getCode() == KeyCode.G) {
                    controlLight.fflController();
                }
            }
        });

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        stage.setX(300);
        stage.setY(200);
        stage.setMinHeight(600);
        stage.setMinWidth(800);
        stage.setScene(scene);
        stage.setTitle("Deska rozdzielcza");
        stage.show();
    }
}
