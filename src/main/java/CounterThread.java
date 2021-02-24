import org.apache.log4j.Logger;

public class CounterThread extends Thread {
    private static final int ITERATIONS = 100;
    private static final Logger logger = Logger.getLogger(CounterThread.class);
    private final Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        super.run();
        String threadName = "Thread " + Thread.currentThread().getName();
        logger.info(threadName + " has started");
        while (counter.getCount() < ITERATIONS) {
            int currentIteration = counter.increment();
            logger.info(threadName + " - " + currentIteration);
        }
        logger.info(threadName + " has stopped");
    }
}
