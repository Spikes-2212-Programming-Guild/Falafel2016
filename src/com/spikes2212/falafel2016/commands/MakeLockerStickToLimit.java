package com.spikes2212.falafel2016.commands;

import com.spikes2212.falafel2016.Robot;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class MakeLockerStickToLimit extends MoveLimitedSubsystem {
	public static final double WAITING_TIME = 5;
	private double lastFalseTime = 0;

	public MakeLockerStickToLimit(double speed) {
		super(Robot.locker, speed);

		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean isFinished() {
		double currentTime = Timer.getMatchTime();
		if (!super.isFinished()) {
			lastFalseTime = currentTime;
		}
		if (currentTime - lastFalseTime > WAITING_TIME) {
			return true;
		}
		return false;
	}

}
