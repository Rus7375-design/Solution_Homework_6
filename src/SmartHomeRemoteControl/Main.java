package SmartHomeRemoteControl;
public class Main {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();
        Command lightOn = new TurnOnLightCommand(livingRoomLight);
        SmartHomeRemoteControl remote = new SmartHomeRemoteControl();
        remote.setCommand("light_on", lightOn);
        System.out.println("▶ Нажатие кнопки: light_on");
        remote.pressButton("light_on");
        System.out.println("▶ Отмена последней команды");
        remote.undoButton();
    }
}

