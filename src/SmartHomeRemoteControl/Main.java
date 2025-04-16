package SmartHomeRemoteControl;

public class Main {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();
        Thermostat thermostat = new Thermostat();

        Command lightOn = new TurnOnLightCommand(livingRoomLight);
        Command setTemp = new SetThermostatCommand(thermostat, 22);

        SmartHomeRemoteControl remote = new SmartHomeRemoteControl();
        remote.setCommand("light_on", lightOn);
        remote.setCommand("set_temp", setTemp);

        System.out.println("▶ Включаем свет");
        remote.pressButton("light_on");

        System.out.println("▶ Устанавливаем температуру");
        remote.pressButton("set_temp");

        System.out.println("▶ Отмена последней команды");
        remote.undoButton();

        System.out.println("▶ Отмена ещё одной команды");
        remote.undoButton();
    }
}
