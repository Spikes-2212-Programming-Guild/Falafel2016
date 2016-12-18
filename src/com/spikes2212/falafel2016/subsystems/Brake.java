package com.spikes2212.falafel2016.subsystems;

import com.spikes2212.genericsubsystems.LimitedSubsystem;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;

public class Brake extends LimitedSubsystem {

	private DigitalInput close, open; // Normally open!
	public static final double OPEN_SPEED = 0.3;// FIXME actual speed
	public static final double CLOSE_SPEED = -0.3;// FIXME actual speed

	public Brake(SpeedController motor, DigitalInput close, DigitalInput open) {
		super(motor);
		this.close = close;
		this.open = open;
	}

	public Brake(int motorPort, int closePort, int openPort) {
		this(new VictorSP(motorPort), new DigitalInput(closePort), new DigitalInput(openPort));// FIXME
		// kind
		// of
		// motor
	}

	@Override
	public boolean isMin() {
		return !close.get();
	}

	@Override
	public boolean isMax() {
		return !open.get();
	}

	@Override
	public PIDSource getPIDSource() {
		return null;
	}

}