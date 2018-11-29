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

import java.awt.*;

public class displaySeatMapController
{

    @FXML
    private TextField rowField;

    @FXML
    private Button backButton;

    @FXML
    private AnchorPane seatMapPane;

    @FXML
    private TextField columnField;

    @FXML
    void goBack(ActionEvent event) throws IOException   //Goes back to the main menu
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        seatMapPane.getChildren().setAll(pane);
    }

    @FXML
    void reserve(ActionEvent event) //button to Confirm the Reservation
    {
        /*
        Pseudocode begin
        
            read in passenger seat map file
            user makes selection
            if selection made
                add remaining details to flight reservation 
                update array of seating 
                update seat count
                update seat map
                create reservations.txt file
            
            confirm reservation
        
        */
    }
}
