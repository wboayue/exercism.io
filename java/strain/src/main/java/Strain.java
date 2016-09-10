import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Strain {

  public static <T> List<T> discard(List<T> items, Predicate<T> predicate) {
    return keep(items, predicate.negate());
  }

  public static <T> List<T> keep(List<T> items, Predicate<T> predicate) {
    List<T> filtered = new ArrayList<>();
    for (T item : items) {
      if (predicate.test(item)) {
        filtered.add(item);
      }
    }
    return filtered;
  }

}
