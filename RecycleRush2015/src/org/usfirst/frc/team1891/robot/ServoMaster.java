package org.usfirst.frc.team1891.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Servo;

public class ServoMaster
{
	Joystick joy1 = new Joystick(0);
	Servo leftServo=new Servo(0);
	Servo rightServo=new Servo(1);
	public void setLeftServo()
	{
		if(joy1.getX()>0.0)
		{
			leftServo.set(45);
		}
		else if(joy1.getX()<0.0) 
		{
			leftServo.set(-45);
		}
	}
}
