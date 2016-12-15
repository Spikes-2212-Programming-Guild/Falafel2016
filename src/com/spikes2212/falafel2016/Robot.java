
package com.spikes2212.falafel2016;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.spikes2212.falafel2016.commands.MoveAndDiscontainFloopyAuto;
import com.spikes2212.falafel2016.subsystems.Crane;
import com.spikes2212.falafel2016.subsystems.Drivetrain;
import com.spikes2212.falafel2016.subsystems.Locker;

public class Robot extends IterativeRobot {

	public static OI oi;
	public static Drivetrain drivetrain;
	public static Crane crane;
	public static Locker locker;
	public static SendableChooser chooser;
	public static Command autoCommand;

	@Override
	public void robotInit() {
		chooser = new SendableChooser();
		chooser.addDefault("MoveAndDiscontainFloopy", new MoveAndDiscontainFloopyAuto(drivetrain, 7));
		SmartDashboard.putData("auto choose", chooser);

		oi = new OI();
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void autonomousInit() {
		autoCommand = (Command) chooser.getSelected();
		autoCommand.start();
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		autoCommand.cancel();
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
