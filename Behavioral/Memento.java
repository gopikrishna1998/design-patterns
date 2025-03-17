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

    public void type(String words) {
        text += " " + words;
    }

    public EditorMemento save() {
        return new EditorMemento(text);
    }

    public void restore(EditorMemento memento) {
        text = memento.getText();
    }

    public String getText() {
        return text;
    }
}

// Caretaker
class EditorHistory {
    private List<EditorMemento> history = new ArrayList<>();

    public void save(TextEditor editor) {
        history.add(editor.save());
    }

    public EditorMemento restore(int index) {
        if (index >= 0 && index < history.size()) {
            return history.get(index);
        }
        return null;
    }

    public EditorMemento getLastSavedState(){
        if(history.size() > 0){
            return history.get(history.size() - 1);
        }
        return null;
    }
}

// Client Code
public class MementoDemo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        EditorHistory history = new EditorHistory();

        editor.type("Hello");
        history.save(editor);

        editor.type("World");
        history.save(editor);

        System.out.println("Current Text: " + editor.getText());

        editor.restore(history.getLastSavedState());
        System.out.println("After 1st restore: " + editor.getText());

        history.history.remove(history.history.size() - 1); // remove the last saved state.
        editor.restore(history.getLastSavedState());
        System.out.println("After 2nd restore: " + editor.getText());

    }
}
