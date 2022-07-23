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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Lyan
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private AnchorPane mainMenu;
    
    @FXML
    private Button newReservation;

    @FXML
    private Button listReservations;

    @FXML
    private Button specificFlight;

    @FXML
    private Button newFlight;

    @FXML
    private Button displaySeats;

    @FXML
    private Button listFlights;
    
    @FXML
    private Button exitButton;
    
    
    @FXML
    void addFlight(ActionEvent event) throws IOException
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("makeFlight.fxml"));
        mainMenu.getChildren().setAll(pane);
    }
    
    @FXML
    void makeReservation (ActionEvent event) throws IOException
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Reservation.fxml"));
        mainMenu.getChildren().setAll(pane);
    }
    
    @FXML
    void displaySeats(ActionEvent event) throws IOException
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("PassengerSeatMap.fxml"));
        mainMenu.getChildren().setAll(pane);
    }
    
    @FXML
    void listFlights(ActionEvent event) throws IOException
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("allFlights.fxml"));
        mainMenu.getChildren().setAll(pane);
    }
    
    @FXML
    void listAllReservationsAllFlights(ActionEvent event) throws IOException
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("allReservationsAllFlights.fxml"));
        mainMenu.getChildren().setAll(pane);
    }
    
    @FXML
    void exit (ActionEvent event) throws IOException
    {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
}
