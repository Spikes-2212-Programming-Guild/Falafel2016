package com.spikes2212.falafel2016;

import com.spikes2212.falafel2016.commands.Fold;
import com.spikes2212.falafel2016.commands.MoveToLoadPosition;
import com.spikes2212.falafel2016.commands.ScoreFloopy;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	private Joystick leftJoystick;

	JoystickButton scoreButton;
	JoystickButton foldButton;
	JoystickButton loadButton;

	public OI() {

		leftJoystick = new Joystick(0);

		scoreButton = new JoystickButton(leftJoystick, 1);
		loadButton = new JoystickButton(leftJoystick, 2);
		foldButton = new JoystickButton(leftJoystick, 3);

		scoreButton.whenPressed(new ScoreFloopy());
		loadButton.whenPressed(new MoveToLoadPosition());
		foldButton.whenPressed(new Fold());

	}

	public double getX() {
		return leftJoystick.getX();
	}

	public double getY() {
		return leftJoystick.getY();
	}
}
