public class Handler {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread runnableThread = new Thread(new CounterRunnable(counter));
        Thread counterThread = new CounterThread(counter);
        runnableThread.start();
        counterThread.start();
    }
}
