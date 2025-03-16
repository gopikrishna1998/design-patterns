// Handler
abstract class Logger {
    protected Logger nextLogger;
    protected int level;

    public Logger(int level) {
        this.level = level;
    }

    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
            return;
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    abstract protected void write(String message);

    public static final int DEBUG = 1;
    public static final int INFO = 2;
    public static final int ERROR = 3;
}

// Concrete Handlers
class DebugLogger extends Logger {
    public DebugLogger(int level) {
        super(level);
    }

    @Override
    protected void write(String message) {
        System.out.println("Debug Logger: " + message);
    }
}

class InfoLogger extends Logger {
    public InfoLogger(int level) {
        super(level);
    }

    @Override
    protected void write(String message) {
        System.out.println("Info Logger: " + message);
    }
}

class ErrorLogger extends Logger {
    public ErrorLogger(int level) {
        super(level);
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Logger: " + message);
    }
}

// Client Code
public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        Logger debugLogger = new DebugLogger(Logger.DEBUG);
        Logger infoLogger = new InfoLogger(Logger.INFO);
        Logger errorLogger = new ErrorLogger(Logger.ERROR);

        debugLogger.setNextLogger(infoLogger);
        infoLogger.setNextLogger(errorLogger);

        Logger loggerChain = debugLogger; // Start the chain

        loggerChain.logMessage(Logger.DEBUG, "This is a debug message.");
        loggerChain.logMessage(Logger.INFO, "This is an info message.");
        loggerChain.logMessage(Logger.ERROR, "This is an error message.");
    }
}
