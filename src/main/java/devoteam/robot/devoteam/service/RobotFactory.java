package devoteam.robot.devoteam.service;

import devoteam.robot.devoteam.Robot;
import devoteam.robot.devoteam.model.Field;
import devoteam.robot.devoteam.model.Position;

/**
 * 
 */
public interface RobotFactory {
        /**
         * Create a new instance of robot which can moving inside the field.
         * @param field Not empty field with positive dimensions
         * @param position The position must be inside the field
         * @throws IllegalArgumentException Invalid parameters
         */
        Robot create(Field field, Position position);
}