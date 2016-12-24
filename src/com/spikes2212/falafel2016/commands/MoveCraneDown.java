package com.spikes2212.falafel2016.commands;

import com.spikes2212.falafel2016.Robot;
import com.spikes2212.falafel2016.subsystems.Brake;
import com.spikes2212.falafel2016.subsystems.Crane;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Created by thinkredstone on 12/24/16.
 */
public class MoveCraneDown extends CommandGroup{


    public MoveCraneDown() {
        addSequential(new MoveCraneDownToFreeLimit(Robot.crane, Crane.CRANE_FAST_CLOSING_SPEED));
        addSequential(new MoveLimitedSubsystem(Robot.crane.brake, Brake.CLOSE_SPEED));
        addSequential(new MoveCrane(Robot.crane, Crane.CRANE_CLOSING_SPEED));
    }
}
