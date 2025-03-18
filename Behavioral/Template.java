// Abstract Class (Template)
abstract class HouseBuilder {
    // Template Method
    public final void buildHouse() {
        buildFoundation();
        buildWalls();
        buildRoof();
        buildInterior();
        System.out.println("House built!");
    }

    // Abstract Methods
    protected abstract void buildFoundation();
    protected abstract void buildWalls();
    protected abstract void buildRoof();
    protected abstract void buildInterior();
}

// Concrete Classes (Subclasses)
class WoodenHouseBuilder extends HouseBuilder {
    @Override
    protected void buildFoundation() {
        System.out.println("Building wooden foundation.");
    }

    @Override
    protected void buildWalls() {
        System.out.println("Building wooden walls.");
    }

    @Override
    protected void buildRoof() {
        System.out.println("Building wooden roof.");
    }

    @Override
    protected void buildInterior() {
        System.out.println("Building wooden interior.");
    }
}

class BrickHouseBuilder extends HouseBuilder {
    @Override
    protected void buildFoundation() {
        System.out.println("Building brick foundation.");
    }

    @Override
    protected void buildWalls() {
        System.out.println("Building brick walls.");
    }

    @Override
    protected void buildRoof() {
        System.out.println("Building brick roof.");
    }

    @Override
    protected void buildInterior() {
        System.out.println("Building brick interior.");
    }
}

// Client Code
public class TemplateDemo {
    public static void main(String[] args) {
        HouseBuilder woodenHouseBuilder = new WoodenHouseBuilder();
        woodenHouseBuilder.buildHouse();

        HouseBuilder brickHouseBuilder = new BrickHouseBuilder();
        brickHouseBuilder.buildHouse();
    }
}
