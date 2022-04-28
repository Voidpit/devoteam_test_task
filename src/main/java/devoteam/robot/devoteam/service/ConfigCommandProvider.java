package devoteam.robot.devoteam.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import devoteam.robot.devoteam.command.GoForwardCommand;
import devoteam.robot.devoteam.command.MovingCommand;
import devoteam.robot.devoteam.command.TurnLeftCommand;
import devoteam.robot.devoteam.command.TurnRightCommand;

@Service
class ConfigCommandProvider implements CommandProvider {

    @Value("${commands}")
    private String commands;

    /**
     * Command parser method by a label (char)
     * @param label A command label
     * @return Matched command
     */
    private static MovingCommand createCommand(char label) {
        // Simple realization of matching label-to-command.
        // Possible to redesign the solution with separated factory for each command.
        switch (label) {
            case 'F': return new GoForwardCommand();
            case 'R': return new TurnRightCommand();
            case 'L': return new TurnLeftCommand();
            default: throw new IllegalArgumentException(
                "Unsupported command label"
            );
        }
    }

    @Override
    public MovingCommand[] getCommands() {
        char[] labels = this.commands.toCharArray();
        MovingCommand[] commands = new MovingCommand[labels.length];
        for (int i = 0; i < labels.length; i++) {
            commands[i] = createCommand(labels[i]);
        }
        return commands;
    }
    
}