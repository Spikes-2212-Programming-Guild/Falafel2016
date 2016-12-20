
package com.spikes2212.falafel2016;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.spikes2212.cameras.CamerasHandler;
import com.spikes2212.falafel2016.commands.MoveAndDiscontainFloopyAuto;
import com.spikes2212.falafel2016.subsystems.Brake;
import com.spikes2212.falafel2016.subsystems.Crane;
import com.spikes2212.falafel2016.subsystems.Drivetrain;
import com.spikes2212.falafel2016.subsystems.Locker;
import com.spikes2212.utils.DoubleSpeedcontroller;

public class Robot extends IterativeRobot {

	public static OI oi;
	public static Drivetrain drivetrain;
	public static Crane crane;
	public static Locker locker;
	public static SendableChooser chooser;
	public static Command autoCommand;
	public static CamerasHandler camerasHandler;

	@Override
	public void robotInit() {
		chooser = new SendableChooser();
		chooser.addDefault("MoveAndDiscontainFloopy", new MoveAndDiscontainFloopyAuto());
		SmartDashboard.putData("auto choose", chooser);
		drivetrain = new Drivetrain(
				new DoubleSpeedcontroller(new VictorSP(RobotMap.PWM.DRIVETRAIN_RIGHT_1),
						new VictorSP(RobotMap.PWM.DRIVETRAIN_RIGHT_2)),
				new DoubleSpeedcontroller(new VictorSP(RobotMap.PWM.DRIVETRAIN_LEFT_1),
						new VictorSP(RobotMap.PWM.DRIVETRAIN_LEFT_2)));
		Brake breaker = new Brake(new VictorSP(RobotMap.PWM.BREAK), new DigitalInput(RobotMap.DIO.BREAK_CLOSED),
				new DigitalInput(RobotMap.DIO.BREAK_CLOSED));
		crane = new Crane(
				new DoubleSpeedcontroller(new CANTalon(RobotMap.CAN.CRANE_1), new CANTalon(RobotMap.CAN.CRANE_2)), null,
				new DigitalInput(RobotMap.DIO.CRANE_UP), new DigitalInput(RobotMap.DIO.CRANE_DOWN), breaker);
		locker = new Locker(new VictorSP(RobotMap.PWM.LOCKER), new DigitalInput(RobotMap.DIO.LOCKER_OPEN),
				new DigitalInput(RobotMap.DIO.LOCKER_CLOSED));
		camerasHandler = new CamerasHandler(RobotMap.USB.CAMRA_FORWARD);

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
