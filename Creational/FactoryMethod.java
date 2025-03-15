// Product
interface Document {
    void open();
    void close();
}

// Concrete Products
class PDFDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF document");
    }

    @Override
    public void close() {
        System.out.println("Closing PDF document");
    }
}

class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word document");
    }

    @Override
    public void close() {
        System.out.println("Closing Word document");
    }
}

// Creator
abstract class DocumentCreator {
    public abstract Document createDocument();

    public void operateDocument() {
        Document document = createDocument();
        document.open();
        document.close();
    }
}

// Concrete Creators
class PDFDocumentCreator extends DocumentCreator {
    @Override
    public Document createDocument() {
        return new PDFDocument();
    }
}

class WordDocumentCreator extends DocumentCreator {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

// Client Code
public class FactoryMethodDemo {
    public static void main(String[] args) {
        DocumentCreator pdfCreator = new PDFDocumentCreator();
        DocumentCreator wordCreator = new WordDocumentCreator();

        pdfCreator.operateDocument();
        wordCreator.operateDocument();
    }
}
