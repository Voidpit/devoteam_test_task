package devoteam.robot.devoteam.model;

import lombok.Data;

@Data
public final class Position {
	private final Point coords;
	private final Orientation orientation;
}