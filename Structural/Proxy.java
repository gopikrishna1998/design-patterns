// Subject
interface Image {
    void display();
}

// Real Subject
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading image: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

// Proxy
class ProxyImage implements Image {
    private String filename;
    private RealImage realImage;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

// Client Code
public class ProxyDemo {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("high_res_image1.jpg");
        Image image2 = new ProxyImage("high_res_image2.png");

        // Image will be loaded from disk only when display is called
        image1.display();
        image2.display();
    }
}
