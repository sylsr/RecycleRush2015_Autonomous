
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
	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	LimitSwitch liftStop;
	DriveAlign boxAlign;
	JagMaster controlJag;
    Command autonomousCommand;
    Lift jagLift;
    boolean isLifting=false;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit()
    {
    	testServo = new ServoMaster();
		oi = new OI();
        // instantiate the command used for the autonomous period
        autonomousCommand = new ExampleCommand();
        liftStop = new LimitSwitch();
        boxAlign= new DriveAlign();
        controlJag=new JagMaster();
        jagLift= new Lift();
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
    	boxAlign.startDash();
        Scheduler.getInstance().run();
        jagLift.startLiftDash();
        jagLift.Init();
        /*switch(boxAlign.driveAlign())
        {
        	case 0:
        		if(!isLifting)
        		{
        			controlJag.moveForward();
        		}
        		break;
        	case 1:
        	     switch(boxAlign.centerRobot())
        	     {
        		      case 0:
        		    	  if(!isLifting)
        	        		{
        		    		  controlJag.horizontalLeft();
        	        		}
	        		      break;
        		      case 1:
        		    	  if(!isLifting)
        	        		{
        		    		  controlJag.horizontalRight();
        	        		}
	        		      break;
        		      default:
        		    	  jagLift.lift();
	        		      controlJag.stop();
	        		      isLifting=false;
	        		      break;
        	      }
        	        
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
