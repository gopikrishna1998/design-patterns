// Product (Computer)
class Computer {
    private String cpu;
    private String ram;
    private String storage;
    private String graphicsCard;
    private String display;

    public Computer(String cpu, String ram, String storage, String graphicsCard, String display) {
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
        this.graphicsCard = graphicsCard;
        this.display = display;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", storage='" + storage + '\'' +
                ", graphicsCard='" + graphicsCard + '\'' +
                ", display='" + display + '\'' +
                '}';
    }
}

// Builder Interface
interface ComputerBuilder {
    ComputerBuilder setCpu(String cpu);
    ComputerBuilder setRam(String ram);
    ComputerBuilder setStorage(String storage);
    ComputerBuilder setGraphicsCard(String graphicsCard);
    ComputerBuilder setDisplay(String display);
    Computer build();
}

// Concrete Builder
class ConcreteComputerBuilder implements ComputerBuilder {
    private String cpu;
    private String ram;
    private String storage;
    private String graphicsCard;
    private String display;

    @Override
    public ComputerBuilder setCpu(String cpu) {
        this.cpu = cpu;
        return this;
    }

    @Override
    public ComputerBuilder setRam(String ram) {
        this.ram = ram;
        return this;
    }

    @Override
    public ComputerBuilder setStorage(String storage) {
        this.storage = storage;
        return this;
    }

    @Override
    public ComputerBuilder setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
        return this;
    }

    @Override
    public ComputerBuilder setDisplay(String display) {
        this.display = display;
        return this;
    }

    @Override
    public Computer build() {
        return new Computer(cpu, ram, storage, graphicsCard, display);
    }
}

// Director
class ComputerDirector {
    private ComputerBuilder builder;

    public ComputerDirector(ComputerBuilder builder) {
        this.builder = builder;
    }

    public Computer constructGamingComputer() {
        return builder.setCpu("Intel i9")
                .setRam("32GB")
                .setStorage("2TB NVMe SSD")
                .setGraphicsCard("Nvidia RTX 4090")
                .setDisplay("144Hz 4K Monitor")
                .build();
    }

    public Computer constructOfficeComputer() {
        return builder.setCpu("Intel i5")
                .setRam("8GB")
                .setStorage("512GB SSD")
                .setDisplay("Standard 1080p Monitor")
                .build();
    }
}

// Client Code
public class BuilderDirectorDemo {
    public static void main(String[] args) {
        ComputerBuilder builder = new ConcreteComputerBuilder();
        ComputerDirector director = new ComputerDirector(builder);

        Computer gamingComputer = director.constructGamingComputer();
        System.out.println("Gaming Computer: " + gamingComputer);

        Computer officeComputer = director.constructOfficeComputer();
        System.out.println("Office Computer: " + officeComputer);
    }
}
