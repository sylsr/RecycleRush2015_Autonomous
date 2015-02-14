package org.usfirst.frc.team1891.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveAlign extends InfraredSlave
{
	int currentLeftAverage=super.averageLeft();
	int currentRightAverage=super.averageRight();
	int toleranceSet=(currentLeftAverage-currentRightAverage);
	public int driveAlign()
	{
		if(super.averageLeft()>1000)
		{
			if(super.averageRight()>1000)
			{
				return 1;
			}
		}
		else if(toleranceSet<=100 || toleranceSet>=-100)
		{
			return 0;
		}
		return toleranceSet;
	}
	/**
	 * startDash() sends all IR sensor data to the smartdashbaord
	 * @return
	 */
	/**
	 * startTestDash() gets the raw data from the IR sensors
	 * @return
	 */
	public void startDash()
	{
		SmartDashboard.putNumber("Average IR Left", super.averageLeft());
		SmartDashboard.putNumber("Average IR Right", super.averageRight());
        SmartDashboard.putNumber("Infrared Long Right",super.longDataRight());
        SmartDashboard.putNumber("Infrared Long Left", super.longDataLeft());
        super.startSideDashIR();
	}
	/**
	 * Center robot onto box for lifting mech to work
	 */
	public int centerRobot()
	{
		int rightSide=super.sideIRDataRight();
		int leftSide=super.sideIRDataLeft();
		int toleranceSet=(rightSide-leftSide);
		if(toleranceSet>125)
		{
			return 0;
		}
		else if(toleranceSet<-125)
		{
			return 1;
		}
		else
			return 2;
	}
}

