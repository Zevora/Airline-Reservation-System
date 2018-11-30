/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airplane;

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
    String[] paras = {flightNum,passID,passName,seatNum};
    String[] reservationInfo = null;

    public FlightReservations(String[] reservationInfo) throws IOException {
        this.reservationInfo = reservationInfo;
        for(int i=0;i<paras.length;i++){
            paras[i] = reservationInfo[i];
            System.out.println("Parameter = "+paras[i]+", given parameter = "+reservationInfo[i]); //for debugging
            
        }        
    }
    public void setSeat(String seatNum){this.seatNum=seatNum;}
    
    public String getFlightNum(){return flightNum;}
    
}
