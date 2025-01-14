package edu.ilstu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * The BicycleInventory class, this class will read through file, and stored the value in a Bicycle object, and also has a 
 * return method that return each element of Bicycle array object
 * @author Suphasit Sribuaai
 *
 */
public class BicycleInventory
{
	private Bicycle[] bicycle;
	
	/**
	 * Default constructor 
	 * 
	 * Set bicycle object length to 100
	 */
	public BicycleInventory() 
	{
		this.bicycle = new Bicycle[100];
	}
	/**
	 * readInventory method, this method will read the .txt file and store the value in bicycle object as assigned
	 * 
	 * 
	 */
	public void readInventory()
	{
		//***********************************************************************************
		//Do not change the code below*******************************************************
		int index = 0;						  						//Do not change*********
		try									   						//Do not change*********
		{									   						//Do not change*********
			File f = new File("bicycle.txt");  						//Do not change*********
			Scanner file = new Scanner(f);							//Do not change*********
			while (file.hasNextLine())								//Do not change*********
			{														//Do not change*********
				String[] line = file.nextLine().split(",");			//Do not change*********
				String type = line[0];								//Do not change*********
				int wheelSize = Integer.parseInt(line[1]);			//Do not change*********
				boolean assembled = Boolean.parseBoolean(line[2]);	//Do not change*********
				char gender = line[3].charAt(0);					//Do not change*********
		//***********************************************************************************
		// Use these values to create a Bicycle and add it to the array
				
				Bicycle bike = new Bicycle(type, wheelSize, assembled, gender);
				bicycle[index] = bike;
				index++;
				
				
				
		//Add code above this line
			}//Do not change****************************************************************
		} catch (FileNotFoundException ife)							//Do not change*********
		{															//Do not change*********
			System.out.println("Unable to open file.");				//Do not change*********
			System.out.println("Closing the program.");				//Do not change*********
		} catch (InputMismatchException misexc)						//Do not change*********
		{															//Do not change*********
			System.out.println("Invalid data type.");				//Do not change*********
		}															//Do not change*********
	}//**************************
	/**
	 * getChoices method, this method will search through bicycle object to match the user input and return the value
	 * 
	 * @param bike - bicycle object
	 * @param wheelSize - the wheel size entered by user
	 * @param index - number of bike that user want to find
	 * 
	 * @return reWheel2 - the return value that match user needed
	 */
	public Bicycle[] getChoices(Bicycle[] bike,int wheelSize, int index) {
		Bicycle[] newWheel = new Bicycle[bicycle.length]; 
		Bicycle[] reWheel2 = new Bicycle[index];
		for(int i=0; i<bicycle.length; i++) { // search through all elements
			if(bike[i] != null) {
				if(bike[i].getWheelSize() == wheelSize) {
					newWheel[i]=bicycle[i];
				}
			}
		}
		for(int i=0;i<=index;i++) {
			if(newWheel[i] != null)
				reWheel2[i] = newWheel[i];
		}
		 return reWheel2;
	}
	/**
	 * getBikes method, this method is to return the bicycle object value
	 * 
	 * @return - newBikes, the value of bicycle object
	 */
	public Bicycle[] getBikes() {
		Bicycle[] newBikes = new Bicycle[bicycle.length];
		for(int i=0; i<bicycle.length; i++) {
			newBikes[i]=bicycle[i];
		}
		return newBikes;
	}
}