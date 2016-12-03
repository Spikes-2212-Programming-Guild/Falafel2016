package com.spikes2212.falafel2016.commands;

import com.spikes2212.falafel2016.Robot;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ScoreFloopy extends CommandGroup {
    static public final double CRANE_SPEED=0.5 , LOCKER_SPEED=0.3;
    public  ScoreFloopy() {
    	addSequential(new MoveLimitedSubsystem(Robot.crane,CRANE_SPEED));
    	addSequential(new MoveLimitedSubsystem(Robot.locker, LOCKER_SPEED));
   
    }
}
