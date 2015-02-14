package org.usfirst.frc.team1891.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;

public class LimitSwitch
{
	DigitalInput liftStopIn = new DigitalInput(2);
	public boolean limitInput()
	{
		return liftStopIn.get();
	}
}
