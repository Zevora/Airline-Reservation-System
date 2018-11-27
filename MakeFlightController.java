/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airplane;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

import javafx.beans.value.*;
import static jdk.nashorn.internal.objects.ArrayBufferView.length;

/**
 * FXML Controller class
 *
 * @author Lyan
 */
public class MakeFlightController implements Initializable {

    @FXML
    private TextField flightNum;

    @FXML
    private TextField DepartCity;

    @FXML
    private TextField flightDate;

    @FXML
    private TextField ATime;

    @FXML
    private TextField DTime;

    @FXML
    private TextField DestCity;

    @FXML
    private TextField AvailableSeats;

    @FXML
    void flightMaker(ActionEvent event) throws FileNotFoundException, IOException {        
        
        //Below are the variables/entries entered into/retrieved from application
        String fNumber = flightNum.getText();
        String fDate = flightDate.getText();
        String dTime = DTime.getText();
        String aTime = ATime.getText();
        String dCity = DepartCity.getText();
        String aCity = DestCity.getText();
        String numOfSeats = AvailableSeats.getText();
        System.out.println("made it this far"); //for debugging
        
        //arraylist that contains the information
        ArrayList<String> flightReservation = new ArrayList<String>();
        
        //adding flight info into arraylist
        flightReservation.add(fNumber);
        flightReservation.add(fDate);
        flightReservation.add(dTime);
        flightReservation.add(aTime);
        flightReservation.add(dCity);
        flightReservation.add(aCity);
        flightReservation.add(numOfSeats);
        
        System.out.println("file created"); //for debugging 
        
        //create filewriter to write to flights.txt file
        FileWriter flights = new FileWriter("flights.txt");
        flights.write("Flight #\t FDate\t\t DTime\t\t ATime\t\t DepartCity\t\t DestCity\t\t AvailableSeats");
        for(String str: flightReservation)
        {
            flights.write(str);
            flights.write("\t\t");
        }
        flights.close();
        
        System.out.println("Contents added"); //for debugging
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
