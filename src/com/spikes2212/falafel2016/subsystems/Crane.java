package com.spikes2212.falafel2016.subsystems;

import com.spikes2212.falafel2016.RobotMap;
import com.spikes2212.genericsubsystems.LimitedSubsystem;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 *
 */
public class Crane extends LimitedSubsystem {

	public static final double MIN_ANGLE = 35, MAX_ANGLE = 180, LOAD_ANGLE = 90;
	
	public static final double CRANE_OPEN_SPEED = 0.5;
	public static final double CRANE_CLOSING_SPEED = -0.5;
	
	private Potentiometer potentiometer;

	public Crane(SpeedController motor,  Potentiometer potentiometer) {
		super(motor);
		this.potentiometer = potentiometer;
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	@Override
	public boolean isMin() {
		// TODO Auto-generated method stub
		return (potentiometer.get() <= MIN_ANGLE);
	}

	@Override
	public boolean isMax() {
		// TODO Auto-generated method stub
		return (potentiometer.get() >= MAX_ANGLE);
	}

	@Override
	public PIDSource getPIDSource() {
		// TODO Auto-generated method stub
		return potentiometer;
	}

}
