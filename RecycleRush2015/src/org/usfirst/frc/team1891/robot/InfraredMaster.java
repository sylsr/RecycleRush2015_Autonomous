package org.usfirst.frc.team1891.robot;

import edu.wpi.first.wpilibj.AnalogInput;

public class InfraredMaster
{
	AnalogInput infraredLeft =new AnalogInput(0);
	AnalogInput infraredRight = new AnalogInput(1);
	public int getDistanceLeft()
	{
		return infraredLeft.getValue();
	}
	public int getDistanceRight()
	{
		return infraredRight.getValue();
	}
	
}