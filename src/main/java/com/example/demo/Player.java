package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Player {

	@Id
	/**
	 * Player's unique ID	
	 */
	private int pID;

	/**
	 * Player's first name
	 */
	private String fName;

	/**
	 * Sport that the Player wants to play
	 */
	private String sport; //Will be changed to a Sport Object

	/**
	 * Player's years of age
	 */
	//private int age;

	/**
	 * ZIP code where the Player is located
	 */
	private String zipCode;
	
	
	
	/**
	 * @return the Player's unique ID
	 */
	public int getpID() {
		return pID;
	}

	public Player() {
		super();
		this.pID = 100;
		this.fName = "FirstName";
		this.sport = "Sport";
	}
	
	/**
	 * 
	 * 
	 * @param pID
	 * @param fName
	 * @param sport
	 */
	public Player(int pID, String fName, String sport, String zip) {
		super();
		this.pID = pID;
		this.fName = fName;
		this.sport = sport;
		this.zipCode = zip;
	}

	/**
	 * @param pID the Player's unique ID to be set
	 */
	public void setpID(int pID) {
		this.pID = pID;
	}

	/**
	 * @return the Player's first name
	 */
	public String getfName() {
		return fName;
	}

	/**
	 * @param fName the Player's first name to be set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}

	/**
	 * @return the Player's sport
	 */
	public String getSport() {
		return sport;
	}

	/**
	 * @param sport the Player's sport to be set
	 */
	public void setSport(String sport) {
		this.sport = sport;
	}

	/**
	 * @return the Player's age
	 */
	/*public int getAge() {
		return age;
	}*/

	/**
	 * @param age the Player's age to be set
	 */
	/*public void setAge(int age) {
		this.age = age;
	}*/

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}
	
	/**
	 * @param zipCode the Player's zipCode to be set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Player [pID=" + pID + ", fName=" + fName + ", sport=" + sport + "]";
	}

}