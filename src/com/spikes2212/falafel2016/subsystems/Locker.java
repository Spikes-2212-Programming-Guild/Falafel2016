package com.spikes2212.falafel2016.subsystems;

import com.spikes2212.genericsubsystems.LimitedSubsystem;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;

/**
 *
 */
public class Locker extends LimitedSubsystem {

	private DigitalInput up, down;

	public Locker(SpeedController motor, DigitalInput up, DigitalInput down) {
		super(motor);
		this.up = up;
		this.down = down;
	}

	public Locker(int motorPort, int upPort, int downPort) {
		this(new VictorSP(motorPort), new DigitalInput(upPort), new DigitalInput(downPort));
	}

	public void initDefaultCommand() {

	}

	@Override
	public boolean isMin() {

		return down.get();
	}

	@Override
	public boolean isMax() {

		return up.get();
	}

	@Override
	public PIDSource getPIDSource() {
		// TODO Auto-generated method stub
		return null;
	}

}
