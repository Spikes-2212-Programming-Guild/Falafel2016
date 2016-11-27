package com.spikes2212.utils;

import edu.wpi.first.wpilibj.VictorSP;

public class Gearbox {

	private VictorSP motor01;
	private VictorSP motor02;

	public Gearbox(VictorSP motor01, VictorSP motor02) {
		this.motor01 = motor01;
		this.motor02 = motor02;
	}

	public Gearbox(int port01, int port02){
		
		motor01 = new VictorSP(port01);
		motor02 = new VictorSP(port02);
	}
	
	public void setSpeed(double speed){
		motor01.set(speed);
		motor02.set(speed);
	}
	
}