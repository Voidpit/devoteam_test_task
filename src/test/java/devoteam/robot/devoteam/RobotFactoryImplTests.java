package devoteam.robot.devoteam;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import devoteam.robot.devoteam.model.Field;
import devoteam.robot.devoteam.model.Orientation;
import devoteam.robot.devoteam.model.Point;
import devoteam.robot.devoteam.model.Position;
import devoteam.robot.devoteam.service.RobotFactory;

@ExtendWith(MockitoExtension.class)
class RobotFactoryImplTests {

	private final RobotFactory factory = new RobotFactoryImpl();

	@Test
	void createValidRobot() {
		factory.create(
			new Field(5, 5), 
			new Position(new Point(2, 2), Orientation.North));
	}

	@Test
	void negativeFieldDimension() {
		assertThrows(IllegalArgumentException.class, () -> {
			factory.create(
				new Field(-5, 5), 
				new Position(new Point(2, 2), Orientation.North));
		});
	}

	@Test
	void zeroFieldDimension() {
		assertThrows(IllegalArgumentException.class, () -> {
			factory.create(
				new Field(1, 0), 
				new Position(new Point(2, 2), Orientation.North));
		});
	}

	@Test
	void negativePoint() {
		assertThrows(IllegalArgumentException.class, () -> {
			factory.create(
				new Field(5, 5), 
				new Position(new Point(-2, 2), Orientation.North));
		});
	}

	@Test
	void pointOutsideTheField() {
		assertThrows(IllegalArgumentException.class, () -> {
			factory.create(
				new Field(5, 5), 
				new Position(new Point(10, 2), Orientation.North));
		});
	}

}
