package com.spikes2212.falafel2016.commands;

import com.spikes2212.falafel2016.Robot;
import com.spikes2212.falafel2016.RobotMap;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Fold extends CommandGroup {
    public  Fold() {
    	addParallel(new MoveLimitedSubsystem(Robot.crane,RobotMap.CRANE_CLOSING_SPEED));
    	addParallel(new MoveLimitedSubsystem(Robot.locker, RobotMap.LOCKING_SPEED));
   
    }
}
