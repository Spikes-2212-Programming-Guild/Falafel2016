package com.spikes2212.falafel2016.commands;

import java.util.function.Supplier;

import com.spikes2212.falafel2016.subsystems.Brake;
import com.spikes2212.falafel2016.subsystems.Crane;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveCrane extends CommandGroup {
	public MoveCrane(Supplier<Double> s, Crane crane) {
		addSequential(new MoveLimitedSubsystem(crane.brake, Brake.OPEN_SPEED));
		addSequential(new MoveLimitedSubsystem(crane, s));
		addSequential(new MoveLimitedSubsystem(crane.brake, Brake.CLOSE_SPEED));
	}

	public MoveCrane(double s, Crane crane) {
		this(() -> s, crane);
	}

}
