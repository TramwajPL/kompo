package view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import logic.Travel;

/**
 * Główna klasa odpowiadająca za graficzny interfejs użytkownika. Znajdują się w niej ustawienia wyświetlania sceny.
 * Agreguje ona wszystkie klasy odpowiedzialne za wyświetlanie poszczególnych elementów interfejsu oraz nasłuchuje na
 * reakcje użytkownika w zakresie naciskania klawiszy klawiatury. Dodatkowo tworzy klasę Travel odpowiadającą
 * za całą logikę programu.
 */

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

        TopPanel topPanel = new TopPanel();
        border.setTop(topPanel.getTopPanel());
        border.setCenter(speedometer.getSpeedometerGroup());
        border.setBottom(travelInformation.getGroup());

        DirectionIndicatorsController dic = new DirectionIndicatorsController();
        border.setLeft(dic.getLil());
        border.setRight(dic.getRil());

        /**
         * Tutaj następuje mapowanie klawiszy klawiatury z poszczególnymi metodami odpowiedzialnymi za zmiany w logice,
         * jako reakcja na działania użytkownika.
         */
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
                    topPanel.hblController();
                }
                if(ke.getCode() == KeyCode.S) {
                    topPanel.dblController();
                }
                if(ke.getCode() == KeyCode.D){
                    topPanel.sdlController();
                }
                if(ke.getCode() == KeyCode.F) {
                    topPanel.rflController();
                }
                if(ke.getCode() == KeyCode.G) {
                    topPanel.fflController();
                }
            }
        });

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        stage.setX(300);
        stage.setY(200);
        stage.setMinHeight(800);
        stage.setMinWidth(1200);
        stage.setScene(scene);
        stage.setTitle("Deska rozdzielcza");
        stage.show();
    }



}
