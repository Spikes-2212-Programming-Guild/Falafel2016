package com.spikes2212.falafel2016.commands;

import com.spikes2212.falafel2016.Robot;
import com.spikes2212.falafel2016.subsystems.Crane;
import com.spikes2212.falafel2016.subsystems.Drivetrain;
import com.spikes2212.genericsubsystems.drivetrains.commands.DriveTank;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveAndDiscontainFloopyAuto extends CommandGroup {
	public static final double LEFT_SPEED=0.3;
	public static final double RIGHT_SPEED=0.3;
	public static final double OPENING_TIME_OUT=0.5;
	public static final double MOVING_TIME_OUT=7;
	
	public MoveAndDiscontainFloopyAuto() {
		addSequential(new MoveCrane(Robot.crane, Crane.CRANE_OPEN_SPEED, OPENING_TIME_OUT));
		addSequential(new Fold());
		addSequential(new DriveTank(Robot.drivetrain, LEFT_SPEED, RIGHT_SPEED), MOVING_TIME_OUT);
		addSequential(new ScoreFloopy());
		addSequential(new Fold());
	}
}
