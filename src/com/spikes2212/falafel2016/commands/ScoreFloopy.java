package com.spikes2212.falafel2016.commands;

import com.spikes2212.falafel2016.Robot;
import com.spikes2212.falafel2016.subsystems.Crane;
import com.spikes2212.falafel2016.subsystems.Locker;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ScoreFloopy extends CommandGroup {
	public ScoreFloopy() {
		addParallel(new MoveLimitedSubsystem(Robot.locker,
				Locker.LOCKING_SPEED * 2));
		addSequential(new MoveCrane(Robot.crane, Crane.CRANE_OPEN_SPEED));
	}
}
