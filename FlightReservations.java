/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airplane.ClassFolder;

/**
 *
 * @author James C. Holland
 * 
 * Purpose: Create reservation object that contains flight info as well as the chosen seat number.
 * 
 * 
 */
public class FlightReservations extends Flight{
    String seatNum="";
    
    public FlightReservations(){}
    public FlightReservations(String fNumber, String fDate, String dTime, 
            String aTime, String dCity, String aCity, String numOfSeats,String seatNum)
    {
        this.seatNum=seatNum;
        String[] givenParameters = {fNumber, fDate, dTime, aTime, dCity, aCity, numOfSeats};
        
        //Attempt at auto intializing parameters *I'm lazy*
        for(int i=0;i<parameters.length;i++){
            parameters[i] = givenParameters[i];
            System.out.println("Parameter = "+parameters[i]+", given parameter = "+givenParameters[i]); //for debugging
        }
        System.out.println("\n");
    }
}
