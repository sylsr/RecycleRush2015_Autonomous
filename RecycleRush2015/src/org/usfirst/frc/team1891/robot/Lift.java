package org.usfirst.frc.team1891.robot;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Lift
{
	double plo;
	double pup = plo + 4.732;
	CANJaguar jagLift;
	public Lift()
	{
		jagLift = new CANJaguar(5);
	}
	public double Init()
	{
		if (jagLift.getForwardLimitOK() != false)
		{
			jagLift.enableControl();
			jagLift.set(25);
		}
		else
		{
		jagLift.setPositionMode(CANJaguar.kQuadEncoder, 1000, plo, 0.5, 0.5);
		jagLift.getP();
		}
		
		
		return Math.abs(plo);
			
	}
	public void lift()
	{
	
		
		if (jagLift.getForwardLimitOK() == false)
		{
			jagLift.set(-25);
		}
		else
			jagLift.set(25);
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
}
