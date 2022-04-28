package devoteam.robot.devoteam;

import org.springframework.stereotype.Service;

import devoteam.robot.devoteam.model.Field;
import devoteam.robot.devoteam.model.Position;
import devoteam.robot.devoteam.service.RobotFactory;

@Service
class RobotFactoryImpl implements RobotFactory {

    @Override
    public Robot create(Field field, Position position) {
        if (field.getWidth() <= 0 || field.getHeight() <= 0) {
            throw new IllegalArgumentException("Field must have positive dimension");
        }

        int x = position.getCoords().getX();
        int y = position.getCoords().getY();
        if (x < 0 || 
            y < 0 ||
            x > field.getWidth() ||
            y > field.getHeight()) {
            throw new IllegalArgumentException("Point must be on the field");
        }

        return new FieldRobot(
            field, 
            position.getCoords(), 
            position.getOrientation());
    }
        
}