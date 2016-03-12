// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc.team2830.subsystems;

import org.usfirst.frc.team2830.RobotMap;
import org.usfirst.frc.team2830.commands.*;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class Elevator extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final CANTalon elevatorTalon1 = RobotMap.elevatorElevatorTalon1;
    private final CANTalon elevatorTalon2 = RobotMap.elevatorElevatorTalon2;
    private final SpeedController elevatorWinchController1 = RobotMap.elevatorElevatorWinchController1;
    private final SpeedController elevatorWinchController2 = RobotMap.elevatorElevatorWinchController2;
    private final DoubleSolenoid elevatorWinchSolenoid = RobotMap.elevatorElevatorWinchSolenoid;
    private final DigitalInput elevatorUpDownLock = RobotMap.elevatorElevatorUpDownLock;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    Counter elevatorUpDownCounter;
    Double winchDeadBandTop = 0.1;
	Double winchDeadBandBottom = -0.1;
	private boolean driverPermission = false;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    	elevatorUpDownCounter = new Counter(elevatorUpDownLock);
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    public void elevatorUp(){
    	this.runElevator(1);
    	
    }
    public void elevatorDown(){
    	this.runElevator(-1);
    	
    }
	public void elevatorstop() {
	
    	
		
	}
	public void elevatorScale(){
		
	}
	public void lockWinch(){
		elevatorWinchSolenoid.set((Value.kReverse));
	}
	public void unlockWinch(){
		elevatorWinchSolenoid.set((Value.kForward));
		
	}
	public void winchOut(){
		this.runWinch(1);
		
		
	}
	public void winchIn(){
		this.runWinch(-1);
		
	}
	public void winchStop(){
		elevatorWinchController1.set(0);
		elevatorWinchController2.set(0);
		this.lockWinch();
		
		
	}
	int i = 0;
	
	public void runWinch(double winchSpeed){
		SmartDashboard.putNumber("Winch Iterator", ++i);
		if(winchDeadBandTop < winchSpeed && winchSpeed > winchDeadBandBottom  ){
			this.unlockWinch();
		}
			elevatorWinchController1.set(winchSpeed);
			elevatorWinchController2.set(winchSpeed);
			SmartDashboard.putBoolean("Winch DB", false);
		
//		}else {
//			this.winchStop();
//			SmartDashboard.putBoolean("Winch DB", true);
//		}
	
	}
	public void elevatorLow(){
		
	}
	public void runElevator(double elevatorSpeed){
		//if (this.elevatorUpDownCounter.get() == 0){
		elevatorTalon1.set(elevatorSpeed * -1);
		elevatorTalon2.set(elevatorSpeed);
		//}
	}
	public boolean isDriverPermission() {
		return driverPermission;
	}
	public void setDriverPermission(boolean driverPermission) {
		this.driverPermission = driverPermission;
	}
	public DigitalInput getElevatorUpDownLock() {
		return elevatorUpDownLock;
	}
	
}
