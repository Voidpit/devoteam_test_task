package devoteam.robot.devoteam.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import devoteam.robot.devoteam.model.Orientation;
import devoteam.robot.devoteam.model.Point;
import devoteam.robot.devoteam.model.Position;

@Service
class ConfigStartPositionProvider implements StartPositionProvider {

    @Value("${position.x}")
    private int x;

    @Value("${position.y}")
    private int y;

    @Value("${position.orientation}")
    private String orientation;

    private Orientation getOrientation() {
        for (Orientation value : Orientation.values()) {
            if (value.getLabel().equals(this.orientation)) {
                return value;
            }
        }
        throw new IllegalArgumentException(
            "Unsupported orientation value"
        );
    }

    @Override
    public Position getPosition() {
        return new Position(new Point(this.x, this.y), getOrientation());
    }
    
}