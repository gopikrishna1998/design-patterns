interface Command {
    void execute();
    void undo(); // Add undo method
}

class Light {
    private boolean isOn = false;

    public void turnOn() {
        isOn = true;
        System.out.println("Light is ON");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Light is OFF");
    }

    public boolean isOn() {
        return isOn;
    }
}

abstract class LightCommandBase implements Command {
    protected Light light;
    protected boolean previousState;

    public LightCommandBase(Light light) {
        this.light = light;
    }

    @Override
    public void undo() {
        if (previousState) {
            light.turnOn();
        } else {
            light.turnOff();
        }
    }
}

class LightOnCommand extends LightCommandBase {

    public LightOnCommand(Light light) {
        super(light);
    }

    @Override
    public void execute() {
        previousState = light.isOn(); // Store previous state
        light.turnOn();
    }
}

class LightOffCommand extends LightCommandBase {

    public LightOffCommand(Light light) {
        super(light);
    }

    @Override
    public void execute() {
        previousState = light.isOn(); // Store previous state
        light.turnOff();
    }
}

import java.util.Stack;

class RemoteControl {
    private Command onCommand;
    private Command offCommand;
    private Stack<Command> history = new Stack<>(); // Stack to store commands

    public void setOnCommand(Command onCommand) {
        this.onCommand = onCommand;
    }

    public void setOffCommand(Command offCommand) {
        this.offCommand = offCommand;
    }

    public void pressOnButton() {
        onCommand.execute();
        history.push(onCommand); // Add command to history
    }

    public void pressOffButton() {
        offCommand.execute();
        history.push(offCommand); // Add command to history
    }

    public void pressUndoButton() {
        if (!history.isEmpty()) {
            Command command = history.pop();
            command.undo();
        }
    }
}

public class CommandUndoDemo {
    public static void main(String[] args) {
        Light light = new Light();

        LightOnCommand onCommand = new LightOnCommand(light);
        LightOffCommand offCommand = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl();
        remote.setOnCommand(onCommand);
        remote.setOffCommand(offCommand);

        remote.pressOnButton(); // Light is ON
        remote.pressOffButton(); // Light is OFF
        remote.pressUndoButton(); // Light is ON (undo)
        remote.pressUndoButton(); // Light is OFF (undo)
    }
}
