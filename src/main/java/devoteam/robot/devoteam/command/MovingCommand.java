package devoteam.robot.devoteam.command;

import devoteam.robot.devoteam.Movable;

/**
 * Moving action for a robot
 */
public interface MovingCommand {
    void invoke(Movable robot);
}