package view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;
import logic.Travel;

public class Dashboard extends Application {

    private Travel travel = new Travel();
    private boolean cruiseControlFlag = true;


    @Override
    public void start(Stage stage) {
        BorderPane border = new BorderPane();
        border.setStyle("-fx-background-color:black;");
        Scene scene = new Scene(border);
        border.setMinSize(600,400);

        Group lil = new LeftIndicatorLight().getGroup();
        Group ril = new RightIndicatorLight().getGroup();

        SpeedViewer sv = new SpeedViewer(travel);
        border.setCenter(sv.getPointerNeedle());
        border.setBottom(sv.getLabel());


//        VBox root = new VBox();
//        root.setMinSize(350, 250);
//        root.getChildren().add(sv.getLabel());

        KeyFrame labelUpdate = new KeyFrame(Duration.millis(5), e -> {
            sv.labelUpdate();
            sv.needleUpdate();
        });

        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(labelUpdate);

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
                    border.getChildren().remove(ril);
                    if(!border.getChildren().contains(lil)){
                        border.setLeft(lil);
                    }
                    else {
                        border.getChildren().remove(lil);
                    }
                }

                if (ke.getCode() == KeyCode.RIGHT) {
                    border.getChildren().remove(lil);
                    if(!border.getChildren().contains(ril)){
                        border.setRight(ril);
                    }
                    else {
                        border.getChildren().remove(ril);
                    }
                }
                if(ke.getCode() == KeyCode.T){
                    if(cruiseControlFlag){
                        travel.cruiseControlModeOn();
                        cruiseControlFlag = false;
                    }
                    else {
                        travel.cruiseControlModeOff();
                        cruiseControlFlag = true;
                    }

                }
            }
        });

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        stage.setX(600);
        stage.setY(300);
        stage.setMinHeight(600);
        stage.setMinWidth(800);
        stage.setScene(scene);
        stage.setTitle("Deska rozdzielcza");
        stage.show();
    }
}
