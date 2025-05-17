public final class Singleton {
    
    // volatile is used so that reordering of the instructions is not done and
    // variables are read and written directly to memory.

    private static volatile Singleton instance;

    public String value;

    private Singleton(String value) {
        this.value = value;
    }

    public static Singleton getInstance(String value) {

        // local variable is used because reading a volatile variable
        // is more expensive than reading a local variable.

        Singleton result = instance;
        if (result != null) {
            return result;
        }

        // synchronized used to ensure only one thread creates the Singleton instance.

        synchronized(Singleton.class) {
            
            // Multiple threads could pass the first if (result != null) check.
            // When they reach the synchronized block, they must check again to see if the instance is still null.
            
            if (instance == null) {
                instance = new Singleton(value);
            }
            return instance;
        }
    }
}
