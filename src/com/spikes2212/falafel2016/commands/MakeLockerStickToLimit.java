package com.spikes2212.falafel2016.commands;

import java.sql.Time;

import com.spikes2212.falafel2016.Robot;
import com.spikes2212.falafel2016.subsystems.Locker;
import com.spikes2212.genericsubsystems.LimitedSubsystem;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MakeLockerStickToLimit extends MoveLimitedSubsystem {
	public static final double WAITING_TIME = 5;
	private double firstTimeHitLimits;
	private double currentTime;
	private Timer t = new Timer();
	private boolean stillHitting = false;

	public MakeLockerStickToLimit(double speed) {
		super(Robot.locker, speed);

		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean isFinished() {
		currentTime = t.get();
		if (Robot.locker.isMax() || Robot.locker.isMin()) {
			if (!stillHitting) {
				firstTimeHitLimits = currentTime;
				stillHitting = true;
			} else if (currentTime - firstTimeHitLimits >= WAITING_TIME) {
				stillHitting = false;
				return true;
			}
			return false;
		} else {
			stillHitting = false;
			return false;
		}
	}

}
