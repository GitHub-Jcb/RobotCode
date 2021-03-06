/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.DriveWithJoystick;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.MoveIntake;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.SteelTalonsControllerGroup;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Hatch;
import frc.robot.commands.MoveHatch;
import frc.robot.subsystems.Arm;
import frc.robot.commands.MoveArmUp;
import frc.robot.commands.MoveArmDown;
import frc.robot.subsystems.Wrist;
import frc.robot.commands.MoveWristDown;
import frc.robot.commands.MoveWristUp;
/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  

  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private SpeedController leftOne, leftTwo, rightOne, rightTwo;
  private SpeedControllerGroup left, right;
  private DifferentialDrive drive;
  private DriveTrain driveTrain;
  
  private SpeedController intakeLeft, intakeRight;
  private Intake intake;
  
  private Joystick joy;
  private Button intakeIn, intakeOut;
  private Button hatchM;
  private Button armMU;
  private Button armMD;
  private Button wristMU;
  private Button wristMD;


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings

    leftOne = new SteelTalonsController(0, false, 1);
    leftTwo = new SteelTalonsController(1, false, 1);
    rightOne = new SteelTalonsController(2, false, 1);
    rightTwo = new SteelTalonsController(3, false, 1);
    SpeedController armSc = 0;
    SpeedController wristSc;

    left = new SpeedControllerGroup(leftOne, leftTwo);
    right = new SpeedControllerGroup(rightOne, rightTwo);

    drive = new DifferentialDrive(left, right);

    driveTrain = new DriveTrain(left, right, drive);

    driveTrain.setDefaultCommand(new DriveWithJoystick());

    intakeLeft = new SteelTalonsController(4, false, 1);
    intakeRight = new SteelTalonsController(5, false, 1);

    intake = new Intake(intakeLeft, intakeRight);

    Solenoid solenoid = new Solenoid(0);
    Hatch hatch = new Hatch(solenoid, true);
    Arm arm = new Arm(armSc);
    Wrist wrist = new Wrist(wristSc, Constants.WRIST_ANGLE, Constants.WRIST_TOP_LIMIT, Constants.WRIST_BOTTOM_LIMIT, Constants.WRIST_HEIGHT);



   




    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  
  
    joy = new Joystick(0);
    intakeIn = new JoystickButton(joy, Constants.INTAKE_IN_BUTTTON);
    intakeOut = new JoystickButton(joy, Constants.INTAKE_OUT_BUTTON);
    hatchM = new JoystickButton(joy, Constants.HATCH_MOVE_BUTTON);
    armMU = new JoystickButton(joy, Constants.ARM_MOVE_UP_BUTTON);
    armMD = new JoystickButton(joy, Constants.ARM_MOVE_DOWN_BUTTON);
    wristMU = new JoystickButton(joy, Constants.WRIST_MOVE_UP_BUTTON);
    wristMD = new JoystickButton(joy, Constants.WRIST_MOVE_DOWN_BUTTON);

    intakeIn.whileHeld(new MoveIntake(Constants.INTAKE_IN_SPEED));
    intakeOut.whileHeld(new MoveIntake(Constants.INTAKE_OUT_SPEED));
    hatchM.whileHeld(new MoveHatch(hatch));
    armMU.whileHeld(new MoveArmUp(arm));
    armMD.whileHeld(new MoveArmDown(arm));
    wristMU.whileHeld(new MoveWristUp(wrist));
    wristMD.whileHeld(new MoveWristDown(wrist));


  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }

  
  public Intake getIntake()
  {
    return intake;
  }
  
  
  
  public DriveTrain getDriveTrain()
  {
    return driveTrain;
  }
}
