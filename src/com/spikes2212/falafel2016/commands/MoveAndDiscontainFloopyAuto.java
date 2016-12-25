package com.spikes2212.falafel2016.commands;

import com.spikes2212.falafel2016.Robot;
import com.spikes2212.genericsubsystems.drivetrains.commands.DriveTank;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class MoveAndDiscontainFloopyAuto extends CommandGroup {
    public static final double DROPPING_TIME_OUT = 3;

    public MoveAndDiscontainFloopyAuto() {
        addSequential(new MoveAndDiscontainFloopyAuto());
        addSequential(new ScoreFloopy());
        addSequential(new WaitCommand(DROPPING_TIME_OUT));
        addSequential(new MoveCrane(Robot.crane, Robot.crane.CRANE_CLOSE_SUPPLIER));
    }
}
