package devoteam.robot.devoteam.model;

import java.util.HashMap;
import java.util.Map;

public enum Orientation {

    North("N", new Point(0, -1)),
    West("W", new Point(-1, 0)),
    South("S", new Point(0, 1)),
    East("E", new Point(1, 0));

    // We have a few options for rotating so a Map can be fast, transparent and simple solution.
    // In case of a lot of values an alternative way to use a linked list.
    private static Map<Orientation, Orientation> LEFT_TURN = new HashMap<>()
    {{
         put(Orientation.North, Orientation.West);
         put(Orientation.West, Orientation.South);
         put(Orientation.South, Orientation.East);
         put(Orientation.East, Orientation.North);
    }};

    private static Map<Orientation, Orientation> RIGHT_TURN = new HashMap<>()
    {{
         put(Orientation.North, Orientation.East);
         put(Orientation.East, Orientation.South);
         put(Orientation.South, Orientation.West);
         put(Orientation.West, Orientation.North);
    }};

    private final String label;
    private final Point shift;

    private Orientation(String label, Point shift) {
        this.label = label;
        this.shift = shift;
    }

    public Orientation TurnLeft() {
        return LEFT_TURN.get(this);
    }

    public Orientation TurnRight() {
        return RIGHT_TURN.get(this);
    }

    public Point getShift() {
        return this.shift;
    }

    public String getLabel() {
        return this.label;
    }

    @Override
    public String toString() {
        return this.label;
    }
}