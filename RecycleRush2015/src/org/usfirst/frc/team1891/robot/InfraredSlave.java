package org.usfirst.frc.team1891.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class InfraredSlave 
{
	InfraredMaster IRMaster = new InfraredMaster();
	AverageInfraredData averageInfraredLeft = new AverageInfraredData();
	AverageInfraredData2 averageInfraredRight = new AverageInfraredData2();
	int toleranceSet=(IRMaster.getDistanceLeft()-IRMaster.getDistanceRight());
	public void startTestDash()
	{
		SmartDashboard.putNumber("Put Left", IRMaster.getDistanceLeft());
		SmartDashboard.putNumber("Put Right", IRMaster.getDistanceRight());
	}
	public int averageLeft()
	{
		averageInfraredLeft.add(IRMaster.getDistanceLeft());
		return averageInfraredLeft.getAverage();
	}
	public int averageRight()
	{
		averageInfraredRight.add(IRMaster.getDistanceRight());
		return averageInfraredRight.getAverage();
	}
	public int driveAlign()
	{
		if(IRMaster.getDistanceLeft()>1000)
		{
			if(IRMaster.getDistanceRight()>1000)
			{
				return 3;
			}
		}
		else if(toleranceSet<=100 || toleranceSet>=-100)
		{
			return 0;
		}
		else if (toleranceSet>100)
		{
			return 1;
		}
		else if(toleranceSet<-100)
		{
			return 2;
		}
		return toleranceSet;
	}
	public int longDataRight()
	{
		return IRMaster.getDistanceRight();
	}
	public int longDataLeft()
	{
		return IRMaster.getDistanceLeft();
	}
	
	
}