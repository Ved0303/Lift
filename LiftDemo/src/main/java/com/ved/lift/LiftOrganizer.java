package com.ved.lift;

import java.util.ArrayList;
import java.util.List;

public class LiftOrganizer {
	
	/**
	 * LiftOrganizer class is responsible for managing the state of a lift (elevator) in a building.
	 * It contains methods to organize the lift's operations, such as moving between floors, handling capacity and weight limits, and managing the list of accessible floors.
	 */
	
	int numberOfLifts; // Number of lifts in the building
	int numberOfFloors; // Number of floors in the building
	int standardPersonWeight = 70; // Standard weight of a person in kilograms
	List <LiftThread> lifts; // List of LiftThread objects representing the state of each lift
	
	public LiftOrganizer(int numberOfLifts, int numberOfFloors, List<LiftThread> lifts) {
		this.numberOfLifts = numberOfLifts; // Set the number of lifts in the building
		this.numberOfFloors = numberOfFloors; // Set the number of floors in the building
		this.lifts = lifts; // Set the list of LiftThread objects representing the state of each lift
	}
	
	public LiftOrganizer() {
		this.numberOfLifts = 0; // Set the number of lifts in the building
		this.numberOfFloors = 0; // Set the number of floors in the building
		this.lifts = new ArrayList<>(); // Set the list of LiftThread objects representing the state of each lift
	}
	
	
	
	public int getNumberOfLifts() {
		return numberOfLifts;
	}




	public void setNumberOfLifts(int numberOfLifts) {
		this.numberOfLifts = numberOfLifts;
	}




	public int getNumberOfFloors() {
		return numberOfFloors;
	}




	public void setNumberOfFloors(int numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}




	public List<LiftThread> getLifts() {
		return lifts;
	}




	public void setLifts(List<LiftThread> lifts) {
		this.lifts = lifts;
	}


	//Add new lift to the list of lifts
	public void addLift(LiftThread lift) {
		this.lifts.add(lift); // Add a new LiftThread object to the list of lifts
	}


	public void moveLift(int liftNumber, int targetFloor) {
		// Implement the logic to move the lift to the target floor
	}
	


	public void callLift(int currentFloor, int targetFloor) {
		// Implement the logic to call the lift to the target floor
		
		//Determine the direction of the lift based on the current floor and target floor
		String direction = LiftUtility.determineDirection(currentFloor, targetFloor);
		
		//Find the nearest lift to the current floor
		LiftThread nearestLift = findNearestLift(currentFloor, direction, targetFloor);
		
		if (nearestLift != null) {
			// Move the nearest lift to the target floor
			nearestLift.setDirection(direction); // Set the direction of the nearest lift
			nearestLift.startLift(); // Start the nearest lift
		} else {
			System.out.println("No available lifts to service the request at floor " + currentFloor);
		}
		
		
		
	}

	private LiftThread findNearestLift(int currentFloor, String direction, int targetFloor) {

		for (LiftThread lift : lifts) {
			LiftVO liftVO = lift.getLiftVO();
			
			if(LiftUtility.isDestinationFloorValid(liftVO, currentFloor) == false) {
				continue; // Skip the lift if the current floor is not valid for the lift
			}
			
			if(LiftUtility.isDestinationFloorValid(liftVO, targetFloor) == false) {
				continue; // Skip the lift if the targetFloor floor is not valid for the lift
			}
			
			if(LiftUtility.isLiftAbleToCarryPerson(liftVO, standardPersonWeight) == false) {
				continue; // Skip the lift if it cannot carry a person
			}
			
			if (liftVO.getCurrentFloor() == currentFloor) {
				return lift; // Return the lift if it is already at the current floor
			}
			
			if (LiftUtility.checkRunningDirection(currentFloor, direction, liftVO)) {
				return lift; // Return the lift if it is moving in the same direction as the requested direction
			}
			
			if (LiftUtility.isStoppedLift(currentFloor, direction, liftVO)) {
				return lift; // Return the lift if it is stopped and can be selected
			}
		}

		return null;
	}



}
