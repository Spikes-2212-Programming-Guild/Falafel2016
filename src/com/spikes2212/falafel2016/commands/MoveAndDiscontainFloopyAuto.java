package com.spikes2212.falafel2016.commands;

import com.spikes2212.falafel2016.subsystems.Drivetrain;
import com.spikes2212.genericsubsystems.drivetrains.commands.DriveTank;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveAndDiscontainFloopyAuto extends CommandGroup{

	public MoveAndDiscontainFloopyAuto(Drivetrain dt){
		addSequential(new DriveTank(dt, 0.3, 0.3),7);
		addSequential(new ScoreFloopy());
		addSequential(new Fold());
	}
}
