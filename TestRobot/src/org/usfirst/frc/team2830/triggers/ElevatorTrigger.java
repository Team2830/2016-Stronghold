package org.usfirst.frc.team2830.triggers;

import org.usfirst.frc.team2830.Robot;

import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ElevatorTrigger extends Trigger {

	int i = 0;
	
	@Override
	public boolean get() {
		// TODO Auto-generated method stub
		if(Robot.oi == null)
		{
			//SmartDashboard.putBoolean("Winch Trigger Case", false);
			return false;
		}
		else
		{
			SmartDashboard.putBoolean("Elevator Trigger Case", true);
			//SmartDashboard.putNumber("stick", Robot.oi.getOperatorGamepad().getRawAxis(3));
			return (Robot.oi.getOperatorGamepad().getRawAxis(1) > 0.1 
					|| Robot.oi.getOperatorGamepad().getRawAxis(1) < -0.1);
		}
	
	}

}
