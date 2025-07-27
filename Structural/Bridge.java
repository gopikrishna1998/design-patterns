// Implementor (Device)
interface Device {
    void turnOn();
    void turnOff();
    void setChannel(int channel);
    void setVolume(int volume);
}

abstract class AbstractDevice implements Device {
    protected int volume = 50;

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println(getClass().getSimpleName() + ": Volume set to " + volume);
    }
}

// Concrete Implementors (TV, Radio)
class TV extends AbstractDevice {
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

class Radio extends AbstractDevice {
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

class AdvancedRemote extends BasicRemote {
    public AdvancedRemote(Device device) {
        super(device);
    }

    public void mute() {
        System.out.println("Remote: Muting device");
        device.setVolume(0);
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
