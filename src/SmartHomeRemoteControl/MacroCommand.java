package SmartHomeRemoteControl;

import java.util.List;
public class MacroCommand implements Command {

    private final List<Command> commands;

    public MacroCommand(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        System.out.println("[MacroCommand] Выполнение набора команд:");
        for (Command cmd : commands) {
            cmd.execute();
        }
    }

    @Override
    public void undo() {
        System.out.println("[MacroCommand] Отмена набора команд:");
        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).undo();
        }
    }
}

