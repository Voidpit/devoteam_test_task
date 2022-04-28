package devoteam.robot.devoteam.service;

import devoteam.robot.devoteam.model.Position;

/**
 * Provides robot`s start position
 */
public interface StartPositionProvider {
    Position getPosition();
}
