import java.util.ArrayList;
import java.util.List;

// Component
abstract class FileSystemComponent {
    protected String name;

    public FileSystemComponent(String name) {
        this.name = name;
    }

    public abstract void display();
}

// Leaf
class File extends FileSystemComponent {
    public File(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("File: " + name);
    }
}

// Composite
class Directory extends FileSystemComponent {
    private List<FileSystemComponent> children = new ArrayList<>();

    public Directory(String name) {
        super(name);
    }

    public void add(FileSystemComponent component) {
        children.add(component);
    }

    public void remove(FileSystemComponent component) {
        children.remove(component);
    }

    @Override
    public void display() {
        System.out.println("Directory: " + name);
        for (FileSystemComponent component : children) {
            component.display();
        }
    }
}

// Client Code
public class CompositeDemo {
    public static void main(String[] args) {
        File file1 = new File("document.txt");
        File file2 = new File("image.jpg");
        File file3 = new File("video.mp4");

        Directory subDirectory1 = new Directory("SubFolder1");
        subDirectory1.add(file1);
        subDirectory1.add(file2);

        Directory rootDirectory = new Directory("Root");
        rootDirectory.add(subDirectory1);
        rootDirectory.add(file3);

        rootDirectory.display();
    }
}
