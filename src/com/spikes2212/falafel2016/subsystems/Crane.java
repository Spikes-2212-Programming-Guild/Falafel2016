package com.spikes2212.falafel2016.subsystems;

import com.spikes2212.genericsubsystems.LimitedSubsystem;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Crane extends LimitedSubsystem {
	private DigitalInput min;
	private DigitalInput max;
	public Crane(SpeedController motor,DigitalInput min,DigitalInput max) {
		super(motor);
		this.min=min;
		this.max=max;
	}

	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	@Override
	public boolean isMin() {
		// TODO Auto-generated method stub
		return min.get();
	}

	@Override
	public boolean isMax() {
		// TODO Auto-generated method stub
		return max.get();
	}

	@Override
	public PIDSource getPIDSource() {
		// TODO Auto-generated method stub
		return null;
	}
}

