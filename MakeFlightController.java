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

    String fNumber="";
    
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
        flights.write("Flight #\t FDate\t\t DTime\t\t ATime\t\t DepartCity\t\t DestCity\t\t AvailableSeats\n");
        flights.write(System.getProperty("line.separator"));
        for(String str: flightReservation)
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
    public void mapMaker(String mapName) throws IOException{
        
        System.out.println("MapMaker part1"); //for debugging
        FileWriter map = new FileWriter(fNumber+".txt"); //need to name after fNumber 
        char[][] fNumber = new char[8][10]; //create a map of 7 columns by 10 rows
        System.out.println("Map created"); //for debugging
        
        

        int count=1;
        
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
                count++;
                map.write(System.getProperty("line.separator"));//skips line in file
                System.out.println("\n");//for debugging
            }            
        
        System.out.println("Map filled"); //for debugging
        map.close();
        System.out.println("MapMaker closed"); //for debugging
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
