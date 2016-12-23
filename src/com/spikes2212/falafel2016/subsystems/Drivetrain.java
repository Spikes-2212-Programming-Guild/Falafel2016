package com.spikes2212.falafel2016.subsystems;

import com.spikes2212.falafel2016.Robot;
import com.spikes2212.genericsubsystems.drivetrains.TankDrivetrain;
import com.spikes2212.genericsubsystems.drivetrains.commands.DriveArcade;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 */
public class Drivetrain extends TankDrivetrain {

	private SpeedController leftSpeedController;
	private SpeedController rightSpeedController;

	public Drivetrain(SpeedController leftSpeedController, SpeedController rightSpeedController) {
		this.leftSpeedController = leftSpeedController;
		this.rightSpeedController = rightSpeedController;
	}

	@Override
	public void setLeft(double speedLeft) {
		leftSpeedController.set(-speedLeft);
	}

	@Override
	public void setRight(double speedRight) {
		rightSpeedController.set(speedRight);

	}

	@Override
	public PIDSource getLeftPIDSource() {
		return null;
	}

	@Override
	public PIDSource getRightPIDSource() {
		return null;
	}

	public void initDefaultCommand() {
		setDefaultCommand(new DriveArcade(this, Robot.oi::getForward, Robot.oi::getRotation));
	}
}