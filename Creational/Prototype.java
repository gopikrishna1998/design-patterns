// Prototype Interface
interface Shape {
    Shape clone();
    void draw();
}

// Concrete Prototype
class Circle implements Shape, Cloneable {
    private int x;
    private int y;
    private int radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Circle(Circle source) { // Copy Constructor
        this.x = source.x;
        this.y = source.y;
        this.radius = source.radius;
    }

    @Override
    public Shape clone() {
        return new Circle(this); // Using copy constructor
    }

    @Override
    public void draw() {
        System.out.println("Drawing circle at (" + x + ", " + y + ") with radius " + radius);
    }
}

// Client Code
public class PrototypeDemo {
    public static void main(String[] args) {
        Circle originalCircle = new Circle(10, 10, 5);
        originalCircle.draw();

        Shape clonedCircle = originalCircle.clone();
        clonedCircle.draw();

        // Modify the cloned circle
        Circle circle = (Circle) clonedCircle; // cast to access Circle fields
        circle.x = 20;
        circle.y = 20;
        circle.radius = 8;

        clonedCircle.draw(); // cloned circle has the new values

        originalCircle.draw(); // original circle is unchanged.
    }
}
