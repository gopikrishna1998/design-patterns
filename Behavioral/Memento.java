import java.util.Deque;
import java.util.LinkedList;

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

// Originator
class TextEditor {
    private String text = "";

    // Internal caretaker for undo history
    private static class EditorHistory {
        private final Deque<EditorMemento> history = new LinkedList<>();

        public void save(EditorMemento memento) {
            history.push(memento);
        }

        public EditorMemento undo() {
            if (history.size() > 1) {
                history.pop(); // remove current state
                return history.peek(); // return previous state
            } else if (history.size() == 1) {
                history.pop();
                return new EditorMemento("");
            }
            return null;
        }

        public boolean hasUndo() {
            return history.size() > 1;
        }
    }

    private final EditorHistory history = new EditorHistory();

    public TextEditor() {
        saveState(); // Save the initial empty state
    }

    public void type(String words) {
        if (!text.isEmpty()) text += " ";
        text += words;
        saveState();
    }

    public void undo() {
        if (history.hasUndo()) {
            EditorMemento previousState = history.undo();
            text = previousState.getText();
        } else {
            System.out.println("Nothing to undo.");
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
public class MementoUndoDemo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.type("Hello");
        editor.type("World");
        System.out.println("Current Text: " + editor.getText());

        editor.undo();
        System.out.println("After 1st Undo: " + editor.getText());

        editor.undo();
        System.out.println("After 2nd Undo: " + editor.getText());

        editor.undo(); // Nothing to undo
        System.out.println("After 3rd Undo (no effect): " + editor.getText());
    }
}
