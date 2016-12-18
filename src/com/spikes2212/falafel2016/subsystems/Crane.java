package com.spikes2212.falafel2016.subsystems;

import com.spikes2212.genericsubsystems.LimitedSubsystem;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

public class Crane extends LimitedSubsystem {

	public static final double LOAD_ANGLE = 90;
	public static final double OFSET = 35;
	public static final double FULL_RANGE = 3600;
	public static final double CRANE_OPEN_SPEED = 0.5;
	public static final double CRANE_CLOSING_SPEED = -0.5;

	private Potentiometer potentiometer;
	private DigitalInput up, down;

	public final Brake brake;

	public Crane(SpeedController motor, Potentiometer potentiometer, DigitalInput up, DigitalInput down,
			Brake blocker) {
		super(motor);
		this.motor.setInverted(true);
		this.potentiometer = potentiometer;
		this.up = up;
		this.down = down;
		this.brake = blocker;
	}

	public void initDefaultCommand() {

	}

	@Override
	public boolean isMin() {
		return !down.get() || brake.isMax();
	}

	@Override
	public boolean isMax() {
		return !up.get() || brake.isMin(); //when brake is min it is closed
	}

	@Override
	public PIDSource getPIDSource() {
		return this.potentiometer;
	}

}
