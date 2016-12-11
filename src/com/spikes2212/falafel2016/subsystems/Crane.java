package com.spikes2212.falafel2016.subsystems;

import com.spikes2212.genericsubsystems.LimitedSubsystem;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

public class Crane extends LimitedSubsystem implements Lockable {

	public static final double LOAD_ANGLE = 90;

	public static final double CRANE_OPEN_SPEED = 0.5;
	public static final double CRANE_CLOSING_SPEED = -0.5;

	public boolean isLocked;

	private Potentiometer potentiometer;
	private DigitalInput up, down;

	Brake blocker;

	public Crane(SpeedController motor, Potentiometer potentiometer, DigitalInput up, DigitalInput down,
			Brake blocker) {
		super(motor);
		this.potentiometer = potentiometer;
		this.up = up;
		this.down = down;
		this.blocker = blocker;
	}

	public void initDefaultCommand() {

	}

	@Override
	public boolean isMin() {
		// TODO Auto-generated method stub
		return down.get();
	}

	@Override
	public boolean isMax() {
		// TODO Auto-generated method stub
		return up.get();
	}

	@Override
	public PIDSource getPIDSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isLocked() {
		// TODO Auto-generated method stub
		return !this.blocker.isMax();
	}

}
