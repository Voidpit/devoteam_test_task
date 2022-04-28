package devoteam.robot.devoteam.service;

import devoteam.robot.devoteam.command.MovingCommand;

/**
 * Provides a sequence of commands which must be invoked for a robot
 */
public interface CommandProvider {
	MovingCommand[] getCommands();
}