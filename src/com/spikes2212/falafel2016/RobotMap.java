package com.spikes2212.falafel2016;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public interface USB {
		public static final String CAMRA_FORWARD = "cam0";
	}

	public interface CAN {
		public static final int CRANE_1 = 3;
		public static final int CRANE_2 = 1;
	}

	public interface PWM {
		public static final int DRIVETRAIN_RIGHT_1 = 2;// Electrical name - DTR1
		public static final int DRIVETRAIN_RIGHT_2 = 3;// Electrical name - DTR2
		public static final int DRIVETRAIN_LEFT_1 = 0;// Electrical name - DTL1
		public static final int DRIVETRAIN_LEFT_2 = 1;// Electrical name - DTL2
		public static final int LOCKER = 4;// Electrical name - Locker
		public static final int BREAK = 5;// Electrical name - ML 
	}

	public interface DIO {
		public static final int CRANE_UP = 9;//Dummy Port
		public static final int LOCKER_OPEN = 0;// Electrical name - No Name
		public static final int CRANE_DOWN = 1;// Electrical name - LSSUP
		public static final int BREAK_CLOSED = 2;// Electrical name - LSMLC
		public static final int BREAK_OPEN = 3;// Electrical name - LSMLO
		public static final int LOCKER_CLOSED = 4;// Electrical name - LSAC
	}
	public interface AnalogInput {
	}
}
