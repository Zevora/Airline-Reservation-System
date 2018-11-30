/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airplane;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
    public TextField flightNum;

    @FXML
    private TextField numSeats;

    @FXML
    public TextField passID;

    @FXML
    private Button backButton;

    @FXML
    private TextField passName;
    String reservationID = "";
    String seatNum="";
    
    @FXML
    public void displaySeatMap (ActionEvent event) throws IOException
    {
        String fNumber = flightNum.getText(); //get flight number from textfield
        String passengerID = passID.getText(); //get passenger id from textfield
        reservationID = passengerID; //set reservationID to passengerID -- to be used for file/var naming
        String passengerName = passName.getText(); //get passenger name from textfield
        System.out.println("Variables defined"); //for debugging
        
        String[] reservationInfo = {passengerID, passengerName, seatNum, fNumber}; //create string to contain reservationInfo
                
        //create a flight reservation named after reservationID -- round about way of using passengerID
        FlightReservations reservationID = new FlightReservations(reservationInfo);
        
        //FlightReservations reservationID = new FlightReservations(reservationInfo);

        System.out.println("Flight reservation: "+this.reservationID+" created");//for debugging
        
        //switching to new pane
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
