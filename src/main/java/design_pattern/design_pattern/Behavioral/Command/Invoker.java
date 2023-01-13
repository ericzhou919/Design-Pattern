package design_pattern.design_pattern.Behavioral.Command;

import java.util.ArrayList;
import java.util.List;

public class Invoker {

    private List<Command> commandList = new ArrayList<>();

    public void addCommand(Command command) {
        commandList.add(command);
    }

    public void execute() {
        for (Command command : commandList) {
            command.execute();
        }
    }
}
