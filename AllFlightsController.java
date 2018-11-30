/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airplane;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Lyan
 */
public class AllFlightsController implements Initializable {

    @FXML
    private Button backButton;

    @FXML
    private Label allFlightsLabel;

    @FXML
    private AnchorPane flightMapPane;
    
    @FXML
    void goBack(ActionEvent event) throws IOException
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        flightMapPane.getChildren().setAll(pane);        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb){
        try {
            loadAllFlights();
        } catch (IOException ex) {
            Logger.getLogger(AllFlightsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
    @FXML
    void loadAllFlights() throws IOException{
        
        //create StringBuilder called seatingMap
        StringBuilder allFlights = new StringBuilder();
        //set filePath to be used for grabbing the file
        String filePath = "C:\\Users\\Owner\\Desktop\\Programming2\\GroupProject\\airplane_2\\allFlights.txt";
        System.out.println("Sending to "+filePath);
        
            try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
            {
                String sCurrentLine; while ((sCurrentLine = br.readLine()) != null)
                {
                    allFlights.append(sCurrentLine).append("\n");
                }
            }
        System.out.println("Made it past bufferedreader");
        System.out.println(allFlights+"\nSuccessfully Printed!\n");//printing seating map to screen for debugging
        
        allFlightsLabel.setText(allFlights.toString()); 
    }
    
}
