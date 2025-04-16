package SmartHomeRemoteControl;

public class SetThermostatCommand implements Command {

    private final Thermostat thermostat;
    private final int newTemperature;
    private int previousTemperature;

    public SetThermostatCommand(Thermostat thermostat, int newTemperature) {
        this.thermostat = thermostat;
        this.newTemperature = newTemperature;
    }

    @Override
    public void execute() {
        previousTemperature = thermostat.getTemperature();
        thermostat.setTemperature(newTemperature);
    }

    @Override
    public void undo() {
        System.out.println("[Thermostat] Возврат к предыдущей температуре: " + previousTemperature + "°C");
        thermostat.setTemperature(previousTemperature);
    }
}

