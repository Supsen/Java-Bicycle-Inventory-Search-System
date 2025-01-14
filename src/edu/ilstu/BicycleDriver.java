/**
 * 
 */
package edu.ilstu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * The BicycleDriver class, in main method will display the menu of Bicycle shop and loop until user enter 7 to quit
 * @author Suphasit Sribuaai
 *
 */
public class BicycleDriver {

	/**
	 * @param args
	 */
	static BicycleInventory bicInven = new BicycleInventory(); // BicycleInventory global object
	static Scanner sc = new Scanner(System.in); // Scanner global object
	
	public static void main(String[] args) {
		System.out.print("Enter name: ");// ask user to enter their name
		String userName = sc.nextLine(); // stored user name in userName
		System.out.println("Welcome, "+userName+" to Wheels and Gears");
		
		bicInven.readInventory(); // reInventory method
		menuOptions(); // print main menu using menuOptions method
		int input = 0;
		int check = 0;
		//System.out.print("Make a choice: ");
		input = sc.nextInt();
		while(check != 7) { // if the input is not 7 the loop keep on running
			if(input >=1 && input <=7) {
				
				if(input == 1) {
					
					processByWheelSize(bicInven.getBikes());// if input is 1 call processByWheelSize method pass in bicInven object
					menuOptions(); // call menuOptions 
					input = sc.nextInt(); // after user input a number stored in "input" variable
				}
				else if (input == 2) 
				{
					String type = determineType();// if input is 2 call determineType method to get the return of Type in String
					processByType(bicInven.getBikes(), type);// call processByType method pass in bicInven object and type
					menuOptions();// call menuOptions 
					input = sc.nextInt();// after user input a number stored in "input" variable
					
				}
					else if (input == 3) 
					{
						processByGender(bicInven.getBikes());// if input is 3 call processByGender method pass in bicInven object
						menuOptions(); // call menuOptions 
						input = sc.nextInt(); // after user input a number stored in "input" variable
						
					}
						else if (input == 4) // Choice 4 
						{
							processByAssemble(bicInven.getBikes());// if the input is 4 call processByAssemble method pass in bicInven object
							menuOptions(); // call menuOptions 
							input = sc.nextInt(); // after user input a number stored in "input" variable
						}
							else if (input == 5) 
							{
								processByAllcriteria(bicInven.getBikes());// if the input is 5 call processByAllcriteria pass in bicInven object
								menuOptions(); // call menuOptions 
								input = sc.nextInt(); // after user input a number stored in "input" variable
							}
								else if (input == 6) 
								{
									outputList(bicInven.getBikes());// if the input is 6 call outputList method and print out the element in bike array
									menuOptions(); // call menuOptions 
									input = sc.nextInt(); // after user input a number stored in "input" variable
								}
								else if(input == 7) // 7 to quit the loop
								{
									check = 7; // set check to 7 then quit loop
								}
								
									
			}
			else 
			{
				System.out.println("Invalid entry. Try again.");// display if the input is invalid 
				menuOptions();// call menuOptions 
				input = sc.nextInt();
			}
			if(check == 7)// if check variable = 7, print Goodbye
				System.out.println("\nGoodbye");
			
		}
		
			
		
		
	}
	public static void menuOptions() {
		System.out.println("\n1- List inventory by wheel size\n"
				+ "2- List inventory by type\n"
				+ "3- List inventory by gender\n"
				+ "4- List inventory by assembled\n"
				+ "5- List inventory by all criteria\n"
				+ "6- List entire inventory\n"
				+ "7- Quit"
				+ "");
		System.out.print("Make a choice: ");
	}
	public static void getChoices(int num, int index1, int index2) {
		Scanner sc = new Scanner(System.in);
		if(num == 1) {
			bicInven.getChoices(null, index1, index2);
		}
	}
	public static void outputList(Bicycle[] bike) {
		
		for(int i=0;i<bike.length;i++) { // go through all element in the array and print all of them
			if(bike[i] != null)// do not print if null
				System.out.println(bike[i]);
		}
	}
	public static String determineType() {
		System.out.println("Select a bicycle type: \n"
				+ "1- mountain\n"
				+ "2- speed\n"
				+ "3- hybrid\n"
				+ "4- road\n"
				+ "5- dirt\n"
				+ "");
		System.out.print("Make a choice: ");
		int type = sc.nextInt();
		while(type < 1 || type > 5) //check if the input of is invalid or not, the valid input should be 1 to 5
		{
			System.out.println("Invalid. ");
			System.out.println("Select a bicycle type: \n"
					+ "1- mountain\n"
					+ "2- speed\n"
					+ "3- hybrid\n"
					+ "4- road\n"
					+ "5- dirt\n"
					+ "");
			System.out.print("Make a choice: ");
			type = sc.nextInt();
		}
			String stringType = null;
			switch (type) {// change input from integer to String
			case 1:
				stringType = "mountain";
				break;
			case 2:
				stringType = "speed";
				break;
			case 3:
				stringType = "hybrid";
				break;
			case 4:
				stringType = "road";
				break;
			case 5:
				stringType = "dirt";
				break;
				
			}
		
		return stringType; // return the String input
		
	}
	public static void processByType(Bicycle[] bike, String stringType) {
		
		System.out.print("How many you want to find?: "); // ask user to input number of bike they what to find
		int quantity2 = sc.nextInt();// stored in quantity2 variable 
		
		Bicycle[] newType = new Bicycle[bike.length];// go through bike array, if not null copy the element into newType
		for(int i=0;i<bike.length;i++) {
			if(bike[i] != null) {
				if(bike[i].getType().equalsIgnoreCase(stringType)) {// check if type is match then copy
					newType[i] = bike[i];
				}
			}
		}
		for(int i = 0;i<quantity2;i++) {
			if(newType[i] == null)
				quantity2 +=1; // if that location is null +1 to quantity 
			if(newType[i] != null) // if not null display to the screen
				System.out.println(newType[i]);
			
		}
		
	}
	public static void processByWheelSize(Bicycle[] bike) {
		System.out.print("Enter the wheel size--14 or 16: ");// ask user to enter wheel size
		int wheelSize = sc.nextInt();// stored in wheelSize
		while(wheelSize != 14 && wheelSize != 16) // check if the input is invalid
		{
			System.out.print("Enter the wheel size--14 or 16: ");// if input is invalid ask them to enter new value
			wheelSize = sc.nextInt();
		}
		System.out.print("How many you want to find?: ");
		int quantity = sc.nextInt();
		
		Bicycle[] newBike = new Bicycle[bike.length];
		for(int i=0;i<bike.length;i++) {
			if(bike[i] != null) {
				if(bike[i].getWheelSize() == wheelSize)
					newBike[i] = bike[i]; 
					
			}
		}
		
		for(int i = 0;i<quantity;i++) {
			if(newBike[i] == null)
				quantity +=1; // if null +1 to quantity 
			if(newBike[i] != null)
				System.out.println(newBike[i]);
			
		}
	}
	public static void processByGender(Bicycle[] bike) {
		System.out.println("What gender bike do you want: 1 for female 2 for male");
		int gender = sc.nextInt();
		while(gender != 1 && gender !=2) { //check if the input is not 1 or 2 
			System.out.println("What gender bike do you want: 1 for female 2 for male");
			gender = sc.nextInt(); // stored in gender
		}
		System.out.print("How many you want to find?: ");
		int quantity3 = sc.nextInt();
		
		char newGen = 's';
		switch(gender) { // switch case 1 to 'f' (female), 2 to 'm' (male)
		case 1:
			newGen = 'f';
			break;
		case 2:
			newGen = 'm';
			break;	
		}
		Bicycle[] newGender = new Bicycle[bike.length]; 
		for(int i=0;i<bike.length;i++) {
			if(bike[i] != null) {
				if(bike[i].getGender() == newGen) // compare if the gender is match to user needed
					newGender[i] = bike[i]; // stored that element that matched in newGender
			}
		}
		for(int i = 0;i<quantity3;i++) { // go through newGender array object and print
			if(newGender[i] == null)
				quantity3 +=1; // if null +1 to quantity 
			if(newGender[i] != null)
				System.out.println(newGender[i]);
			
		}
		
	}
	
