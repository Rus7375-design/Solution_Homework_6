package SmartHomeRemoteControl;
public class Light {
    private boolean isOn = false;

    public void turnOn() {
        isOn = true;
        System.out.println("[Light] Включено");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("[Light] Выключено");
    }
}

