import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ForkJoinAdderTest {
    private static List<Integer> integers;
    private static List<Integer> halfIntegers;
    private static ForkJoinPool forkJoinPool;

    @BeforeAll
    public static void beforeAll() {
        forkJoinPool = ForkJoinPool.commonPool();
        integers = GenerationUtil.generateList();
        halfIntegers = GenerationUtil.generateList(500_000);
    }

    @Test
    public void getSum_Ok() {
        assertEquals(0, forkJoinPool.invoke(new ForkJoinAdder(new ArrayList<>())));
        assertEquals(1_000_000, forkJoinPool.invoke(new ForkJoinAdder(integers)));
        assertEquals(500_000,
                forkJoinPool.invoke(new ForkJoinAdder(halfIntegers)));
    }
}
