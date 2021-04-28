// Names:
// Rodrigo Sanchez, Joshua Greenawalt, Razan Alnaber, Matthew Uriegas
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.*;
import java.util.logging.*;

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
    static String FP = "C:\\Users\\murie\\Desktop\\test\\Project_Release_1\\src\\";
    static Scanner inp = new Scanner(System.in);
    
    
    public static void main(String[] args) {
        
        int total = NStudent + NStaff + EStudent + EStaff + SStudent + SStaff + WStudent + WStaff;
        String[] parkLots = {"North Student Parking", "North Staff Parking", "East Student Parking", 
                             "East Staff Parking", "South Student Parking", 
                             "South Staff Parking", "West Student Parking", "West Staff Parking"};
        String[] Lots = {"NStudent", "NStaff", "EStudent", "EStaff", "SStudent", "SStaff", "WStudent", "WStaff"};
        
        int ind = 0;
    	int[] aver = {0, 0, 0, 0, 0, 0, 0, 0};
    	int rando = rand.nextInt(8), randEvent = rand.nextInt(5);

        while(ind != 7) {

		  display_menu(1);
	      System.out.println("Enter a choice: "); 
		  int uChoice = getUserInput();
		  
		  switch(uChoice) {
		  		case 1: // If user wants to sign in	
		  			String uName, uPwd = "";
		  			System.out.println("Enter your eRaider: ");
		  			uName = inp.nextLine();
		  			if(isUser(uName)) { // Checks if user exist in file
		  				System.out.println("Enter your password: ");
		  				uPwd = inp.nextLine();
		  				int trys = 0;
		  				
		  				while(!isPwd(uPwd) && trys != 3) { // Checks if user entered wrong password
		  					
		  					if(trys == 3) {
		  						System.out.println("You have exceeded your tries, returning to menu");
		  						continue;
		  					}
		  					System.out.println("Password is incorrect");
		  					System.out.println("Enter password again: ");
		  					uPwd=inp.nextLine();
		  					trys++;
		  				}
		  				
		  				System.out.println("You made it!\n"); //User successfully logs in
		  				System.out.println("Which area are you looking to park in? ");
		  				System.out.println("NStudent for North Student Parking / NStaff for North Staff Parking etc.. ");
		  				String area = inp.nextLine();
		  				
		  				if(isValidArea(Lots, area)) {
		  					while(!(checkStatus(area, uName, uPwd))) {
				  				System.out.println("Which area are you looking to park in? ");
				  				System.out.println("NStudent for North Student Parking / NStaff for North Staff Parking etc.. ");
				  				area = inp.nextLine();
		  					}
							display_menu(2);
							System.out.println("Enter a choice: "); 
							int uChoiceII = getUserInput();
							switch(uChoiceII) {
									case 1:
										
							}
		  					
		  				}
		  				else {
		  					System.out.println("This is not a valid area.");
		  					System.out.println("Returning to menu.");
		  					continue;
		  				}
		  				
		  			}
		  			else {
		  				System.out.println("User does not exist");
		  				System.out.println("You will be taken back to the main menu\n");
		  				continue;
		  			}
		  			break;
			
		  		case 2: // If user creates new account
		  			createUser();
		  			break;
			
		  		case 3: // If user wants to wait until the next day
		  			System.out.println("You will wait until the next day.");
		        	ind++;
		  			continue;
		  			
		  		case 4: // If user wants to exit
		  			System.exit(0);
		  			
		  		default:
		  			break;
		  		
		  }
          
        	simulate(parkLots, aver, rando, randEvent);
        	ind++;
        }

    	int lotAver = 0;
    	for(int i = 0; i < aver.length;i++) {
    		lotAver = averageSpots(aver[i], 7); // For loop used to check aver in each lot
    		System.out.println("The average spots used after each day for " + parkLots[i] + " is " + lotAver);
    	}
        
    }
    
    
    public static void spotsAvailable(int lotSpots, String a) {
    	
    	if(lotSpots > 0) {
    		System.out.println("There are " + (lotSpots) + " empty parking spots left at " + a);
    	}
    	else if(lotSpots <= 0){
	    	System.out.println("There are no empty parking spots left at " + a);
	    }
    }
    
    public static void simulate(String[] lots, int [] a, int rando, int rEvent) {

    	
    	for(int i = 0; i < lots.length; i++) {
    		if(i == rando) {
    			spotsAvail[i] = 0;
    			System.out.println("There are no spots available at " + lots[i] + " due to this ongoing "
    					+ "event: "+ events[rEvent]);
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
    			a[i] += takenSpots[i];
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
    	
        
    }
    
    public static void createUser() {
    	Object [] record = new Object[8];
		String temp = "";
			
        System.out.println("Enter your first name: "); 
        record[0] = inp.nextLine();
        System.out.println("Enter your last name: "); 
        record[1] = inp.nextLine();
        System.out.println("Enter your rNumber: "); 
        record[2] = getUserInput();
        System.out.println("Enter your eRaider: "); 
        record[3] = inp.nextLine();
        System.out.println("Enter your password: "); 
        record[4] = inp.nextLine();
        System.out.println("Are you a staff member? (Y or N): "); 
        temp = inp.nextLine();
        while(!(temp.toUpperCase().equals("Y")) && !(temp.toUpperCase().equals("N"))) {
        	System.out.println("That isn't a Y or N");
        	System.out.println("Are you a staff member? (Y or N): "); 
        	temp = inp.nextLine();
        }
        if(temp.toUpperCase().equals("Y")) {
        	record[5] = true;
        	record[7] = 1;
        }
        else {
        	record[5] = false;
            System.out.println("Since you are a student, Which parking lot do you have a permit to? "); 
            System.out.println("NStudent for North Student Parking / NStaff for North Staff Parking etc.. ");
            record[7] = inp.nextLine();
        }
        System.out.println("Enter your email: "); 
        record[6] = inp.nextLine();

        
			try {
  			BufferedWriter outputWriter = null;
			outputWriter = new BufferedWriter(new FileWriter(FP + "users.txt", true));
			for (int i = 0; i < record.length; i++) {
				// Maybe:
				if(i == record.length - 1) {
					outputWriter.write(record[i]+"\n");
					continue;
				}
				outputWriter.write(record[i]+",");


			}
			outputWriter.flush();  
			outputWriter.close(); 
			} catch(IOException e) {
				e.printStackTrace();
			}
    }
    
    public static int averageSpots(int a, int b) {
    	return a/b;
    }
    
    @SuppressWarnings("resource")
	public static int getUserInput() {
    	while(true) {
	        Scanner inp = new Scanner(System.in);
	        try {
	            int choice = inp.nextInt();
	            return choice;
	        } catch(Exception e) {
	        	System.out.println("Your choice needs to be an number.");
	        }
    	}
        
    }
    
    public static void display_menu(int mType) {
    	if(mType == 1) {
	        System.out.println("-----Welcome to Parking Texas Tech-----");
	        System.out.println("1.) Sign in");
	        System.out.println("2.) Create an Account");
	        System.out.println("3.) Skip a day");
	        System.out.println("4.) Exit");
    	}
    	else if(mType == 2) {
    		System.out.println("1. Check if spots available for that area");
    		System.out.println("2. Check if an event is going on in that area");
    		System.out.println("3. Check average spot usage in student area");
    		System.out.println("4. Return to main menu");
    	}
        
    }
    
    public static boolean isUser(String user) {
    	ArrayList<Object> result = new ArrayList<>();

    	try (Scanner s = new Scanner(new FileReader(FP + "users.txt"))) {
    	    while (s.hasNext()) {
    	        result.add(s.next());
    	    }
    	    s.close();
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	for(int i = 0; i<result.size();i++) {
    		String[] boi = ((String) result.get(i)).split(",");
    		if(boi[3].equals(user)) {
    			return true;
    		}
		
    	}    	
    	return false;
    }
    
    public static boolean isPwd(String pwd) {
    	ArrayList<Object> result = new ArrayList<>();

    	try (Scanner s = new Scanner(new FileReader(FP + "users.txt"))) {
    	    while (s.hasNext()) {
    	        result.add(s.next());
    	    }
    	    s.close();
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	for(int i = 0; i<result.size();i++) {
    		String[] boi = ((String) result.get(i)).split(",");
    		if(boi[4].equals(pwd)) {
    			return true;
    		}
		
    	}    	
    	return false;
    }
    
    public static boolean isValidArea(String [] arr, String str) {
    	
         for (String element : arr) {
             if (element.equals(str)) {
                 return true;
             }
         }
         return false;

    }
    
    public static boolean checkStatus(String ar, String user, String pwd) {
    	ArrayList<Object> result = new ArrayList<>();

    	try (Scanner s = new Scanner(new FileReader(FP + "users.txt"))) {
    	    while (s.hasNext()) {
    	        result.add(s.next());
    	    }
    	    s.close();
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	for(int i = 0; i<result.size();i++) {
    		String[] records = ((String) result.get(i)).split(",");
    		if(records[3].equals(user)) {
    			if(records[7].equals("1")) {
    				return true;
    			}
    			else if(records[7].equals(ar)) {
    				return true;
    			}
    			else {
    				System.out.println("You do not have access to that area. ");
    				System.out.println("You have access to this area: " + records[7]);
    			}
    		}
		
    	}    	
    	return false;
    }
    
}
