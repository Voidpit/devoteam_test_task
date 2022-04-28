package devoteam.robot.devoteam.model;

import lombok.Data;

@Data
public final class Point {
    private final int x;
    private final int y;

    @Override
    public String toString() {
        return String.format("[%s,%s]", this.x, this.y);
    }
}
