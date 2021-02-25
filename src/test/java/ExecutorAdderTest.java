import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ExecutorAdderTest {
    private static final String INCORRECT_NUM_THREADS_MSG =
            "Exception expected with incorrect number of threads";
    private static List<Integer> integers;

    @BeforeAll
    public static void beforeAll() {
        integers = GenerationUtil.generateList();
    }

    @Test
    public void getSum_Ok() {
        assertEquals(1_000_000, ExecutorAdder.getSum(integers, 4));
        assertEquals(1_000_000, ExecutorAdder.getSum(integers, 5));
        assertEquals(1_000_000, ExecutorAdder.getSum(integers, 45));
        assertEquals(1_000_000, ExecutorAdder.getSum(integers, 10));
        assertEquals(1_000_000, ExecutorAdder.getSum(integers, 444));
        assertEquals(1_000_000, ExecutorAdder.getSum(integers, 999));
    }

    @Test
    public void getSum_NotOk() {
        assertThrows(RuntimeException.class, ()
                        -> ExecutorAdder.getSum(integers, 0), INCORRECT_NUM_THREADS_MSG);
        assertThrows(RuntimeException.class, ()
                        -> ExecutorAdder.getSum(integers, -100), INCORRECT_NUM_THREADS_MSG);
        assertThrows(RuntimeException.class, ()
                        -> ExecutorAdder.getSum(integers, 19423940), INCORRECT_NUM_THREADS_MSG);
    }
}
