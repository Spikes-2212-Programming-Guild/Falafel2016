package com.spikes2212.falafel2016.commands;

import com.spikes2212.falafel2016.Robot;
import com.spikes2212.genericsubsystems.drivetrains.commands.DriveTank;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class MoveToWall extends Command {

	public static final double CAMERA_ANGLE=40;//FIXME actual number
	public static final double CAMERA_HEIGHT_PIXELS=320;//FIXME actual number
	public static final double REFLECTIVE_HEIGHT=15;//FIXME actual number
	public static final double MIN_RANGE=2;//FIXME actual number
	public static final double DRIVING_SPEED=0.7;
	private double reflectivePixels;
	private double distance;
	private double cameraRange;
	
	private NetworkTable table = NetworkTable.getTable(""); //TODO: enter the key of the table

	
    public MoveToWall() {
       requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	reflectivePixels=table.getNumber("",CAMERA_HEIGHT_PIXELS+10);//TODO:enter the name of this key 
    	cameraRange=(CAMERA_HEIGHT_PIXELS*REFLECTIVE_HEIGHT)/reflectivePixels; 
    	distance=cameraRange/(2*Math.tan((CAMERA_ANGLE/2)*Math.PI/180));
    	if(distance<=MIN_RANGE);
    	new DriveTank(Robot.drivetrain, DRIVING_SPEED, DRIVING_SPEED);	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
