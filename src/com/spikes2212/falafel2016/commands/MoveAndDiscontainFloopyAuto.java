package com.spikes2212.falafel2016.commands;

import com.spikes2212.falafel2016.subsystems.Drivetrain;
import com.spikes2212.genericsubsystems.drivetrains.commands.DriveTank;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveAndDiscontainFloopyAuto extends CommandGroup {
	public static final double LEFT_SPEED=0.3;
	public static final double RIGHT_SPEED=0.3;
	
	public MoveAndDiscontainFloopyAuto(Drivetrain dt, double timeOut) {
		addSequential(new DriveTank(dt, LEFT_SPEED, RIGHT_SPEED), timeOut);
		addSequential(new ScoreFloopy());
		addSequential(new Fold());
	}
}
