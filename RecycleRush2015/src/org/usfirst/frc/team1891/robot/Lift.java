package org.usfirst.frc.team1891.robot;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Lift
{
	double plo;
	double pup = plo + 4.732;
	int hitBottomLimit=0;
	CANJaguar jagLift;
	public Lift()
	{
		jagLift = new CANJaguar(5);
	}
	public double Init()
	{
		if (jagLift.getReverseLimitOK() != false && hitBottomLimit==0)
		{
			jagLift.enableControl();
			jagLift.set(-1);
			hitBottomLimit++;
		}
		else
		{
		jagLift.setPositionMode(CANJaguar.kQuadEncoder, 1000, plo, 0.5, 0.5);
		jagLift.getPosition();
		}
		
		
		return Math.abs(plo);
			
	}
	public void lift()
	{
		jagLift.set(0.5);
	}
	public void lower()
	{
		if (jagLift.getReverseLimitOK() == false)
		{
			jagLift.set(25);
		}
		else 
			jagLift.set(-25);
	}
	public void startLiftDash()
	{
		SmartDashboard.putBoolean("LimitSwitch", jagLift.getReverseLimitOK());
	}
}
