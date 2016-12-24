package com.spikes2212.falafel2016.subsystems;

import com.spikes2212.genericsubsystems.LimitedSubsystem;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

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
	public static final double LOCKING_SPEED = 1;
	public static final double UNLOCKING_SPEED = -1;

	public Locker(SpeedController motor, DigitalInput up, DigitalInput down) {
		super(motor);
		motor.setInverted(true);
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

		return !down.get();
	}

	@Override
	public boolean isMax() {
		return !up.get();
	}

	@Override
	public PIDSource getPIDSource() {
		// TODO Auto-generated method stub
		return null;
	}

}
