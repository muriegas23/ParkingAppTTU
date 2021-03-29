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
    
	public Project_Release_1() {
		
	}
    
    public static void main(String[] args) {
        
        int total = NStudent + NStaff + EStudent + EStaff + SStudent + SStaff + WStudent + WStaff;
        System.out.println(total);
        NSParking = NSParking - 30;
        System.out.println(NSParking);
        simulate(total);

    }
    
    public static void simulate(int total) {
        while (!(NSParking <= 0 && NStParking <= 0 && ESParking <= 0 && EStParking <= 0 && 
        		SSParking <= 0 && SStParking <= 0 && WSParking <= 0 && WStParking <= 0)){
        	System.out.println(total);
          if(NSParking > 0){
        	  NSParking -= NStudent;
        	  System.out.println("There are " + (NSParking) + " empty parking spots left at North Student Parking");
        	  int rando = rand.nextInt(10);
        	  NStudent += rando;
        	  total += rando;
	      }
	      if(NSParking <= 0){
	          System.out.println("There are no empty parking spots left at North Student Parking");
	      }
	      if(NStParking > 0){
	    	  NStParking -= NStaff;
	          System.out.println("There are " + (NStParking)+ " empty parking spots left at North Staff Parking");
        	  int rando = rand.nextInt(10);
        	  NStaff += rando;
        	  total += rando;
	      }
	      if(NStParking <= 0){
	          System.out.println("There are no empty parking spots left at North Staff Parking");
	      }
	      if(ESParking > 0){
	    	  ESParking -= EStudent;
	          System.out.println("There are " + (ESParking) + " empty parking spots left at East Student Parking");
        	  int rando = rand.nextInt(10);
        	  EStudent += rando;
        	  total += rando;
	      }
	      if(ESParking <= 0){
	          System.out.println("There are no empty parking spots left at East Student Parking");
	      }
	      if(EStParking > 0){
	    	  EStParking -= EStaff;
	          System.out.println("There are " + (EStParking) + " empty parking spots left at East Staff Parking");
        	  int rando = rand.nextInt(10);
        	  EStaff += rando;
        	  total += rando;
	      }
	      if(EStParking <= 0){
	          System.out.println("There are no empty parking spots left at East Staff Parking");
	      }
	      if(SSParking > 0){
	    	  SSParking -= SStudent;
	          System.out.println("There are " + (SSParking) + " empty parking spots left at South Student Parking");
        	  int rando = rand.nextInt(10);
        	  SStudent += rando;
        	  total += rando;
	      }
	      if(SSParking <= 0){
	          System.out.println("There are no empty parking spots left at South Student Parking");
	      }
	      if(SStParking > 0){
	    	  SStParking -= SStaff;
	          System.out.println("There are " + (SStParking) + " empty parking spots left at South Staff Parking");
        	  int rando = rand.nextInt(10);
        	  SStaff += rando;
        	  total += rando;
	      }
	      if(SStParking <= 0){
	          System.out.println("There are no empty parking spots left at South Staff Parking");
	      }
	      if(WSParking > 0){
	    	  WSParking -= WStudent;
	          System.out.println("There are " + (WSParking) + " empty parking spots left at West Student Parking");
        	  int rando = rand.nextInt(10);
        	  WStudent += rando;
        	  total += rando;
	      }
	      if(WSParking <= 0){
	          System.out.println("There are no empty parking spots left at West Student Parking");
	      }
	      if(WStParking > 0){
	    	  WStParking -= WStaff;
	          System.out.println("There are " + (WStParking)+ " empty parking spots left at West Staff Parking");
        	  int rando = rand.nextInt(10);
        	  WStaff += rando;
        	  total += rando;
	      }
	      if(WStParking <= 0){
	          System.out.println("There are no empty parking spots left at West Staff Parking");
	      }
        }
    }
    
}
