
package com.spikes2212.falafel2016;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import com.spikes2212.falafel2016.commands.MoveAndDiscontainFloopyAuto;
import com.spikes2212.falafel2016.commands.ScoreFloopy;
import com.spikes2212.falafel2016.subsystems.Crane;
import com.spikes2212.falafel2016.subsystems.Drivetrain;
import com.spikes2212.falafel2016.subsystems.Locker;


public class Robot extends IterativeRobot {

	public static OI oi;
	public static Drivetrain drivetrain;
	public static Crane crane;
	public static Locker locker;

	@Override
	public void robotInit() {
		

		oi = new OI();
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void autonomousInit() {
		MoveAndDiscontainFloopyAuto ai=new MoveAndDiscontainFloopyAuto(drivetrain);
	}

	@Override
	public void autonomousPeriodic() {
		
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
