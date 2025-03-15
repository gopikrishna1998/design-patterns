// Component
interface Coffee {
    String getDescription();
    double getCost();
}

// Concrete Component
class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple coffee";
    }

    @Override
    public double getCost() {
        return 1.0;
    }
}

// Decorator
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }
}

// Concrete Decorator - Milk
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with milk";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.2;
    }
}

// Concrete Decorator - Sugar
class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with sugar";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.1;
    }
}

// Client Code
public class DecoratorDemo {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println("Description: " + coffee.getDescription());
        System.out.println("Cost: $" + coffee.getCost());

        Coffee milkCoffee = new MilkDecorator(coffee);
        System.out.println("Description: " + milkCoffee.getDescription());
        System.out.println("Cost: $" + milkCoffee.getCost());

        Coffee sugarMilkCoffee = new SugarDecorator(milkCoffee);
        System.out.println("Description: " + sugarMilkCoffee.getDescription());
        System.out.println("Cost: $" + sugarMilkCoffee.getCost());
    }
}
