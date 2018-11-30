/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airplane;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Owner
 */
public class Map extends Flight{

    public static char[][] flightMap = new char[8][10]; //create a map of 8 columns by 10 rows //need to name after fNumber

    public Map(String[] flightRegistry) throws IOException { //netbeans complains if this isn't present
        super(flightRegistry);
    }

            
    static void createFlightMap(String flightID) throws IOException{
        
        System.out.println("Beginning createFlightMap . . ."); //for debugging
        FileWriter map = new FileWriter("Flight #"+flightID+".txt"); //names file written to after flightID
        
        
        System.out.println("Map: "+flightID+" created"); //for debugging
        int count=1;//counter that is equal to row+1 for row numbering
        
            for(int row=0;row<=9;row++){
                char alphabet = 'A';
                map.write(count+"\t");
                
                for(int col=0;col<2;col++){ //prints 'ab' before tabbing over
                    flightMap[col][row] = alphabet;
                    map.write(flightMap[col][row]+' ');
                    System.out.print(flightMap[col][row]);//for debugging
                    alphabet++;
                }
                map.write(' ');
                
                for(int col=3;col<6;col++){ //print 'cde' before tabbing over
                    flightMap[col][row] = alphabet;
                    map.write(flightMap[col][row]+' ');
                    System.out.print(flightMap[col][row]);//for debugging
                    alphabet++;
                }
                map.write(' ');
                
                for(int col=6;col<8;col++){ //prints 'fg' before tabbing over
                    flightMap[col][row] = alphabet;
                    map.write(flightMap[col][row]+' ');
                    System.out.print(flightMap[col][row]);//for debugging
                    alphabet++;
                }           
                count++;//increment row counter
                map.write(System.getProperty("line.separator"));//skips line in file
                System.out.println("\n");//for debugging
            }            
        
        System.out.println("Map filled"); //for debugging
        map.close();
        System.out.println("MapMaker closed"); //for debugging

    }
    
    public static void updateMap(String flightID, char[][] newFlightMap) throws IOException{
        
        Map.flightMap = newFlightMap;
        Map.createFlightMap(flightID);
        
        System.out.println("Displaying new map: "+newFlightMap);
    }
}
