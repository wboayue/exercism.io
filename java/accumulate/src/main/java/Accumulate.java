import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class Accumulate {

  public static <T> List<T> accumulate(List<T> items, Function<T, T> mapper) {
    List<T> mapped = new LinkedList<>();
    for (T item : items) {
      mapped.add(mapper.apply(item));
    }
    return mapped;
  }

}


