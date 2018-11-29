/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airplane.ClassFolder;

import airplane.reservationsFolder.ReservationController;
import java.io.IOException;

/**
 *
 * @author James C. Holland
 * 
 * Purpose: Create reservation object that contains flight info as well as the chosen seat number.
 * 
 * 
 */
public class FlightReservations extends ReservationController{
    String seatNum="None Selected";
    String flightNum = "";
    String passID="";
    String passName="";

    public FlightReservations(String[] reservationInfo) throws IOException {
        
        
    }
    
    public String getFlightNum(){return flightNum;}
    
}
