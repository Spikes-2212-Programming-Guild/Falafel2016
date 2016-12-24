package com.spikes2212.falafel2016.commands;

import java.util.function.Supplier;

import com.spikes2212.falafel2016.subsystems.Brake;
import com.spikes2212.falafel2016.subsystems.Crane;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class MoveCrane extends CommandGroup {
    Supplier<Double> speedSupplier;
    Crane crane;
    public final static double waitTimeout = 0.2;

    public MoveCrane(Crane crane, Supplier<Double> s) {
        this.crane = crane;
        speedSupplier = s;
        addSequential(new WaitCommand(waitTimeout));
        addSequential(new MoveLimitedSubsystem(crane.brake, Brake.OPEN_SPEED));
        addSequential(new MoveLimitedSubsystem(crane, s));
        addSequential(new MoveLimitedSubsystem(crane.brake, Brake.CLOSE_SPEED));
    }

    public MoveCrane(Crane crane, Supplier<Double> s, double timeout) {
        this.crane = crane;
        speedSupplier = s;
        addSequential(new WaitCommand(waitTimeout));
        addSequential(new MoveLimitedSubsystem(crane.brake, Brake.OPEN_SPEED));
        addSequential(new MoveLimitedSubsystem(crane, s), timeout);//add timeut
        addSequential(new MoveLimitedSubsystem(crane.brake, Brake.CLOSE_SPEED));
    }

    public MoveCrane(Crane crane, double speed) {
        this(crane, () -> speed);
    }

    public MoveCrane(Crane crane, double speed, double timeout) {
        this(crane, () -> speed, timeout);
    }

    @Override
    protected boolean isFinished() {
        if (crane.isUp() && speedSupplier.get() > 0) {
            return true;
        }
        if (crane.isDown() && speedSupplier.get() < 0) {
            return true;
        }
        return super.isFinished();
    }
}
