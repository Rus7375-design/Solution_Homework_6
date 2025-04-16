package SmartHomeRemoteControl;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();
        Thermostat thermostat = new Thermostat();

        Command lightOn = new TurnOnLightCommand(livingRoomLight);
        Command setTemp = new SetThermostatCommand(thermostat, 22);

        Command lightOff = new Command() {
            @Override
            public void execute() {
                livingRoomLight.turnOff();
            }

            @Override
            public void undo() {
                livingRoomLight.turnOn();
            }
        };

        Command tempDown = new SetThermostatCommand(thermostat, 18);
        Command goodnight = new MacroCommand(Arrays.asList(lightOff, tempDown));

        SmartHomeRemoteControl remote = new SmartHomeRemoteControl();
        remote.setCommand("light_on", lightOn);
        remote.setCommand("set_temp", setTemp);
        remote.setCommand("goodnight", goodnight);

        System.out.println("▶ Включаем свет");
        remote.pressButton("light_on");
        System.out.println("▶ Устанавливаем температуру");
        remote.pressButton("set_temp");
        System.out.println("▶ Goodnight mode");
        remote.pressButton("goodnight");
        System.out.println("▶ Undo: Goodnight mode");
        remote.undoButton();
    }
}
