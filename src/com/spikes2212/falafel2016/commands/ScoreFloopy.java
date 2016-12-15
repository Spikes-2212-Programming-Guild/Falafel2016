package com.spikes2212.falafel2016.commands;

import com.spikes2212.falafel2016.Robot;
import com.spikes2212.falafel2016.subsystems.Crane;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ScoreFloopy extends CommandGroup {
	public ScoreFloopy() {
		addSequential(new MoveCrane(Robot.crane, Crane.CRANE_OPEN_SPEED));
	}
}
