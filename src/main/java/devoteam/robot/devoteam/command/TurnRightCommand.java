package devoteam.robot.devoteam.command;

import devoteam.robot.devoteam.Movable;

public class TurnRightCommand implements MovingCommand {

    @Override
    public void invoke(Movable robot) {
        robot.turnRight();
    }
    
}