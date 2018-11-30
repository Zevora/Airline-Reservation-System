/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airplane;

import java.io.FileNotFoundException;
import java.io.FileWriter;
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
public class MakeFlightController implements Initializable {

    @FXML
    private AnchorPane flightMakerPane;
        
    @FXML
    public TextField flightNum;

    @FXML
    public TextField DepartCity;

    @FXML
    public TextField flightDate;

    @FXML
    public TextField ATime;

    @FXML
    public TextField DTime;

    @FXML
    public TextField DestCity;

    @FXML
    private Button backButton;

    @FXML
    private Button createFlight;
    
    @FXML
    public TextField AvailableSeats;
    String flight = "";
    
        
    @FXML
    void goBack (ActionEvent event) throws IOException
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        flightMakerPane.getChildren().setAll(pane);
    } 
    
    @FXML
    void flightMaker(ActionEvent event) throws FileNotFoundException, IOException {        
        
        //Below are the variables/entries entered into/retrieved from application
        String fNumber = flightNum.getText();
        flight = fNumber;
        String fDate = flightDate.getText();
        String dTime = DTime.getText();
        String aTime = ATime.getText();
        String dCity = DepartCity.getText();
        String aCity = DestCity.getText();
        String numOfSeats = AvailableSeats.getText();
        System.out.println("Variables declared/defined"); //for debugging
        
        //all info needed to create flight
        String[] flightRegistry = {fNumber,fDate,dTime,aTime,dCity,aCity,numOfSeats};
        
        Flight flightID = new Flight(flightRegistry); //create new flight object called the val of flightID

        System.out.println("Flight #"+flight+" object created"); //for debugging 
        
        //create filewriter to write to allFlights.txt file
        FileWriter flights = new FileWriter("allFlights.txt");
        flights.write("Flight #\t FDate\t\t DTime\t\t ATime\t\t DepartCity\t\t DestCity\t\t AvailableSeats\n");
        flights.write(System.getProperty("line.separator"));
        for(String str: flightRegistry)
        {
            flights.write(str);
            flights.write("\t\t");
        }
        flights.close();//close file
        
        System.out.println("Contents added"); //for debugging
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {}    
    
}
