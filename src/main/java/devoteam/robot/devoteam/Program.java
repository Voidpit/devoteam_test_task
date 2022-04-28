package devoteam.robot.devoteam;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import devoteam.robot.devoteam.command.MovingCommand;
import devoteam.robot.devoteam.model.Field;
import devoteam.robot.devoteam.model.Orientation;
import devoteam.robot.devoteam.model.Point;
import devoteam.robot.devoteam.model.Position;
import devoteam.robot.devoteam.service.CommandProvider;
import devoteam.robot.devoteam.service.FieldProvider;
import devoteam.robot.devoteam.service.RobotFactory;
import devoteam.robot.devoteam.service.StartPositionProvider;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@PropertySource("classpath:application.properties")
public class Program {

	/**
	 * Print a report about the position in the console
	 * @param position Position for reporting
	 */
	private static void printReport(@NonNull Position position) {
		Point coords = position.getCoords();
		System.out.println(String.format(
				"Report: %s %s %s",
				coords.getX(),
				coords.getY(),
				position.getOrientation()));
	}

	/**
	 * Invoke sequence of commands for the robot.
	 * @param robot Target robot
	 * @param commands Commands for invocation
	 */
	private static void invokeCommand(@NonNull Robot robot, @NonNull MovingCommand[] commands) {
		for (MovingCommand command : commands) {
			Point startPoint = robot.getPosition().getCoords();
			Orientation startOrientation = robot.getPosition().getOrientation();

			command.invoke(robot);

			Point finishPoint = robot.getPosition().getCoords();
			Orientation finishOrientation = robot.getPosition().getOrientation();

			log.info("command '{}': {} {} > {} {}",
					command.getClass().getSimpleName(),
					startPoint,
					startOrientation,
					finishPoint,
					finishOrientation);
		}
	}

	public static void main(String[] args) throws BeansException {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				"devoteam.robot.devoteam")) {

			// hi there!
			// use the application.properties file to configure the initial parameters and the list of commands
				
			Field field = context
					.getBean(FieldProvider.class)
					.getField();

			log.info("field size: {}x{}", 
				field.getWidth(), 
				field.getHeight());

			Position position = context
					.getBean(StartPositionProvider.class)
					.getPosition();

			log.info("init position: {} {}",
					position.getCoords(),
					position.getOrientation().name());

			Robot robot = context
					.getBean(RobotFactory.class)
					.create(field, position);

			MovingCommand[] commands = context
					.getBean(CommandProvider.class)
					.getCommands();

			invokeCommand(robot, commands);
			printReport(robot.getPosition());
		}
	}
}