package devoteam.robot.devoteam;

import devoteam.robot.devoteam.model.Field;
import devoteam.robot.devoteam.model.Orientation;
import devoteam.robot.devoteam.model.Point;
import devoteam.robot.devoteam.model.Position;
import lombok.NonNull;

/**
 * Robot which can move only inside a field
 */
class FieldRobot implements Robot {

    private @NonNull Field field;
    private @NonNull Point coords;
    private @NonNull Orientation orientation;

    public FieldRobot(
        @NonNull Field field,
        @NonNull Point coords, 
        @NonNull Orientation orientation) {
        this.field = field;
        this.coords = coords;
        this.orientation = orientation;
    }

    @Override
    public void goForward() {
        Point shift = this.orientation.getShift();

        // predicted coordinates
        int x = this.coords.getX() + shift.getX();
        int y = this.coords.getY() + shift.getY();

        // x boundary limits
        x = Math.max(x, 0);
        x = Math.min(x, this.field.getWidth());

        // y boundary limits
        y = Math.max(y, 0);
        y = Math.min(y, this.field.getHeight());

        this.coords = new Point(x, y);
    }

    @Override
    public void turnLeft() {
        this.orientation = this.orientation.TurnLeft();
    }

    @Override
    public void turnRight() {
        this.orientation = this.orientation.TurnRight();
    }

    @Override
    public Position getPosition() {
        return new Position(this.coords, this.orientation);
    }
    
}
