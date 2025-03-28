// Prototype Interface (Using Generics)
interface Shape<T extends Shape<T>> {
    T clone();
    void draw();
}

// Concrete Prototypes
class Circle implements Shape<Circle>, Cloneable {
    private int x;
    private int y;
    private int radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public Circle clone() {
        try {
            return (Circle) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null; // Or throw a RuntimeException
        }
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle at (" + x + ", " + y + ") with radius " + radius);
    }

    // Setters for changing field values
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}

// Client Code
public class PrototypeDemo {
    public static void main(String[] args) {
        // Create prototypes
        Circle circlePrototype = new Circle(10, 20, 30);

        // Clone prototypes to create new shapes
        Circle circle1 = circlePrototype.clone();

        // Modify field values of cloned objects
        circle1.setX(50);
        circle1.setRadius(15);

        // Draw the modified cloned shapes
        circle1.draw();
    }
}