	public static void processByAssemble(Bicycle[] bike) {
		System.out.println("Do you want this assembled? ");
		String assem = sc.next().toLowerCase(); // set all input to lower case
		while(!assem.equalsIgnoreCase("yes") && !assem.equalsIgnoreCase("no")) {// check if the input is invalid
			System.out.println("Do you want this assembled? ");
			assem = sc.next().toLowerCase();// stored in String variable named assem
		}
		switch(assem) { // switch case user input yes=true / no=false
		case "yes":
			assem = "true";
			break;
		case "no":
			assem = "false";
			break;
		}
		
		System.out.print("How many you want to find?: ");
		int quantity4 = sc.nextInt();
		Bicycle[] newAssem = new Bicycle[bike.length];
		for(int i=0;i<bike.length;i++) {
			if(bike[i] != null) {
				if(bike[i].getAssembled() == assem) // compare String true, false
					newAssem[i] = bike[i];// if String matched store in newAssem
			}
		}
		for(int i = 0;i<quantity4;i++) {
			if(newAssem[i] == null)
				quantity4 +=1; // if null +1 to quantity 
			if(newAssem[i] != null)
				System.out.println(newAssem[i]);
			
		}
	}
	public static void processByAllcriteria(Bicycle[] bike) {
//---------------------------------------------------------------------------------------------//
		System.out.print("Enter the wheel size--14 or 16: ");
		int wheelSize5 = sc.nextInt();
		while(wheelSize5 != 14 && wheelSize5 != 16) // calculate wheel size
		{
			System.out.print("Enter the wheel size--14 or 16: ");
			wheelSize5 = sc.nextInt();
		}
//---------------------------------------------------------------------------------------------//
		String type5 = determineType(); // calculate Type
//---------------------------------------------------------------------------------------------//
		System.out.println("What gender bike do you want: 1 for female 2 for male");
		int gender5 = sc.nextInt();
		while(gender5 != 1 && gender5 !=2) {
			System.out.println("What gender bike do you want: 1 for female 2 for male");
			gender5 = sc.nextInt();
		}
		char newGen = 's';
		switch(gender5) {
		case 1:
			newGen = 'f';
			break;
		case 2:
			newGen = 'm';
			break;	
		}
//---------------------------------------------------------------------------------------------//
		System.out.println("Do you want this assembled? ");
		String assem5 = sc.next().toLowerCase();
		while(!assem5.equalsIgnoreCase("yes") && !assem5.equalsIgnoreCase("no")) {
			System.out.println("Do you want this assembled? ");
			assem5 = sc.next().toLowerCase();
		}
		switch(assem5) { // switch case user input true/false
		case "yes":
			assem5 = "true";
			break;
		case "no":
			assem5 = "false";
			break;
		}
//---------------------------------------------------------------------------------------------//
		System.out.print("How many you want to find?: ");
		int quantity5 = sc.nextInt();
		Bicycle[] allCri = new Bicycle[bike.length];
		for(int i=0;i<bike.length;i++) {
			if(bike[i] != null) {
				if(bike[i].getWheelSize() == wheelSize5 && bike[i].getType().equalsIgnoreCase(type5) 
						&& bike[i].getGender() == newGen && bike[i].getAssembled() == assem5)
					allCri[i] = bike[i];
			}
		}
			for(int i = 0;i<quantity5;i++) {
				if(allCri[i] == null)
					quantity5 +=1; // if null +1 to quantity 
				if(allCri[i] != null) {
					System.out.println(allCri[i]);
					
				}
			}
		
		
	}

}
