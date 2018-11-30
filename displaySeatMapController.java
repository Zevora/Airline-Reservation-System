package airplane.ReservationDisplayMap;

import airplane.ClassFolder.FlightReservations;
import airplane.ClassFolder.Map;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class displaySeatMapController extends ReservationController
{

    @FXML
    private TextField rowField;

    @FXML
    private Button backButton;

    @FXML
    private AnchorPane seatMapPane;

    @FXML
    private TextField columnField;
    
    //initialize location to null
    String r = ""; String c = "";
    //initialize fNumber to reservationID's fNumber
    String fNumber = flightNum.getText();

    @FXML
    public void reserve(ActionEvent event) throws FileNotFoundException, IOException //button to Confirm the Reservation
    {
        //create StringBuilder called seatingMap
        StringBuilder seatingMap = new StringBuilder();
        //set filePath to be used for grabbing the file
        String filePath = "C:\\Users\\Owner\\Desktop\\Programming2\\GroupProject\\airplane\\Flight #"+fNumber+".txt";
        System.out.println("Sending to "+filePath+". Filename: "+fNumber);
        
            try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
            {
                String sCurrentLine; while ((sCurrentLine = br.readLine()) != null)
                {
                    seatingMap.append(sCurrentLine).append("\n");
                }
            }

        //redefine variables
        r = rowField.getText(); c = columnField.getText();
        System.out.println("Column: "+c+"\nRow: "+r);//for debugging
        
        if((Character.isDigit(c.charAt(0))) || (Character.isLetter(r.charAt(0))))
        {System.err.println("Error . . . Invalid entry");}
        
        char[][] newFlightMap=null;
        newFlightMap[Integer.parseInt(r)][Integer.parseInt(c)] = 'X';//sets desired seating location to and 'X'//need to test
        Map.updateMap(fNumber, newFlightMap);//uses updateMap to create new, updated map
        
        /*
        Pseudocode begin
        
            read in passenger seat map file DONE
            user makes selection DONE
            if valid selection made DONE
                add remaining details to flight reservation 
                update array of seating 
                update seat count
                update seat map
                create reservations.txt file
            
            confirm reservation
        
        */
        
    }
    
                
    @FXML
    void goBack(ActionEvent event) throws IOException   //Goes back to the main menu
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        seatMapPane.getChildren().setAll(pane);
    }

}
