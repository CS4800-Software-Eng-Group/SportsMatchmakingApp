package com.example.demo;


public class Sport {
	
	/**
	 * Name of sport
	 */
	private String name;
	/**
	 * Description of sport
	 */
	private String description;
	/**
	 * Competitiveness level of play
	 */
	private String competitivenessLevel;
	
	public Sport() {
		
		this.name = "sportName";
		this.description = "sportDescription";
		this.competitivenessLevel = "levelCompetitiveness";
	}
	
	/** 
	 * @param name
	 * @param description
	 * @param competitivenessLevel
	 */
	public Sport(String name, String description, String competitivenessLevel) {
		
		this.name = name;
		this.description = description;
		this.competitivenessLevel = competitivenessLevel;
	}
	
	/**
	 * @return the sport's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the sport's name to be set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the sport's description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @param description the sport's description to be set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @return the sport's competitiveness level
	 */
	public String getcompetitivenessLevel() {
		return competitivenessLevel;
	}
	
	/**
	 * @param competitivenessLevel the sport's competitiveness level to be set
	 */
	public void setcompetitivenessLevel(String competitivenessLevel) {
		this.competitivenessLevel = competitivenessLevel;
	}

	@Override
	public String toString() {
		return "Sport [name=" + name + ", description=" + description + ", competitivenessLevel=" + competitivenessLevel
				+ "]";
	}
}
