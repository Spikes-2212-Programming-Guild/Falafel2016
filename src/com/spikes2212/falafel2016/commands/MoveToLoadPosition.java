package com.spikes2212.falafel2016.commands;

import java.util.function.Supplier;

import com.spikes2212.falafel2016.Robot;
import com.spikes2212.falafel2016.RobotMap;
import com.spikes2212.falafel2016.subsystems.Brake;
import com.spikes2212.falafel2016.subsystems.Crane;
import com.spikes2212.falafel2016.subsystems.Locker;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystemWithPID;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MoveToLoadPosition extends CommandGroup {

	public MoveToLoadPosition(Crane crane) {
		addSequential(new MoveLimitedSubsystem(crane.brake, Brake.OPEN_SPEED));
		addSequential(new MoveLimitedSubsystemWithPID(Crane.LOAD_ANGLE));
	}
}
