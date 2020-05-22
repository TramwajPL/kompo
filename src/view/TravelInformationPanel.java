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

public class TravelInformationPanel {

    private Travel travel;
    private Label speedLabel = new Label("0");
    private Label totalOdometerLabel = new Label("0");
    private Label firstDailyOdometerLabel = new Label("0");
    private Label secondDailyOdometerLabel = new Label("0");
    private Label journeyTimeLabel = new Label("0");
    private Label fuelConsumedLabel = new Label("0");
    private Label averageSpeedLabel = new Label("0");

    private Group group = new Group();

    TravelInformationPanel(Travel t){
        travel = t;
        setSpeedLabel();
        setTotalOdometerLabel();
        setFirstDailyOdometerLabel();
        setSecondDailyOdometerLabel();
        setJourneyTimeLabel();
        setAverageSpeedLabel();
        setFuelConsumedLabel();
        //setAverageCombustionLabel();
    }


    Group getGroup(){
        group.getChildren().add(speedLabel);
        group.getChildren().add(totalOdometerLabel);
        group.getChildren().add(firstDailyOdometerLabel);
        group.getChildren().add(secondDailyOdometerLabel);
        group.getChildren().add(journeyTimeLabel);
        group.getChildren().add(fuelConsumedLabel);
        group.getChildren().add(averageSpeedLabel);
        BorderPane.setAlignment(group, Pos.CENTER);
        group.setNodeOrientation(RIGHT_TO_LEFT);
        return group;
    }


    private void setFuelConsumedLabel(){
        fuelConsumedLabel.setLayoutX(5);
        fuelConsumedLabel.setLayoutY(0);
        fuelConsumedLabel.setFont(new Font("Verdana", 25));
        fuelConsumedLabel.setTextFill(Color.YELLOW);
    }

    private void setAverageSpeedLabel(){
        averageSpeedLabel.setLayoutX(5);
        averageSpeedLabel.setLayoutY(25);
        averageSpeedLabel.setFont(new Font("Verdana", 25));
        averageSpeedLabel.setTextFill(Color.RED);
    }


    private void setJourneyTimeLabel(){
        journeyTimeLabel.setLayoutX(5);
        journeyTimeLabel.setLayoutY(50);
        journeyTimeLabel.setFont(new Font("Verdana", 25));
        journeyTimeLabel.setTextFill(Color.GREEN);
    }

    private void setSpeedLabel() {
        speedLabel.setFont(new Font("Arial", 100));
        speedLabel.setLayoutX(160);
        speedLabel.setLayoutY(0);
        speedLabel.setTextFill(Color.WHITE);
    }

    private void setTotalOdometerLabel(){
        totalOdometerLabel.setLayoutX(160);
        totalOdometerLabel.setLayoutY(-40);
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
        double temp = parseNumber(travel.getTotalDistance());
        totalOdometerLabel.setText(String.valueOf(temp));
    }

    void updateFirstDailyOdometerLabel(){
        double temp = parseNumber(travel.getFirstOdometerValue());
        firstDailyOdometerLabel.setText(String.valueOf(temp));
    }

    private double parseNumber(double number){
        double temp1 = (int)number;
        temp1 /= 100;
        double temp2 = (int)temp1;
        temp2 /= 10;
        return temp2;
    }

    void updateSecondDailyOdometerLabel(){
        double temp = parseNumber(travel.getSecondOdometerValue());
        secondDailyOdometerLabel.setText(String.valueOf(temp));
    }


    void updateJourneyTimeLabel(){
        journeyTimeLabel.setText(String.valueOf(travel.getJourneyTime()) + "min");
    }

    void updateFuelConsumedLabel(){
        double temp = parseNumber(travel.getFuelConsumed());
        fuelConsumedLabel.setText(String.valueOf(temp) + "l");
    }

    void updateAverageSpeed(){
        averageSpeedLabel.setText(String.valueOf(travel.getAverageSpeed()) + "km/h");
    }


}
