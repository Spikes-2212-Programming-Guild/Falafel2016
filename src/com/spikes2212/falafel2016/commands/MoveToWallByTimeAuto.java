package com.spikes2212.falafel2016.commands;

import com.spikes2212.falafel2016.Robot;
import com.spikes2212.genericsubsystems.drivetrains.commands.DriveTank;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Created by thinkredstone on 12/25/16.
 */
public class MoveToWallByTimeAuto extends CommandGroup {
    public static final double LEFT_SPEED = 0.5;
    public static final double RIGHT_SPEED = 0.5;
    public static final double MOVING_TIME_OUT = 5;

    public MoveToWallByTimeAuto() {
        addSequential(new DriveTank(Robot.drivetrain, LEFT_SPEED, RIGHT_SPEED), MOVING_TIME_OUT);
    }
}
