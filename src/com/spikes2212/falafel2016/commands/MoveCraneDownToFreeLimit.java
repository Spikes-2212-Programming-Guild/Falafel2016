package com.spikes2212.falafel2016.commands;

import com.spikes2212.falafel2016.subsystems.Crane;

import java.util.function.Supplier;

/**
 * Created by thinkredstone on 12/24/16.
 */
public class MoveCraneDownToFreeLimit extends MoveCrane {

    private Crane crane;

    public MoveCraneDownToFreeLimit(Crane crane, Supplier<Double> s) {
        super(crane, s);
        this.crane = crane;
    }

    public MoveCraneDownToFreeLimit(Crane crane, Supplier<Double> s, double timeout) {
        super(crane, s, timeout);
        this.crane = crane;
    }

    public MoveCraneDownToFreeLimit(Crane crane, double speed) {
        this(crane, () -> speed);
    }

    public MoveCraneDownToFreeLimit(Crane crane, double speed, double timeout) {
        this(crane, () -> speed, timeout);
    }

    @Override
    protected boolean isFinished() {
        return super.isFinished() || !crane.isUp();
    }
}
