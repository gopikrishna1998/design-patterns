// Subsystem Classes
class PowerSupply {
    public void checkPower() {
        System.out.println("Power supply: Checking power...");
    }
}

class OperatingSystem {
    public void loadOS() {
        System.out.println("Operating system: Loading OS...");
    }
}

class Peripherals {
    public void initializePeripherals() {
        System.out.println("Peripherals: Initializing peripherals...");
    }
}

// Facade
class ComputerFacade {
    private PowerSupply powerSupply;
    private OperatingSystem os;
    private Peripherals peripherals;

    public ComputerFacade() {
        this.powerSupply = new PowerSupply();
        this.os = new OperatingSystem();
        this.peripherals = new Peripherals();
    }

    public void startComputer() {
        System.out.println("Starting computer...");
        powerSupply.checkPower();
        os.loadOS();
        peripherals.initializePeripherals();
        System.out.println("Computer started!");
    }
}

// Client Code
public class ComputerStartupDemo {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.startComputer();
    }
}
