import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenerationUtil {
    public static final Integer DEFAULT_LIMIT = 1_000_000;

    public static List<Integer> generateList() {
        return Stream.iterate(1, n -> n).limit(DEFAULT_LIMIT).collect(Collectors.toList());
    }

    public static List<Integer> generateList(int limit) {
        return Stream.iterate(1, n -> n).limit(limit).collect(Collectors.toList());
    }
}
