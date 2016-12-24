package com.spikes2212.falafel2016;

import com.spikes2212.falafel2016.commands.Fold;
import com.spikes2212.falafel2016.commands.MoveCrane;
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
	private boolean lockerIsFront;

	// Joysticks
	private Joystick driverRight = new Joystick(0);;
	private Joystick driverLeft = new Joystick(1);
	private Joystick navigator = new Joystick(2);
	private XboXUID driverXbox = new XboXUID(3);
	private XboXUID navigatorXbox = new XboXUID(4);
	
	//joystick driver
	private JoystickButton setLockerFront=new JoystickButton(driverRight, 3);
	private JoystickButton setLockerRear=new JoystickButton(driverRight, 2);

	// Joystick navigator buttons
	private JoystickButton openLockerJ = new JoystickButton(navigator, 5);
	private JoystickButton closeLockerJ = new JoystickButton(navigator, 4);
	private JoystickButton openCraneJ = new JoystickButton(navigator, 3);
	private JoystickButton closeCraneJ = new JoystickButton(navigator, 2);
	private JoystickButton scoreJ = new JoystickButton(navigator, 6);
	private JoystickButton foldJ = new JoystickButton(navigator, 7);
//	private JoystickButton loadJ = new JoystickButton(navigator, 10);

	// Xbox navigator buttons
	private Button openLockerX = navigatorXbox.getRedButton();
	private Button closeLockerX = navigatorXbox.getBlueButton();
	private Button openCraneX = navigatorXbox.getYellowButton();
	private Button closeCraneX = navigatorXbox.getGreenButton();
	private Button scoreX = navigatorXbox.getRbButton();
	private Button foldX = navigatorXbox.getLbButton();
//	private Button loadX = navigatorXbox.getBlueButton();
	
	
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
//		loadX.whenPressed(new MoveToLoadPosition(Robot.crane));
		foldX.whenPressed(new Fold());
	}

	private void initJoystickNavigator() {
		closeLockerJ.whileHeld(new MoveLimitedSubsystem(Robot.locker, Locker.LOCKING_SPEED));
		openLockerJ.whileHeld(new MoveLimitedSubsystem(Robot.locker, Locker.UNLOCKING_SPEED));
		closeCraneJ.whileHeld(new MoveCrane(Robot.crane, Crane.CRANE_CLOSING_SPEED));
		openCraneJ.whileHeld(new MoveCrane(Robot.crane, Crane.CRANE_OPEN_SPEED));
		scoreJ.whenPressed(new ScoreFloopy());
//		loadJ.whenPressed(new MoveToLoadPosition(Robot.crane));
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