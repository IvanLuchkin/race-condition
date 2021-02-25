import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinAdder extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 100_000;
    private final List<Integer> integers;

    public ForkJoinAdder(List<Integer> integers) {
        this.integers = integers;
    }

    @Override
    protected Integer compute() {
        if (integers.size() > THRESHOLD) {
            return ForkJoinTask.invokeAll(createSubtasks())
                    .stream()
                    .mapToInt(ForkJoinTask::join)
                    .sum();
        }
        return process();
    }

    private Collection<ForkJoinAdder> createSubtasks() {
        List<ForkJoinAdder> dividedTasks = new ArrayList<>();
        dividedTasks.add(new ForkJoinAdder(integers.subList(0, integers.size() / 2)));
        dividedTasks.add(new ForkJoinAdder(integers.subList(integers.size() / 2, integers.size())));
        return dividedTasks;
    }

    private Integer process() {
        return integers.stream().reduce(0, Integer::sum);
    }
}
