import java.util.ArrayList;
import java.util.List;

// Memento
class EditorMemento {
    private final String text;

    public EditorMemento(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

// Originator with internal history
class TextEditor {
    private String text = "";

    // Caretaker (internal)
    private static class EditorHistory {
        private final List<EditorMemento> history = new ArrayList<>();

        public void save(EditorMemento memento) {
            history.add(memento);
        }

        public EditorMemento undo() {
            if (history.size() > 1) {
                history.remove(history.size() - 1);
                return history.get(history.size() - 1);
            } else if (history.size() == 1) {
                history.remove(0);
                return new EditorMemento("");
            }
            return null;
        }

        public boolean hasHistory() {
            return !history.isEmpty();
        }
    }

    private final EditorHistory history = new EditorHistory();

    public TextEditor() {
        saveState(); // Save initial empty state
    }

    public void type(String words) {
        text += " " + words;
        saveState();
    }

    public void undo() {
        EditorMemento previousState = history.undo();
        if (previousState != null) {
            text = previousState.getText();
        }
    }

    private void saveState() {
        history.save(new EditorMemento(text));
    }

    public String getText() {
        return text;
    }
}

// Client
public class MementoDemo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.type("Hello");
        editor.type("World");

        System.out.println("Current Text: " + editor.getText());

        editor.undo();
        System.out.println("After 1st undo: " + editor.getText());

        editor.undo();
        System.out.println("After 2nd undo: " + editor.getText());

        editor.undo(); // nothing to undo now
        System.out.println("After 3rd undo (no effect): " + editor.getText());
    }
}
