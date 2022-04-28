package devoteam.robot.devoteam.command;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import devoteam.robot.devoteam.Robot;

@ExtendWith(MockitoExtension.class)
public class TurnRightCommandTests {

    @Test
    public void invokeRobot(@Mock Robot robot) {
        MovingCommand command = new TurnRightCommand();
        command.invoke(robot);
        verify(robot, times(1)).turnRight();
    }
    
}