package com.spikes2212.falafel2016;

import com.spikes2212.falafel2016.commands.*;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PrintCommand;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.spikes2212.cameras.CamerasHandler;
import com.spikes2212.falafel2016.subsystems.Brake;
import com.spikes2212.falafel2016.subsystems.Crane;
import com.spikes2212.falafel2016.subsystems.Drivetrain;
import com.spikes2212.falafel2016.subsystems.Locker;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;
import com.spikes2212.utils.DashBoardController;
import com.spikes2212.utils.DoubleSpeedcontroller;

public class Robot extends IterativeRobot {

    public static OI oi;
    public static Drivetrain drivetrain;
    public static Crane crane;
    public static Locker locker;
    public static SendableChooser chooser;
    public static Command autoCommand;
    public static CamerasHandler camerasHandler;
    public static DashBoardController dbc;
    public static SendableChooser sendableChooser;

    @Override
    public void robotInit() {

        dbc = new DashBoardController();
        drivetrain = new Drivetrain(new DoubleSpeedcontroller(new VictorSP(
                RobotMap.PWM.DRIVETRAIN_RIGHT_1), new VictorSP(
                RobotMap.PWM.DRIVETRAIN_RIGHT_2)), new DoubleSpeedcontroller(
                new VictorSP(RobotMap.PWM.DRIVETRAIN_LEFT_1), new VictorSP(
                RobotMap.PWM.DRIVETRAIN_LEFT_2)));
        Brake breaker = new Brake(new VictorSP(RobotMap.PWM.BREAK),
                new DigitalInput(RobotMap.DIO.BREAK_CLOSED), new DigitalInput(
                RobotMap.DIO.BREAK_OPEN));
        crane = new Crane(new DoubleSpeedcontroller(new CANTalon(
                RobotMap.CAN.CRANE_1), new CANTalon(RobotMap.CAN.CRANE_2)),
                null, new DigitalInput(RobotMap.DIO.CRANE_UP),
                new DigitalInput(RobotMap.DIO.CRANE_DOWN), breaker);
        locker = new Locker(new VictorSP(RobotMap.PWM.LOCKER),
                new DigitalInput(RobotMap.DIO.LOCKER_UNLOCKED), new DigitalInput(
                RobotMap.DIO.LOCKER_LOCKED));
        camerasHandler = new CamerasHandler(RobotMap.USB.CAMRA_FORWARD);

        sendableChooser = new SendableChooser();
        sendableChooser.addDefault("Do nothing", new PrintCommand("skipping auto..."));
        sendableChooser.addObject("Drive Forward", new MoveToWallByTimeAuto());
        sendableChooser.addObject("Score Floopy", new MoveAndDiscontainFloopyAuto());
        SmartDashboard.putData("Auto chooser:", sendableChooser);
        oi = new OI();

    }

    @Override
    public void disabledInit() {
        SmartDashboard.putData("Open Crane", new MoveCrane(crane,
                Crane.CRANE_OPEN_SPEED));
        SmartDashboard.putData("Closing Crane", new MoveCrane(crane,
                Crane.CRANE_CLOSING_SPEED));
        SmartDashboard.putData("unlock floopy", new MoveLimitedSubsystem(locker,
                Locker.UNLOCKING_SPEED));
        SmartDashboard.putData("lock floopy", new MoveLimitedSubsystem(locker,
                Locker.LOCKING_SPEED));
        SmartDashboard.putData("score floopy", new ScoreFloopy());
        SmartDashboard.putData("fold system", new Fold());
        SmartDashboard.putData("Open Brake", new MoveLimitedSubsystem(
                crane.brake, Brake.OPEN_SPEED));
        SmartDashboard.putData("Close Brake", new MoveLimitedSubsystem(
                crane.brake, Brake.CLOSE_SPEED));

        dbc.addBoolean("Crane down clicked", crane::isDown);
        dbc.addBoolean("Crane up clicked", crane::isUp);
        dbc.addBoolean("Brake closed", crane.brake::isMin);
        dbc.addBoolean("Brake open", crane.brake::isMax);
        dbc.addBoolean("Locker unlocked", locker::isMin);
        dbc.addBoolean("Locker locked", locker::isMax);
    }

    @Override
    public void autonomousInit() {
        autoCommand = (Command) sendableChooser.getSelected();
        autoCommand.start();
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        autoCommand.cancel();
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
        dbc.update();
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        dbc.update();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
