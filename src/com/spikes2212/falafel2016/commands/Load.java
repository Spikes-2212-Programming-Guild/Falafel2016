package com.spikes2212.falafel2016.commands;

import com.spikes2212.falafel2016.Robot;
import com.spikes2212.falafel2016.RobotMap;
import com.spikes2212.falafel2016.subsystems.Crane;
import com.spikes2212.falafel2016.subsystems.Locker;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystemWithPID;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Load extends CommandGroup {

	public Load() {
		addParallel(new MoveLimitedSubsystem(Robot.locker, Locker.UNLOCKING_SPEED));
		addParallel(new MoveLimitedSubsystemWithPID(Crane.LOAD));
	}
}
