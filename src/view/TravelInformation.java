package view;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.Travel;


import static javafx.geometry.NodeOrientation.RIGHT_TO_LEFT;

public class TravelInformation {

    private Travel travel;
    private Label speedLabel = new Label("0");
    private Label totalOdometerLabel = new Label("0");
    private Label firstDailyOdometerLabel = new Label("0");
    private Label secondDailyOdometerLabel = new Label("0");
    private Group group = new Group();

    TravelInformation(Travel t){
        travel = t;
        setSpeedLabel();
        setTotalOdometerLabel();
        setFirstDailyOdometerLabel();
        setSecondDailyOdometerLabel();
    }

    private void setSpeedLabel() {
        speedLabel.setFont(new Font("Arial", 100));
        speedLabel.setLayoutX(160);
        speedLabel.setLayoutY(0);
        speedLabel.setTextFill(Color.WHITE);
    }

    private void setTotalOdometerLabel(){
        totalOdometerLabel.setLayoutX(20);
        totalOdometerLabel.setLayoutY(30);
        totalOdometerLabel.setFont(new Font("Verdana", 40));
        totalOdometerLabel.setTextFill(Color.WHITE);
    }

    private void setFirstDailyOdometerLabel() {
        firstDailyOdometerLabel.setLayoutX(350);
        firstDailyOdometerLabel.setLayoutY(20);
        firstDailyOdometerLabel.setFont(new Font("Verdana", 25));
        firstDailyOdometerLabel.setTextFill(Color.WHITE);
        firstDailyOdometerLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle (MouseEvent me){
                travel.resetFirstOdometer();
            };
        });
    }

    private void setSecondDailyOdometerLabel() {
        secondDailyOdometerLabel.setLayoutX(350);
        secondDailyOdometerLabel.setLayoutY(60);
        secondDailyOdometerLabel.setFont(new Font("Verdana", 25));
        secondDailyOdometerLabel.setTextFill(Color.WHITE);
        secondDailyOdometerLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle (MouseEvent me){
                travel.resetSecondOdometer();
            };
        });
    }

    void updateSpeedLabel(){
        speedLabel.setText(travel.getSpeedAsString());
    }

    void updateTotalOdometerLabel(){
        double temp1 = (int)travel.getTotalDistance();
        temp1 /= 100;
        double temp2 = (int)temp1;
        temp2 /= 10;
        totalOdometerLabel.setText(String.valueOf(temp2));
    }

    void updateFirstDailyOdometerLabel(){
        double temp1 = (int)travel.getFirstOdometerValue();
        temp1 /= 100;
        double temp2 = (int)temp1;
        temp2 /= 10;
        firstDailyOdometerLabel.setText(String.valueOf(temp2));
    }

    void updateSecondDailyOdometerLabel(){
        double temp1 = (int)travel.getSecondOdometerValue();
        temp1 /= 100;
        double temp2 = (int)temp1;
        temp2 /= 10;
        secondDailyOdometerLabel.setText(String.valueOf(temp2));
    }

    Group getGroup(){
        group.getChildren().add(speedLabel);
        group.getChildren().add(totalOdometerLabel);
        group.getChildren().add(firstDailyOdometerLabel);
        group.getChildren().add(secondDailyOdometerLabel);
        BorderPane.setAlignment(group, Pos.CENTER);
        group.setNodeOrientation(RIGHT_TO_LEFT);
        return group;
    }
}
