package airplane;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import java.lang.reflect.Method;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class displaySeatMapController extends ReservationController
{

    @FXML
    private Label displayLabel;

    @FXML
    private Text availableSeatLabel;

    @FXML
    private TextField rowField;

    @FXML
    private Button backButton;
    
    @FXML
    public static Label flightLabel;

    @FXML
    private AnchorPane seatMapPane;

    @FXML
    private TextField columnField;
    
    //initialize location to null
    String r = ""; String c = "";
    //initialize fNumber to reservationID's fNumber
    String fNumber = flightNum.getText();
    
    String[] updatedReservationInfo = {};

    @FXML
    void reserve() throws FileNotFoundException, IOException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException //button to Confirm the Reservation
    {
            //May make the actual printing into its own function to be clled twice -- once before and once after update
        //create StringBuilder called seatingMap
        StringBuilder seatingMap = new StringBuilder();
        //set filePath to be used for grabbing the file
        String filePath = "file:C:\\Users\\Owner\\Desktop\\Programming2\\GroupProject\\airplane_2\\Flight #"+fNumber;
        System.out.println("Sending to "+filePath+". Filename: "+fNumber);
        
            try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
            {
                String sCurrentLine; while ((sCurrentLine = br.readLine()) != null)
                {
                    seatingMap.append(sCurrentLine).append("\n");
                }
            }
            
        //CREATE TEXT AREA AND PRINT STRING BUILDER

        System.out.println("Made it past bufferedreader");
        System.out.println(seatingMap+"\nSuccessfully Printed!\n");//printing seating map to screen for debugging
        
        displayLabel.setText(seatingMap.toString()); //Cannot get Label to display on scene pane, causes crash        

        //redefine variables
        r = rowField.getText(); c = columnField.getText();
        String seatSelection = r+c+"";
        System.out.println("Column: "+c+"\nRow: "+r);//for debugging
        
        if((Character.isDigit(c.charAt(0))) || (Character.isLetter(r.charAt(0))))
        {System.err.println("Error . . . Invalid entry");}
        
        char[][] newFlightMap=null;
        newFlightMap[Integer.parseInt(r)][Integer.parseInt(c)] = 'X';//sets desired seating location to and 'X'//need to test
        Map.updateMap(fNumber, newFlightMap);//uses updateMap to create new, updated map     
        
        //update reservation using reflection -- still wrapping my head around it
        System.out.println("attempting to update reservation . . . ");
        Method setSeat = reservationID.getClass().getMethod("setSeat"); //get the setSeat method from reservationID
        Object something = setSeat.invoke(reservationID); //placeholder to hold this reused bit
        something.getClass().getMethod("setSeat").invoke(something, seatSelection); //execute setSeat and pass row and col
        System.out.println("reservation, might be, updated");
        
    }
    
    
    @Override //chaos necessary to execute the reserve function upon scene loading
    public void initialize(URL url, ResourceBundle rb){
        try {
            reserve();
        } catch (IOException ex) {
            Logger.getLogger(AllFlightsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(displaySeatMapController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
    
    @FXML
    void goBack(ActionEvent event) throws IOException   //Goes back to the main menu
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        seatMapPane.getChildren().setAll(pane);
    }


}
