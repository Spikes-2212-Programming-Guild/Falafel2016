package com.spikes2212.falafel2016;

import com.spikes2212.falafel2016.commands.Fold;
import com.spikes2212.falafel2016.commands.MoveToLoadPosition;
import com.spikes2212.falafel2016.commands.ScoreFloopy;
import com.spikes2212.falafel2016.subsystems.Crane;
import com.spikes2212.falafel2016.subsystems.Locker;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;
import com.spikes2212.utils.XboXUID;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI /* GEVALD */ {

	// Joysticks
	private Joystick driverRight = new Joystick(0);;
	private Joystick driverLeft = new Joystick(1);
	private Joystick navigator = new Joystick(2);
	private XboXUID driverXbox = new XboXUID(3);
	private XboXUID navigatorXbox = new XboXUID(4);

	// Joystick navigator buttons
	private JoystickButton openLockerJ = new JoystickButton(navigator, 5);
	private JoystickButton closeLockerJ = new JoystickButton(navigator, 4);
	private JoystickButton openCraneJ = new JoystickButton(navigator, 3);
	private JoystickButton closeCraneJ = new JoystickButton(navigator, 2);
	private JoystickButton scoreJ = new JoystickButton(navigator, 6);
	private JoystickButton foldJ = new JoystickButton(navigator, 7);
	private JoystickButton loadJ = new JoystickButton(navigator, 10);

	// Xbox navigator buttons
	private Button closeLockerX = navigatorXbox.getRightButton();
	private Button openLockerX = navigatorXbox.getLeftButton();
	private Button openCraneX = navigatorXbox.getUpButton();
	private Button closeCraneX = navigatorXbox.getDownButton();
	private Button scoreX = navigatorXbox.getYellowButton();
	private Button foldX = navigatorXbox.getGreenButton();
	private Button loadX = navigatorXbox.getBlueButton();

	public OI() {
		// Xbox navigator commands
		initXboxNavigator();
	}

	private void initXboxNavigator() {
		closeLockerX.whileHeld(new MoveLimitedSubsystem(Robot.locker, Locker.LOCKING_SPEED));
		openLockerX.whileHeld(new MoveLimitedSubsystem(Robot.locker, Locker.UNLOCKING_SPEED));
		closeCraneX.whileHeld(new MoveLimitedSubsystem(Robot.crane, Crane.CRANE_CLOSING_SPEED));
		openCraneX.whileHeld(new MoveLimitedSubsystem(Robot.crane, Crane.CRANE_OPEN_SPEED));
		scoreX.whenPressed(new ScoreFloopy());
		loadX.whenPressed(new MoveToLoadPosition(Robot.crane));
		foldX.whenPressed(new Fold());
	}

	private void initJoystickNavigator() {
		closeLockerJ.whileHeld(new MoveLimitedSubsystem(Robot.locker, Locker.LOCKING_SPEED));
		openLockerJ.whileHeld(new MoveLimitedSubsystem(Robot.locker, Locker.UNLOCKING_SPEED));
		closeCraneJ.whileHeld(new MoveLimitedSubsystem(Robot.crane, Crane.CRANE_CLOSING_SPEED));
		openCraneJ.whileHeld(new MoveLimitedSubsystem(Robot.crane, Crane.CRANE_OPEN_SPEED));
		scoreJ.whenPressed(new ScoreFloopy());
		loadJ.whenPressed(new MoveToLoadPosition(Robot.crane));
		foldJ.whenPressed(new Fold());
	}

	private double adjustInput(double input) {
		return input * Math.abs(input);
	}

	public double getRotation() {
		return adjustInput(driverLeft.getY());
	}

	public double getForward() {
		return adjustInput(driverRight.getY());
	}
}