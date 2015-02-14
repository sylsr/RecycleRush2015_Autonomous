package org.usfirst.frc.team1891.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class InfraredSlave
{
	InfraredMaster IRMaster;
	public InfraredSlave()
	{
		IRMaster = new InfraredMaster();
	}
	AverageInfraredData averageInfraredLeft = new AverageInfraredData();
	AverageInfraredData2 averageInfraredRight = new AverageInfraredData2();
	/**
	 * averageLeft() puts the LinkedList data in, averages it and then returns the average of 10 integers
	 * @return
	 */
	public int averageLeft()
	{
		averageInfraredLeft.add(IRMaster.getDistanceLeft());
		return averageInfraredLeft.getAverage();
	}
	/**
	 *  averageRight() puts the LinkedList data in, averages it and then returns the average of 10 integers
	 * @return
	 */
	public int averageRight()
	{
		averageInfraredRight.add(IRMaster.getDistanceRight());
		return averageInfraredRight.getAverage();
	}
	/**
	 * longDataRight() gets the data of the long IR sensor on the right
	 * @return
	 */
	public int longDataRight()
	{
		return IRMaster.getDistanceRight();
	}
	/**
	 * longDataLeft() gets the data of the long IR sensor on the left
	 * @return
	 */
	public int longDataLeft()
	{
		return IRMaster.getDistanceLeft();
	}
	public int sideIRDataRight()
	{
		return IRMaster.getSideRightDistance();
	}
	public int sideIRDataLeft()
	{
		return IRMaster.getSideLeftDistance();
	}
	public void startSideDashIR()
	{
		SmartDashboard.putNumber("Right side", IRMaster.getSideRightDistance());
		SmartDashboard.putNumber("Left side", IRMaster.getSideLeftDistance());
	}
	
	
}