import java.util.HashMap;
import java.util.Map;

// Flyweight
interface TreeType {
    void draw(int x, int y);
}

// Concrete Flyweight
class ConcreteTreeType implements TreeType {
    private String texture;
    private String color;

    public ConcreteTreeType(String texture, String color) {
        this.texture = texture;
        this.color = color;
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("Drawing tree at (" + x + ", " + y + ") with texture: " + texture + ", color: " + color);
    }
}

// Flyweight Factory
class TreeFactory {
    private static Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String texture, String color) {
        String key = texture + "-" + color;
        TreeType treeType = treeTypes.get(key);

        if (treeType == null) {
            treeType = new ConcreteTreeType(texture, color);
            treeTypes.put(key, treeType);
        }

        return treeType;
    }
}

// Client
class Tree {
    private int x;
    private int y;
    private TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw() {
        type.draw(x, y);
    }
}

// Client Code
public class FlyweightDemo {
    public static void main(String[] args) {
        TreeType oakType = TreeFactory.getTreeType("OakTexture", "Green");
        TreeType pineType = TreeFactory.getTreeType("PineTexture", "DarkGreen");

        Tree tree1 = new Tree(10, 10, oakType);
        Tree tree2 = new Tree(20, 20, oakType);
        Tree tree3 = new Tree(30, 30, pineType);
        Tree tree4 = new Tree(40, 40, pineType);

        tree1.draw();
        tree2.draw();
        tree3.draw();
        tree4.draw();
    }
}
