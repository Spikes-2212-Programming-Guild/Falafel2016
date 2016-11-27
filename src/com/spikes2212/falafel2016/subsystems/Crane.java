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

	public static final double MIN = 35, MAX = 180, LOAD = 90;
	private Potentiometer pot;

	public Crane(SpeedController motor, int port) {
		super(motor);
		this.pot = new AnalogPotentiometer(port, 360, 0);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	@Override
	public boolean isMin() {
		// TODO Auto-generated method stub
		return (pot.get() <= MIN);
	}

	@Override
	public boolean isMax() {
		// TODO Auto-generated method stub
		return (pot.get() >= MAX);
	}

	@Override
	public PIDSource getPIDSource() {
		// TODO Auto-generated method stub
		return null;
	}

}
