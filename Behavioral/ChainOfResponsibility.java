// Handler
abstract class SupportHandler {
    protected SupportHandler nextHandler;

    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleRequest(String issueType) {
        if (canHandle(issueType)) {
            process(issueType);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(issueType);
        } else {
            System.out.println("Issue \"" + issueType + "\" could not be handled.");
        }
    }

    protected abstract boolean canHandle(String issueType);
    protected abstract void process(String issueType);
}

// Concrete Handlers
class Level1Support extends SupportHandler {
    @Override
    protected boolean canHandle(String issueType) {
        return issueType.equalsIgnoreCase("faq");
    }

    @Override
    protected void process(String issueType) {
        System.out.println("✅ Level 1 handled the issue: " + issueType);
    }
}

class Level2Support extends SupportHandler {
    @Override
    protected boolean canHandle(String issueType) {
        return issueType.equalsIgnoreCase("configuration");
    }

    @Override
    protected void process(String issueType) {
        System.out.println("✅ Level 2 handled the issue: " + issueType);
    }
}

class Level3Support extends SupportHandler {
    @Override
    protected boolean canHandle(String issueType) {
        return issueType.equalsIgnoreCase("critical");
    }

    @Override
    protected void process(String issueType) {
        System.out.println("✅ Level 3 handled the issue: " + issueType);
    }
}

// Client Code
public class SupportChainDemo {
    public static void main(String[] args) {
        // Create handlers
        SupportHandler level1 = new Level1Support();
        SupportHandler level2 = new Level2Support();
        SupportHandler level3 = new Level3Support();

        // Set up the chain
        level1.setNextHandler(level2);
        level2.setNextHandler(level3);

        // Send requests through the chain
        level1.handleRequest("faq");           // Handled by Level 1
        level1.handleRequest("configuration"); // Handled by Level 2
        level1.handleRequest("critical");      // Handled by Level 3
        level1.handleRequest("billing");       // Unhandled
    }
}
