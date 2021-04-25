// Names:
// Rodrigo Sanchez, Joshua Greenawalt, Razan Alnaber, Matthew Uriegas
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;
/**
 *
 * @author Rodrigo 
 */
public class Project_Release_1 {

    /**
     * @param args the command line arguments
     */
    public static int NSParking= 200; //Total number of parking spots available
    public static int NStParking = 200; //Total number of parking spots available
    public static int ESParking = 200; //Total number of parking spots available
    public static int EStParking = 200; //Total number of parking spots available
    public static int SSParking = 200; //Total number of parking spots available
    public static int SStParking = 200; //Total number of parking spots available
    public static int WSParking = 200; //Total number of parking spots available
    public static int WStParking = 200; //Total number of parking spots available
	
    static Random rand = new Random();
    static int NStudent = rand.nextInt(50); //Assigning random number spots taken 
    static int NStaff = rand.nextInt(50); //Assigning random number spots taken
    static int EStudent = rand.nextInt(50); //Assigning random number spots taken
    static int EStaff = rand.nextInt(50); //Assigning random number spots taken
    static int SStudent = rand.nextInt(50); //Assigning random number spots taken
    static int SStaff = rand.nextInt(50); //Assigning random number spots taken
    static int WStudent = rand.nextInt(50); //Assigning random number spots taken
    static int WStaff = rand.nextInt(50); //Assigning random number spots taken
    static int[] spotsAvail = {200, 200, 200, 200, 200, 200, 200, 200};
    static int[] takenSpots = {NStudent, NStaff, EStudent, EStaff, SStudent, SStaff, WStudent, WStaff};
    static String[] events = {"Hub City Fest", "COVID-19 Testing", "Football Game", "Basketball Game","Graduation"};
    
    
	public Project_Release_1() {
		
	}
    
    public static void main(String[] args) {
        
        int total = NStudent + NStaff + EStudent + EStaff + SStudent + SStaff + WStudent + WStaff;
        String[] parkLots = {"North Student Parking", "North Staff Parking", "East Student Parking", 
                             "East Staff Parking", "South Student Parking", 
                             "South Staff Parking", "West Student Parking", "West Staff Parking"};
        
        System.out.println(total);
        simulate(parkLots);
        
    }
    
    
    public static void spotsAvailable(int lotSpots, String a) {
    	
    	if(lotSpots > 0) {
    		System.out.println("There are " + (lotSpots) + " empty parking spots left at " + a);
    	}
    	else if(lotSpots <= 0){
	    	System.out.println("There are no empty parking spots left at " + a);
	    }
    }
    
    
    public static void simulate(String[] lots) {

    	int ind = 0, rando = rand.nextInt(8), randEvent = rand.nextInt(5);
    	int[] aver = {0, 0, 0, 0, 0, 0, 0, 0};
    	while(ind != 7) {
        	for(int i = 0; i < lots.length; i++) {
        		if(i == rando) {
        			spotsAvail[i] = 0;
        			System.out.println("There are no spots available at " + lots[i] + " due to this ongoing "
        					+ "event: "+ events[randEvent]);
        			try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        		}
        		else{
        			spotsAvail[i] -= takenSpots[i];
        			spotsAvailable(spotsAvail[i], lots[i]);
        			aver[i] += takenSpots[i];
        			takenSpots[i] = rand.nextInt(50);
        			try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        		}
        	}
        	System.out.println();
        	ind++;
    	}
    	int lotAver = 0;
    	
    	for(int i = 0; i < aver.length;i++) {
    		lotAver = averageSpots(aver[i], 7); // For loop used to check aver in each lot
    		System.out.println("The average spots used after each day for " + lots[i] + " is " + lotAver);
    	}
        
    }
    
    
    
    public static int averageSpots(int a, int b) {
    	return a/b;
    }
    
}
