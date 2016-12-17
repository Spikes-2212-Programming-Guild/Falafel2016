package com.spikes2212.falafel2016.commands;

import java.util.function.Supplier;

import com.spikes2212.falafel2016.Robot;
import com.spikes2212.falafel2016.subsystems.Crane;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

public class MoveCraneToLoadPozitionNoPID extends MoveLimitedSubsystem {
	public static final double TOLERANCE = 2212.2212;// fix this plz

	public MoveCraneToLoadPozitionNoPID(Crane crane, Supplier<Double> s) {
		super(crane, () -> {
			if (crane.getPIDSource().pidGet() < Crane.LOAD_ANGLE) {
				return s.get();
			} else {
				return -s.get();
			}
		});
	}

	@Override
	protected boolean isFinished() {
		return Math.abs(Robot.crane.getPIDSource().pidGet() - Crane.LOAD_ANGLE) <= TOLERANCE;
	}

}
