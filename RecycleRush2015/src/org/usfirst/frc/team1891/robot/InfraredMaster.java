package org.usfirst.frc.team1891.robot;

import edu.wpi.first.wpilibj.AnalogInput;

public class InfraredMaster
{
	AnalogInput infraredLeft;
	AnalogInput infraredRight;
	AnalogInput infraredLongLeft;
	AnalogInput infraredLongRight;
	public InfraredMaster()
	{
		infraredLeft =new AnalogInput(0);
		infraredRight = new AnalogInput(1);
		infraredLongLeft= new AnalogInput(2);
		infraredLongRight= new AnalogInput(3);
	}
	/**
	 * getDistanceLeft() returns the resistance of the left IR sensor
	 * @return
	 */
	public int getDistanceLeft()
	{
		return infraredLeft.getValue();
	}
	/**
	 * getDistanceRight() returns the resistance of the right IR sensor
	 * @return
	 */
	public int getDistanceRight()
	{
		return infraredRight.getValue();
	}
	
}