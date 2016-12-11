package com.spikes2212.falafel2016.subsystems;

import com.spikes2212.genericsubsystems.LimitedSubsystem;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;

public class Brake extends LimitedSubsystem {

	private DigitalInput stopBreaking; // Normally open!
	public static final double OPEN_SPEED=0.3;//FIXME actual speed
	public static final double BLOCK_SPEED=-0.3;//FIXME actual speed

	public Brake(SpeedController motor, DigitalInput stopBreaking) {
		super(motor);
		this.stopBreaking = stopBreaking;
	}

	public Brake(int motorPort, int digitalInputPort) {
		this(new VictorSP(motorPort), new DigitalInput(digitalInputPort));// FIXME
																			// kind
																			// of
																			// motor
	}

	@Override
	public boolean isMin() {
		return isMax();
	}

	@Override
	public boolean isMax() {
		return stopBreaking.get();
	}

	@Override
	public PIDSource getPIDSource() {
		return null;
	}

}