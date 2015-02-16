package org.usfirst.frc.team1891.robot;

import edu.wpi.first.wpilibj.CANJaguar;

public class JagMaster 
{
	CANJaguar jagRightBack;
	CANJaguar jagLeftFront;
	CANJaguar jagLeftBack;
	CANJaguar jagRightFront;
	public JagMaster()
	{
		jagRightBack= new CANJaguar(2);
        jagRightFront= new CANJaguar(6);
        jagLeftBack= new CANJaguar(3);
        jagLeftFront= new CANJaguar(4);
	}
	/**
	 * Move the robot forward if the sensors at the back are not getting to much resistance
	 */
	public void moveForward()
	{
		jagRightBack.set(-0.1);
		jagRightFront.set(-0.1);
		jagLeftBack.set(0.1);
		jagLeftFront.set(0.1);
	}
	public void moveSlightlyRight()
	{
		jagRightBack.set(-0.15);
		jagRightFront.set(-0.15);
		jagLeftBack.set(0.1);
		jagLeftFront.set(0.1);
	}
	public void moveSlightlyLeft()
	{
		jagRightBack.set(-0.1);
		jagRightFront.set(-0.1);
		jagLeftBack.set(0.15);
		jagLeftFront.set(0.15);
	}
	public void stop()
	{
		jagRightBack.set(0.0);
		jagRightFront.set(0.0);
		jagLeftBack.set(-0.0);
		jagLeftFront.set(-0.0);
	}
	public void horizontalRight()
	{
		jagRightBack.set(-0.2);
		jagRightFront.set(0.2);
		jagLeftBack.set(-0.2);
		jagLeftFront.set(0.2);
	}
	public void horizontalLeft()
	{
		jagRightBack.set(0.2);
		jagRightFront.set(-0.2);
		jagLeftBack.set(0.2);
		jagLeftFront.set(-0.2);
	}
}
