package com.spikes2212.falafel2016.commands;

import com.spikes2212.falafel2016.Robot;
import com.spikes2212.falafel2016.subsystems.Crane;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveToStartingPosition extends CommandGroup {
	public static final double OPENING_TIME_OUT = 0.5;

	public MoveToStartingPosition() {
		addSequential(new MoveCrane(Robot.crane, Crane.CRANE_OPEN_SPEED, OPENING_TIME_OUT));
		addSequential(new Fold());
	}

}
