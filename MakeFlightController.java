/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airplane;

import airplane.ClassFolder.Flight;
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
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import static jdk.nashorn.internal.objects.ArrayBufferView.length;

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
    String flightID = "";
    
    @FXML
    void flightMaker(ActionEvent event) throws FileNotFoundException, IOException {        
        
        //Below are the variables/entries entered into/retrieved from application
        String fNumber = flightNum.getText();
        flightID = fNumber;
        String fDate = flightDate.getText();
        String dTime = DTime.getText();
        String aTime = ATime.getText();
        String dCity = DepartCity.getText();
        String aCity = DestCity.getText();
        String numOfSeats = AvailableSeats.getText();
        System.out.println("Variables declared/defined"); //for debugging
         
        String[] flightRegistry = {fNumber,fDate,dTime,aTime,dCity,aCity,numOfSeats};
        Flight flightID = new Flight(fNumber,fDate,dTime,aTime,dCity,aCity,numOfSeats); //create Flight object
        System.out.println("Flight #"+this.flightID+" created"); //for debugging 
        
        //create filewriter to write to allFlights.txt file
        FileWriter flights = new FileWriter("allFlights.txt");
        flights.write("Flight #\t FDate\t\t DTime\t\t ATime\t\t DepartCity\t\t DestCity\t\t AvailableSeats\n");
        flights.write(System.getProperty("line.separator"));
        for(String str: flightRegistry)
        {
            flights.write(str);
            flights.write("\t\t");
        }
        flights.close();
        
        System.out.println("Contents added"); //for debugging
        
        mapMaker(fNumber);
        
        System.out.println("Sending to mapMaker function"); //for debugging
    }
    
    
    @FXML
    void goBack (ActionEvent event) throws IOException
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        flightMakerPane.getChildren().setAll(pane);
    } 
    
    @FXML
    public void mapMaker(String mapName) throws IOException{
        
        System.out.println("MapMaker part1"); //for debugging
        FileWriter map = new FileWriter("Flight #"+mapName+".txt"); //names map after flight number
        
        char[][] fNumber = new char[8][10]; //create a map of 7 columns by 10 rows //need to name after fNumber
        System.out.println("Map: "+fNumber+" created"); //for debugging
        int count=1;//counter that is equal to row+1 for row numbering
        
            for(int row=0;row<=9;row++){
                char alphabet = 'A';
                map.write(count+"\t");
                
                for(int col=0;col<2;col++){ //prints 'ab' before tabbing over
                    fNumber[col][row] = alphabet;
                    map.write(fNumber[col][row]+' ');
                    System.out.print(fNumber[col][row]);//for debugging
                    alphabet++;
                }
                map.write(' ');
                
                for(int col=3;col<6;col++){ //print 'cde' before tabbing over
                    fNumber[col][row] = alphabet;
                    map.write(fNumber[col][row]+' ');
                    System.out.print(fNumber[col][row]);//for debugging
                    alphabet++;
                }
                map.write(' ');
                
                for(int col=6;col<8;col++){ //prints 'fg' before tabbing over
                    fNumber[col][row] = alphabet;
                    map.write(fNumber[col][row]+' ');
                    System.out.print(fNumber[col][row]);//for debugging
                    alphabet++;
                }           
                count++;//increment row counter
                map.write(System.getProperty("line.separator"));//skips line in file
                System.out.println("\n");//for debugging
            }            
        
        System.out.println("Map filled"); //for debugging
        map.close();
        System.out.println("MapMaker closed"); //for debugging
    }

    


    @Override
    public void initialize(URL url, ResourceBundle rb) {}    
    
}
