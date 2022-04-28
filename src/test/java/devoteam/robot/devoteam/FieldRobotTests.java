package devoteam.robot.devoteam;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import devoteam.robot.devoteam.model.Field;
import devoteam.robot.devoteam.model.Orientation;
import devoteam.robot.devoteam.model.Point;
import devoteam.robot.devoteam.model.Position;

public class FieldRobotTests {

    private static final int FIELD_SIDE = 10;

    private static Robot createDefaultRobot() {
        return createDefaultRobot(5, 5);
    }

    private static Robot createDefaultRobot(int x, int y) {
        return new FieldRobot(new Field(FIELD_SIDE, FIELD_SIDE), new Point(x, y), Orientation.North);
    }
    
	@Test
    public void createNewInstance() {
        Robot robot = createDefaultRobot(1, 1);
        Position position = robot.getPosition();
        assertEquals(Orientation.North, position.getOrientation());
        assertEquals(new Point(1, 1), position.getCoords());
    }
    
	@Test
    public void goCircle() {
        Robot robot = createDefaultRobot();
        Position startPosition = robot.getPosition();
        for (int i = 0; i < 8; i++) {
            robot.goForward();
            robot.turnRight();
        }
        Position finishPosition = robot.getPosition();
        assertEquals(startPosition, finishPosition);
    }
    
	@Test
    public void limitByBoundaries() {
        Robot robot = createDefaultRobot(0, 0);

        Point[] path = new Point[] {
            new Point(0, 0),
            new Point(0, FIELD_SIDE),
            new Point(FIELD_SIDE, FIELD_SIDE),
            new Point(FIELD_SIDE, 0),
            new Point(0, 0),
        };

        for (Point point : path) {
            robot.turnLeft();   
            for (int i = 0; i < FIELD_SIDE; i++) {
                robot.goForward();
            }
            assertEquals(point, robot.getPosition().getCoords()); 
        }        
    }
}
