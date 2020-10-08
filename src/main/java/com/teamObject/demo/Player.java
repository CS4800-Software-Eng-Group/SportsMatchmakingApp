package com.teamObject.demo;

public class Player {
	
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
	private int age;
	
	/**
	 * ZIP code where the Player is located
	 */
	private int zipCode;
	
	/**
	 * @return the Player's unique ID
	 */
	public int getpID() {
		return pID;
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
	public int getAge() {
		return age;
	}

	/**
	 * @param age the Player's age to be set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the zipCode
	 */
	public int getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the Player's zipCode to be set
	 */
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Player [pID=" + pID + ", fName=" + fName + ", sport=" + sport + ", age=" + age + ", zipCode=" + zipCode
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (pID != other.pID)
			return false;
		return true;
	}
	
}
