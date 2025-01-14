/**
 * 
 */
package edu.ilstu;

/**
 * This is Bicycle class store all element of Bicycle array object and return if requested
 * @author suphasit sribuaai
 *
 */
public class Bicycle {
  private String type;
  private int wheelSize;
  private String assembled;
  private char gender;
  
  /**
	 * Constructor
	 * 
	 * @param type - type of bike
	 * @param wheelSize - bicycle wheel size
	 * @param assembled - if the bike came assembled or not
	 * @param gender - which gender does the bike made for
	 */
  public Bicycle(String type, int wheelSize, boolean assembled, char gender) {
	  this.type = type;
	  this.wheelSize = wheelSize;
	  this.assembled = Boolean.toString(assembled);
	  this.gender = gender;
  }
  /**
	 * default Constructor
	 * 
	 * @param bike
	 */
  public Bicycle(Bicycle[] bike) { // accepts bicycle object
	  
  }
  /**
	 * toString method return the value of String 
	 * 
	 * @return type, wheelSize, assembled, and gender in String
	 */
  public String toString() {
	  String value;
	  
	  if(this.gender == 'm');
	  	String spelledOut = "Male";
	  if(this.gender == 'f'); 
	  	spelledOut = "Female";
	  	
	  value = "Type: "+this.type+" Wheel Size: "+this.wheelSize+" Assembled: "+this.assembled+" Gender: "+spelledOut;
	  return value;
  }
  /**
	 * getter method to get bike type
	 * 
	 * @return type
	 */
  public String getType() {
	  return type;
  }
  /**
	 * getter method to get wheel size
	 * 
	 * @return wheelSize
	 */
  public int getWheelSize() {
	  return wheelSize;
  }
  /**
	 * getter method to get assembled
	 * 
	 * @return assembled
	 */
  public String getAssembled() {
	  return assembled;
  }
  /**
	 * getter method to get gender
	 * 
	 * @return gender
	 */
  public char getGender() {
	  return gender;
  }

}
