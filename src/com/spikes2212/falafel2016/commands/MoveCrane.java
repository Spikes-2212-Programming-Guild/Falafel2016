package com.spikes2212.falafel2016.commands;

import java.util.function.Supplier;

import com.spikes2212.falafel2016.subsystems.Brake;
import com.spikes2212.falafel2016.subsystems.Crane;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveCrane extends CommandGroup {
	public MoveCrane(Crane crane, Supplier<Double> s) {
		addSequential(new MoveLimitedSubsystem(crane.brake, Brake.OPEN_SPEED));
		addSequential(new MoveLimitedSubsystem(crane, s));
	}

	public MoveCrane(Crane crane, Supplier<Double> s, double timeout) {
		addSequential(new MoveLimitedSubsystem(crane.brake, Brake.OPEN_SPEED));
		addSequential(new MoveLimitedSubsystem(crane, s),timeout);//add timeut
	}

	public MoveCrane(Crane crane, double speed) {
		this(crane, () -> speed);
	}

	public MoveCrane(Crane crane, double speed, double timeout) {
		this(crane, () -> speed, timeout);
	}
}
