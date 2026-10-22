package com.ved.lift;

public class LiftThread extends Thread {
	/*
	 * 	* LiftThread class is responsible for managing the lift's operations in a separate thread.
	 * 	* It allows the lift to operate concurrently with other processes, enabling smooth and efficient handling of lift requests.
	 * 	* The class contains methods to start, stop, and manage the lift's thread, ensuring that the lift operates safely and efficiently.
	 */
	
	private boolean isRunning; // Flag to indicate if the lift thread is running
	private LiftVO liftVO; // LiftVO object representing the state of the lift
	
	public LiftThread() {
		this.isRunning = false; // Initially, the lift thread is not running
	}
	
	public void startLift() {
		this.isRunning = true; // Set the running flag to true to start the lift thread
		this.start(); // Start the thread
	}
	
	public void stopLift() {
		this.isRunning = false; // Set the running flag to false to stop the lift thread
		this.liftVO.setDirection("stop"); // Set the lift's direction to "stop" when reached destination
	}
	
	public void pauseLift() {
		this.isRunning = false; // Set the running flag to false to pause the lift thread
		this.liftVO.setDirection("hold"); // Set the lift's direction to "hold" when paused
	}
	
	public boolean isRunning() {
		return isRunning; // Return the current state of the lift thread
	}
	
	public void setDirection(String direction) {
		this.isRunning = true; // Set the running flag to the specified value
		this.liftVO.setDirection(direction); // Set the lift's direction to the specified value
	}
	
	public LiftVO getLiftVO() {
		return liftVO; // Return the LiftVO object representing the state of the lift
	}
	
	public void setLiftVO(LiftVO liftVO) {
		this.liftVO = liftVO; // Set the LiftVO object representing the state of the lift
	}
	
	
	public void run() {
		runLift(); // Call the runLift method to manage the lift's operations
	}	
	
	public void runLift() {
		while (true) {
			// Implement the logic to manage the lift's operations
			// This could include moving between floors, handling capacity and weight limits, etc.
			
			/*
			 * Example logic:
			 * 1. Check the current floor and direction of the lift.
			 * 2. Move the lift to the next floor based on the direction.
			 * 3. Check if there are any requests for the current floor.
			 * 4. Handle capacity and weight limits.
			 * 5. Update the LiftVO object with the new state of the lift.
			 */
			
			if(liftVO != null && isRunning) {
				// Example: Move the lift to the next floor based on the direction
				if("up".equalsIgnoreCase(liftVO.getDirection()) && liftVO.getCurrentFloor() < liftVO.getHighestFloor()) {
					liftVO.setCurrentFloor(liftVO.getCurrentFloor() + 1);
				} else if("down".equalsIgnoreCase(liftVO.getDirection()) && liftVO.getCurrentFloor() > liftVO.getLowestFloor()) {
					liftVO.setCurrentFloor(liftVO.getCurrentFloor() - 1);
				}
				
				// Additional logic to handle requests, capacity, and weight limits can be added here
			}
			
			/*
			 * Logic to pause the thread for a short duration 
			 * to simulate the time taken for the lift to move between floors can be added here.
			 */
			
			try {	
				Thread.sleep(1000); // Pause for 1 second to simulate lift movement
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt(); // Restore interrupted status
			}
			
		}
	}	
	
	
	
	
}
