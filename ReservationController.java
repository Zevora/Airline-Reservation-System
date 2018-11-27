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

    //@FXML
    //private Button makeReservation;

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


    @FXML
    void reservationMaker (ActionEvent event) throws IOException
    {
        
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
