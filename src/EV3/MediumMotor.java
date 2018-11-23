package EV3;

import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.Port;
import lejos.utility.Delay;

public class MediumMotor {
	EV3MediumRegulatedMotor motor;

	/**
	 * @param port - The motor's port.
	 */
	public MediumMotor(Port port) {
		motor = new EV3MediumRegulatedMotor(port);
	}
	
	/**
	 * @param speed
	 * @param rotations
	 * @param brakeAtEnd
	 */
	public void onForRotations(int speed, int rotations, boolean brakeAtEnd) {

		// Set motor speed in degrees/second
		motor.setSpeed(speed);
		motor.forward();	// Starts rotation.

		// Wait:
		Delay.msDelay(((rotations*360)/speed)*1000);

		// Break at end?
		if(brakeAtEnd) {
			motor.stop();
		}

	}

	/**
	 * @param speed
	 * @param degrees
	 * @param brakeAtEnd
	 */
	public void onForDegrees(int speed, int degrees, boolean brakeAtEnd) {

		// Set motor speed in degrees/second
		motor.setSpeed(speed);
		motor.forward();	// Starts rotation.

		// Wait:
		Delay.msDelay((degrees/speed)*1000);

		// Break at end?
		if(brakeAtEnd) {
			motor.stop();
		}

	}
	
	/**
	 * @param speed
	 * @param seconds
	 * @param brakeAtEnd
	 */
	public void onForSeconds(int speed, int seconds, boolean brakeAtEnd) {

		// Set motor speed in degrees/second
		motor.setSpeed(speed);
		motor.forward();	// Starts rotation.

		// Wait:
		Delay.msDelay(seconds*1000);

		// Break at end?
		if(brakeAtEnd) {
			motor.stop();
		}

	}
	
	/**
	 * Immediately returns. 
	 * @param speed
	 */
	public void on(int speed) {
		
		// Set motor speed in degrees/second
		motor.setSpeed(speed);
		
		if(speed >= 0)
			motor.forward();	// Starts rotation.
		else
			motor.backward();
		
		
	}
	
	/**
	 * Stops the motor.
	 */
	public void off() {
		
		// Stop motor.
		motor.stop();
		
	}

	/**
	 * Use when the motor is no longer needed.
	 */
	public void close() {
		motor.close();
	}

	/**
	 * @return - The motor's current speed (degrees per second).
	 */
	public double getSpeed() {
		return motor.getSpeed();
	}

}
