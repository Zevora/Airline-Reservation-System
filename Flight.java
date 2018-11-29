
package airplane.ClassFolder;

/**
 *
 * @author James C. Holland
 * 
 * Purpose: This file is to create a flight object that can be used to log flight info by flight number.
 * 
 */

public class Flight {
    
        String fNumber="";
        String fDate="";
        String dTime="";
        String aTime="";
        String dCity="";
        String aCity="";
        String numOfSeats="";
        
        //parameters necessary to satisfy flight creation
        String[] parameters = {fNumber, fDate, dTime, aTime, dCity, aCity, numOfSeats};

        
    public Flight(){}
    
    public Flight(String fNumber, String fDate, String dTime, 
            String aTime, String dCity, String aCity, String numOfSeats){
        
        String[] givenParameters = {fNumber, fDate, dTime, aTime, dCity, aCity, numOfSeats};
        
        //Attempt at auto intializing parameters *I'm lazy*
        for(int i=0;i<parameters.length;i++){
            parameters[i] = givenParameters[i];
            System.out.println("Parameter = "+parameters[i]+", given parameter = "+givenParameters[i]); //for debugging
        }
        System.out.println("\n");
    }
}
