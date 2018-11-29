/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airplane.ClassFolder;

import airplane.MakeFlightController;
import java.io.IOException;

/**
 *
 * @author Owner
 */
public class Flight extends MakeFlightController {
    
    String fNumber,fDate,dTime,aTime,dCity,aCity,numOfSeats;
    String[] paras = {fNumber,fDate,dTime,aTime,dCity,aCity,numOfSeats};
    
    public Flight(String[] flightRegistry) throws IOException{ //arg constructor for flight
        for(int i=0;i<paras.length;i++){
            paras[i] = flightRegistry[i];
            System.out.println("Parameter = "+paras[i]+", given parameter = "+flightRegistry[i]); //for debugging
            
        }
        
        Map.createFlightMap(flightRegistry[0]);
        System.out.println("Sending to Map.createMap");
    }
    
    public void setNumOfSeats(){//decrements seat count on each creation of a reservation
        int newNumOfSeats = (Integer.parseInt(numOfSeats)-1);
        numOfSeats = Integer.toString(newNumOfSeats);
    }
}
