package org.usfirst.frc.team1891.robot;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Lift extends CANJaguar
{
	public Lift(int ID) 
	{
		super(ID);
	
	}
	public  void lift()
	{
		SmartDashboard.putNumber("Lift Position", getPosition());
		if (getForwardLimitOK() == false)
		{
			set(5);
		}
		else
			set(0);
	}
	public void lower()
	{
		if (getReverseLimitOK() == false)
		{
			set(5);
		}
		else 
			set(0);
	}
}
