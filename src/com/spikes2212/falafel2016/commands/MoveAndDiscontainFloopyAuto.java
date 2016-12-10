package com.spikes2212.falafel2016.commands;

import com.spikes2212.falafel2016.subsystems.Drivetrain;
import com.spikes2212.genericsubsystems.drivetrains.commands.DriveTank;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveAndDiscontainFloopyAuto extends CommandGroup {

	public MoveAndDiscontainFloopyAuto(Drivetrain dt, double leftSpeed, double rightSpeed, double timeOut) {
		addSequential(new DriveTank(dt, leftSpeed, rightSpeed), timeOut);
		addSequential(new ScoreFloopy());
		addSequential(new Fold());
	}
}
