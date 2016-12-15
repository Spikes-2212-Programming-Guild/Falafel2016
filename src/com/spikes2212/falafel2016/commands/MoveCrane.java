package com.spikes2212.falafel2016.commands;

import java.util.function.Supplier;

import com.spikes2212.falafel2016.subsystems.Brake;
import com.spikes2212.falafel2016.subsystems.Crane;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveCrane extends CommandGroup {
	public MoveCrane(Crane crane, Supplier<Double> s) {
		addSequential(new MoveLimitedSubsystem(crane.brake, Brake.OPEN_SPEED),10);
		addSequential(new MoveLimitedSubsystem(crane, s),10);
		addSequential(new MoveLimitedSubsystem(crane.brake, Brake.CLOSE_SPEED));
	}

	public MoveCrane(Crane crane, double s) {
		this(crane, () -> s);
	}

}
