
package org.usfirst.frc.team1891.robot;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1891.robot.commands.ExampleCommand;
import org.usfirst.frc.team1891.robot.subsystems.ExampleSubsystem;


public class Robot extends IterativeRobot
{
	ServoMaster testServo;
	InfraredSlave IRSlave;
	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	CANJaguar jagRightBack;
	CANJaguar jagLeftFront;
	CANJaguar jagLeftBack;
	CANJaguar jagRightFront;
	CANJaguar jagLift;
	LimitSwitch liftStop;
    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit()
    {
    	testServo = new ServoMaster();
    	IRSlave = new InfraredSlave();
		oi = new OI();
        // instantiate the command used for the autonomous period
        autonomousCommand = new ExampleCommand();
        jagRightBack= new CANJaguar(2);
        jagRightFront= new CANJaguar(6);
        jagLeftBack= new CANJaguar(3);
        jagLeftFront= new CANJaguar(4);
        jagLift=new CANJaguar(5);
        liftStop = new LimitSwitch();
    }
	
	public void disabledPeriodic() 
	{
		Scheduler.getInstance().run();
	}

    public void autonomousInit()
    {
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic()
    {
    	SmartDashboard.putNumber("Infrared Right",IRSlave.averageRight());
        SmartDashboard.putNumber("Infrared Left", IRSlave.averageLeft());
        //SmartDashboard.putNumber("Infrared Long Right",IRSlave.longDataRight());
        //SmartDashboard.putNumber("Infrared Long Left", IRSlave.longDataLeft());
        IRSlave.startTestDash();
        Scheduler.getInstance().run();
        SmartDashboard.putBoolean("Limit Test", jagLift.getForwardLimitOK()); //Top limit switch
        /*switch(IRSlave.driveAlign())
        {
        	case 0:
        		jagRightBack.set(-0.1);
        		jagRightFront.set(-0.1);
        		jagLeftBack.set(0.1);
        		jagLeftFront.set(0.1);
        		break;
        	case 1:
        		jagRightBack.set(-0.15);
        		jagRightFront.set(-0.15);
        		jagLeftBack.set(0.1);
        		jagLeftFront.set(0.1);
        		break;
        	case 2:
        		jagRightBack.set(-0.1);
        		jagRightFront.set(-0.1);
        		jagLeftBack.set(0.15);
        		jagLeftFront.set(0.15);
        		break;
        	case 3:
        		jagRightBack.set(0.0);
        		jagRightFront.set(0.0);
        		jagLeftBack.set(-0.0);
        		jagLeftFront.set(-0.0);
        		jagLift.set(1);
        		break;
        	default:
        		break;
        }*/

    }

    public void teleopInit() 
    {

        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit()
    {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic()
    {
        Scheduler.getInstance().run();
        testServo.setLeftServo();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() 
    {
        LiveWindow.run();
    }
}
