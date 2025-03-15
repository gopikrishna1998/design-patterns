// Implementor (Device)
interface Device {
    void turnOn();
    void turnOff();
    void setChannel(int channel);
}

// Concrete Implementors (TV, Radio)
class TV implements Device {
    @Override
    public void turnOn() {
        System.out.println("TV: Turning on");
    }

    @Override
    public void turnOff() {
        System.out.println("TV: Turning off");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("TV: Setting channel to " + channel);
    }
}

class Radio implements Device {
    @Override
    public void turnOn() {
        System.out.println("Radio: Turning on");
    }

    @Override
    public void turnOff() {
        System.out.println("Radio: Turning off");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("Radio: Setting frequency to " + channel);
    }
}

// Abstraction (Remote)
abstract class Remote {
    protected Device device;

    protected Remote(Device device) {
        this.device = device;
    }

    public abstract void turnOn();
    public abstract void turnOff();
    public abstract void setChannel(int channel);
}

// Refined Abstraction (BasicRemote, AdvancedRemote)
class BasicRemote extends Remote {
    public BasicRemote(Device device) {
        super(device);
    }

    @Override
    public void turnOn() {
        device.turnOn();
    }

    @Override
    public void turnOff() {
        device.turnOff();
    }

    @Override
    public void setChannel(int channel) {
        device.setChannel(channel);
    }
}

class AdvancedRemote extends Remote {
    public AdvancedRemote(Device device) {
        super(device);
    }

    @Override
    public void turnOn() {
        device.turnOn();
    }

    @Override
    public void turnOff() {
        device.turnOff();
    }

    @Override
    public void setChannel(int channel) {
        device.setChannel(channel);
    }

    public void mute() {
        System.out.println("Remote: Muting device");
    }
}

// Client Code
public class RemoteControlDemo {
    public static void main(String[] args) {
        Device tv = new TV();
        Device radio = new Radio();

        Remote basicTVRemote = new BasicRemote(tv);
        Remote advancedRadioRemote = new AdvancedRemote(radio);

        basicTVRemote.turnOn();
        basicTVRemote.setChannel(5);
        basicTVRemote.turnOff();

        advancedRadioRemote.turnOn();
        advancedRadioRemote.setChannel(98);
        advancedRadioRemote.mute();
        advancedRadioRemote.turnOff();
    }
}
