package devoteam.robot.devoteam.command;

import devoteam.robot.devoteam.Movable;

public class GoForwardCommand implements MovingCommand {

    @Override
    public void invoke(Movable robot) {
        robot.goForward();
    }
    
}