package com.spikes2212.falafel2016.subsystems;

import com.spikes2212.genericsubsystems.drivetrains.TankDrivetrain;
import com.spikes2212.utils.DoubleSpeedcontroller;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetain extends TankDrivetrain {
	private SpeedController leftSpeedcontroller;
	private SpeedController rightSpeedcontroller;

	@Override
	public void setLeft(double speedLeft) {
		// TODO Auto-generated method stub
		leftSpeedcontroller.set(speedLeft);
	}

	@Override
	public void setRight(double speedRight) {
		rightSpeedcontroller.set(speedRight);
		
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
	        
	}
}

