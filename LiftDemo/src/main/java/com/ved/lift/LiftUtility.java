package com.ved.lift;

public class LiftUtility {
	
	public static void printLiftStatus(LiftVO liftVO) {
		System.out.println("Current Floor: " + liftVO.getCurrentFloor());
		System.out.println("Direction: " + liftVO.getDirection());
		System.out.println("Max Capacity: " + liftVO.getMaxCapacity());
		System.out.println("Max Weight: " + liftVO.getMaxWeight());
		System.out.println("Current Weight: " + liftVO.getCurrentWeight());
		System.out.println("Current Person: " + liftVO.getCurrentPerson());
		System.out.println("List of Floors: " + liftVO.getListOfFloors());
		System.out.println("Highest Floor: " + liftVO.getHighestFloor());
		System.out.println("Lowest Floor: " + liftVO.getLowestFloor());
	}
	
	public static void printLiftThreadStatus(LiftThread liftThread) {
		System.out.println("Lift Thread is Running: " + liftThread.isRunning());
		printLiftStatus(liftThread.getLiftVO());
	}
	
	/*
	 * based on the current floor and target floor, we can determine the direction of the lift
	 */
	public static String determineDirection(int currentFloor, int targetFloor) {
		if (currentFloor < targetFloor) {
			return "up";
		} else if (currentFloor > targetFloor) {
			return "down";
		} else {
			return "hold"; // If the current floor is the same as the target floor, the lift should hold
		}
	}
	
	public static boolean checkRunningDirection(int currentFloor, String direction, LiftVO liftVO) {
		
		if ((direction.equals("up") && liftVO.getCurrentFloor() <= currentFloor ) ||
				(direction.equals("down") && liftVO.getCurrentFloor() >= currentFloor))
				return true; // Return true if the lift can be selected based on the direction and current floor
		
		return false; // Return false if the lift cannot be selected based on the direction and current floor
	}	
	
	//check if any stopped lift is available to be selected based on the current floor and direction
	public static boolean isStoppedLift(int currentFloor, String direction, LiftVO liftVO) {
		if (liftVO.getDirection().equals("stop")) {
			return true; // Return true if the lift is stopped and can be selected
		}
		
		return false; // Return false if the lift is not stopped and cannot be selected
	}
	
	//check either lift is able to carry the person or not based on the current weight and capacity of the lift
	public static boolean isLiftAbleToCarryPerson(LiftVO liftVO, int personWeight) {
		if(liftVO.getMaxCapacity() <= liftVO.getCurrentPerson()) {
			return false; // Return false if the lift is at max capacity
		}
		
		if(liftVO.getMaxWeight() <= (liftVO.getCurrentWeight() + personWeight)) {
			return false; // Return false if the lift is at max weight
		}
		
		return true; // Return true if the lift can carry the person
	}	
	
	//check either destiation floor is valid or not based on the list of floors the lift can access
	public static boolean isDestinationFloorValid(LiftVO liftVO, int targetFloor) {
		if(liftVO.getListOfFloors().contains(targetFloor)) {
			return true; // Return true if the target floor is valid
		}
		
		return false; // Return false if the target floor is not valid
	}
	

}
