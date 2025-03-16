// Abstract Products
interface Button {
    void render();
}

interface TextBox {
    void display();
}

// Concrete Products (Windows)
class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Windows Button");
    }
}

class WindowsTextBox implements TextBox {
    @Override
    public void display() {
        System.out.println("Displaying Windows TextBox");
    }
}

// Concrete Products (macOS)
class MacOSButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering macOS Button");
    }
}

class MacOSTextBox implements TextBox {
    @Override
    public void display() {
        System.out.println("Displaying macOS TextBox");
    }
}

// Abstract Factory
interface GUIFactory {
    Button createButton();
    TextBox createTextBox();
}

// Concrete Factories
class WindowsGUIFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public TextBox createTextBox() {
        return new WindowsTextBox();
    }
}

class MacOSGUIFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public TextBox createTextBox() {
        return new MacOSTextBox();
    }
}

// Client Code
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        GUIFactory windowsFactory = new WindowsGUIFactory();
        Button windowsButton = windowsFactory.createButton();
        TextBox windowsTextBox = windowsFactory.createTextBox();

        windowsButton.render();
        windowsTextBox.display();

        GUIFactory macOSFactory = new MacOSGUIFactory();
        Button macOSButton = macOSFactory.createButton();
        TextBox macOSTextBox = macOSFactory.createTextBox();

        macOSButton.render();
        macOSTextBox.display();
    }
}
