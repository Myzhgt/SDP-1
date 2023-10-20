public class Singleton {
    private static Singleton instance;

    // Private constructor to prevent instantiation from other classes
    private Singleton() {
    }

    // Public method to get the instance of Singleton
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Add a method to demonstrate Singleton functionality
    public void showMessage() {
        System.out.println("Singleton is working.");
    }
}
