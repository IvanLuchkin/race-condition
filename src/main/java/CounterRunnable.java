import org.apache.log4j.Logger;

public class CounterRunnable implements Runnable {
    private static final int ITERATIONS = 100;
    private static final Logger logger = Logger.getLogger(CounterRunnable.class);
    private final Counter counter;

    public CounterRunnable(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        String runnableThreadName = "Runnable " + Thread.currentThread().getName();
        logger.info(runnableThreadName + " has started");
        while (counter.getCount() < ITERATIONS) {
            int currentIteration = counter.increment();
            logger.info(runnableThreadName + " - " + currentIteration);
        }
        logger.info(runnableThreadName + " has stopped");
    }
}
