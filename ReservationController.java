/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airplane.reservationsFolder;


import airplane.ClassFolder.FlightReservations;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

import javafx.beans.value.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author Lyan
 */
 

public class ReservationController implements Initializable 
{

   @FXML
    private AnchorPane reservationMakerPane;

    @FXML
    private TextField flightNum;

    @FXML
    private TextField numSeats;

    @FXML
    private TextField passID;

    @FXML
    private Button backButton;

    @FXML
    private TextField passName;
    String reservationID = "";

    @FXML
    public void displaySeatMap (ActionEvent event) throws IOException
    {
        String fNumber = flightNum.getText();
        String passengerID = passID.getText();
        reservationID = passengerID;
        String passengerName = passName.getText();
        System.out.println("Variables defined");
        
        FlightReservations reservationID = new FlightReservations();
        System.out.println("Flight reservation: "+this.reservationID+" created");//for debugging
        
        AnchorPane displayMap = FXMLLoader.load(getClass().getResource("displaySeatMap.fxml"));
        reservationMakerPane.getChildren().setAll(displayMap);
        System.out.println("Display changed from initial reservation screen to display seat map");//for debugging
    }

    @FXML
    void goBack(ActionEvent event) throws IOException
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        reservationMakerPane.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    
    
}
