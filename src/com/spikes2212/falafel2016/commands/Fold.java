
package com.spikes2212.falafel2016.commands;

import com.spikes2212.falafel2016.Robot;
import com.spikes2212.falafel2016.subsystems.Crane;
import com.spikes2212.falafel2016.subsystems.Locker;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Fold extends CommandGroup {
	public Fold() {
		addSequential(new MoveLimitedSubsystem(Robot.locker, Locker.UNLOCKING_SPEED));
		addSequential(new MoveCrane(Robot.crane, Crane.CRANE_CLOSING_SPEED));
	}
}
