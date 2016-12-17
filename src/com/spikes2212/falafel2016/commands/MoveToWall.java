package com.spikes2212.falafel2016.commands;

import com.spikes2212.falafel2016.Robot;
import com.spikes2212.genericsubsystems.drivetrains.commands.DriveTank;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class MoveToWall extends DriveTank {

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
    	super(Robot.drivetrain,DRIVING_SPEED,DRIVING_SPEED);
    }

    @Override
    protected boolean isFinished() {
    	reflectivePixels=table.getNumber("",CAMERA_HEIGHT_PIXELS+10);//TODO:enter the name of this key 
    	cameraRange=(CAMERA_HEIGHT_PIXELS*REFLECTIVE_HEIGHT)/reflectivePixels; 
    	distance=cameraRange/(2*Math.tan((CAMERA_ANGLE/2)*Math.PI/180));
        return (Math.abs(distance)<=MIN_RANGE);
    }
}
