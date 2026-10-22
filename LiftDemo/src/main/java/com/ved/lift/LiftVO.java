package com.ved.lift;

import java.util.List;

public class LiftVO {
	/**
	 * LiftVO class represents the state of a lift (elevator) in a building.
	 * It contains information about the current floor, direction, maximum capacity, maximum weight, current weight, current person  and other relevant details.
	 */
		
	private int currentFloor; // Current floor of the lift
	private String direction; // Direction of the lift (up, down, hold and stop)
	private int maxCapacity; // Maximum capacity of the lift (number of people)
	private int maxWeight; // Maximum weight limit of the lift (in kilograms)
	private int currentWeight; // Current weight in the lift (in kilograms)
	private int currentPerson; // Current number of people in the lift
	private List<Integer> listOfFloors; // List of floors the lift can access
	private int highestFloor; // Highest floor the lift can access
	private int lowestFloor; // Lowest floor the lift can access
	
	public int getCurrentFloor() {
		return currentFloor;
	}
	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public int getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	public int getMaxWeight() {
		return maxWeight;
	}
	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}
	public int getCurrentWeight() {
		return currentWeight;
	}
	public void setCurrentWeight(int currentWeight) {
		this.currentWeight = currentWeight;
	}
	public int getCurrentPerson() {
		return currentPerson;
	}
	public void setCurrentPerson(int currentPerson) {
		this.currentPerson = currentPerson;
	}
	public List<Integer> getListOfFloors() {
		return listOfFloors;
	}
	public void setListOfFloors(List<Integer> listOfFloors) {
		this.listOfFloors = listOfFloors;
	}
	
	
	
	public int getHighestFloor() {
		return highestFloor;
	}
	public void setHighestFloor(int highestFloor) {
		this.highestFloor = highestFloor;
	}
	public int getLowestFloor() {
		return lowestFloor;
	}
	public void setLowestFloor(int lowestFloor) {
		this.lowestFloor = lowestFloor;
	}
	public LiftVO(int currentFloor, String direction, int maxCapacity, int maxWeight, int currentWeight,
			int currentPerson, List<Integer> listOfFloors, int highestFloor, int lowestFloor) {
		super();
		this.currentFloor = currentFloor;
		this.direction = direction;
		this.maxCapacity = maxCapacity;
		this.maxWeight = maxWeight;
		this.currentWeight = currentWeight;
		this.currentPerson = currentPerson;
		this.listOfFloors = listOfFloors;
		this.highestFloor = highestFloor;
		this.lowestFloor = lowestFloor;
				
	}
	public LiftVO() {
		super();
	}

	
	
}
