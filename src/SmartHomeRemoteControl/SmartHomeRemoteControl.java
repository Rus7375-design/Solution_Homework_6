package SmartHomeRemoteControl;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
public class SmartHomeRemoteControl {

    private final Map<String, Command> commandSlots = new HashMap<>();
    private final Stack<Command> history = new Stack<>();

    public void setCommand(String slotName, Command command) {
        commandSlots.put(slotName, command);
    }

    public void pressButton(String slotName) {
        Command command = commandSlots.get(slotName);
        if (command != null) {
            command.execute();
            history.push(command);
        } else {
            System.out.println("[Remote] Нет команды для слота: " + slotName);
        }
    }

    public void undoButton() {
        if (!history.isEmpty()) {
            Command lastCommand = history.pop();
            lastCommand.undo();
        } else {
            System.out.println("[Remote] Нечего отменять");
        }
    }
}

