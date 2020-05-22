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

    @Override
    public void start(Stage stage) {
        BorderPane border = new BorderPane();
        border.setStyle("-fx-background-color:black;");
        Scene scene = new Scene(border);
        border.setMinSize(800,600);
        Speedometer speedometer = new Speedometer(travel);
        TravelInformationPanel travelInformation = new TravelInformationPanel(travel);

        KeyFrame labelUpdate = new KeyFrame(Duration.millis(5), e -> {
            travelInformation.updateSpeedLabel();
            travelInformation.updateTotalOdometerLabel();
            travelInformation.updateFirstDailyOdometerLabel();
            travelInformation.updateSecondDailyOdometerLabel();
            travelInformation.updateJourneyTimeLabel();
            travelInformation.updateFuelConsumedLabel();
            travelInformation.updateAverageSpeed();
            speedometer.updateNeedle();
        });
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(labelUpdate);

        LightsController lightsController = new LightsController();
        border.setTop(lightsController.getLightsGroup());
        border.setCenter(speedometer.getSpeedometerGroup());
        border.setBottom(travelInformation.getGroup());

        DirectionIndicatorsController dic = new DirectionIndicatorsController();
        border.setLeft(dic.getLil());
        border.setRight(dic.getRil());

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
                    dic.lilController();
                }
                if (ke.getCode() == KeyCode.RIGHT) {
                    dic.rilController();
                }
                if (ke.getCode() == KeyCode.T) {
                    travel.cruiseController();
                }
                if(ke.getCode() == KeyCode.A) {
                    lightsController.hblController();
                }
                if(ke.getCode() == KeyCode.S) {
                    lightsController.dblController();
                }
                if(ke.getCode() == KeyCode.D){
                    lightsController.sdlController();
                }
                if(ke.getCode() == KeyCode.F) {
                    lightsController.rflController();
                }
                if(ke.getCode() == KeyCode.G) {
                    lightsController.fflController();
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
