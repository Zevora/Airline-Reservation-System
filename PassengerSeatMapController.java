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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Lyan
 */
public class PassengerSeatMapController implements Initializable {

    @FXML
    private AnchorPane seatMapAnchorPane;

    @FXML
    private Button generateButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField flightNumberField;

    @FXML
    private Label mapLabel;

    @FXML
    void goBack(ActionEvent event) throws IOException
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        seatMapAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    void generate(ActionEvent event) throws IOException
    {
        String fNumber = flightNumberField.getText();
        //create StringBuilder called seatingMap
        StringBuilder seatingMap = new StringBuilder();
        //set filePath to be used for grabbing the file
        String filePath = "C:\\Users\\Owner\\Desktop\\Programming2\\GroupProject\\airplane_2\\Flight #"+fNumber+".txt";
        System.out.println("Sending to "+filePath+". Filename: "+fNumber);
        
            try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
            {
                String sCurrentLine; while ((sCurrentLine = br.readLine()) != null)
                {
                    seatingMap.append(sCurrentLine).append("\n");
                }
            }
        System.out.println("Made it past bufferedreader");
        System.out.println(seatingMap+"\nSuccessfully Printed!\n");//printing seating map to screen for debugging
        
        mapLabel.setText(seatingMap.toString()); //Cannot get Label to display on scene pane, causes crash
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
