package devoteam.robot.devoteam;

import devoteam.robot.devoteam.model.Position;

/**
 * Movable robot which knows its position
 */
public interface Robot extends Movable {

    Position getPosition();

}