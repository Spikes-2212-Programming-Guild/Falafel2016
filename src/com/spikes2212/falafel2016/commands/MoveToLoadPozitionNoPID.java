package com.spikes2212.falafel2016.commands;

import com.spikes2212.falafel2016.Robot;
import com.spikes2212.falafel2016.subsystems.Brake;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveToLoadPozitionNoPID extends CommandGroup {

	public MoveToLoadPozitionNoPID() {
		addSequential(new MoveLimitedSubsystem(Robot.crane.brake, Brake.OPEN_SPEED));
		addSequential(new MoveCraneToLoadPozitionNoPID());
		addSequential(new MoveLimitedSubsystem(Robot.crane.brake, Brake.CLOSE_SPEED));
	}

}
