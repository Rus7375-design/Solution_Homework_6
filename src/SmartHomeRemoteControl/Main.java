package SmartHomeRemoteControl;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Light light = new Light();
        Thermostat thermostat = new Thermostat();
        Command turnLightOn = new TurnOnLightCommand(light);
        Command setTemp22 = new SetThermostatCommand(thermostat, 22);
        Command tempDown = new SetThermostatCommand(thermostat, 18);

        Command turnLightOff = new Command() {
            @Override
            public void execute() {
                light.turnOff();
            }

            @Override
            public void undo() {
                light.turnOn();
            }
        };

        Command goodnight = new MacroCommand(Arrays.asList(turnLightOff, tempDown));
        SmartHomeRemoteControl remote = new SmartHomeRemoteControl();
        remote.setCommand("1", turnLightOn);
        remote.setCommand("2", setTemp22);
        remote.setCommand("3", goodnight);
        while (true) {
            System.out.println("\n==== Умный дом: Меню ====");
            System.out.println("1. Включить свет");
            System.out.println("2. Установить температуру 22°C");
            System.out.println("3. Goodnight Mode");
            System.out.println("u. Undo");
            System.out.println("q. Выход");
            System.out.print("Выберите команду: ");

            String input = scanner.nextLine();

            if (input.equals("q")) {
                System.out.println("Завершение программы.");
                break;
            } else if (input.equals("u")) {
                remote.undoButton();
            } else {
                remote.pressButton(input);
            }
        }

        scanner.close();
    }
}
