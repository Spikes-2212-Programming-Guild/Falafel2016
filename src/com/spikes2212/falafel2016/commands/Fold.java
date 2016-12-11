package com.spikes2212.falafel2016.commands;

import com.spikes2212.falafel2016.Robot;
import com.spikes2212.falafel2016.RobotMap;
import com.spikes2212.falafel2016.subsystems.Blocker;
import com.spikes2212.falafel2016.subsystems.Crane;
import com.spikes2212.falafel2016.subsystems.Locker;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Fold extends CommandGroup {
	public Fold() {
		if (!Robot.crane.isLocked()) {
			addSequential(new MoveLimitedSubsystem(Robot.blocker, Blocker.OPEN_SPEED));// FIXME
																		// add
																		// actual
																		// speed
		}
		addParallel(new MoveLimitedSubsystem(Robot.crane, Crane.CRANE_CLOSING_SPEED));
		addParallel(new MoveLimitedSubsystem(Robot.locker, Locker.LOCKING_SPEED));
	}
}
