public class SingletonClient {
    public static void main(String[] args) {
        // Create multiple threads to access the Singleton instance concurrently
        Thread thread1 = new Thread(() -> {
            Singleton singleton = Singleton.getInstance();
            singleton.showMessage();
        });

        Thread thread2 = new Thread(() -> {
            Singleton singleton = Singleton.getInstance();
            singleton.showMessage();
        });

        // Start the threads
        thread1.start();
        thread2.start();
    }
}
