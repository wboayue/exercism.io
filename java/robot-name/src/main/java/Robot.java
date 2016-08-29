import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.Random;
import java.util.stream.Collectors;

class Robot {
  
  private static final RandomNames names = new RandomNames();
  private String name;

  public Robot() {
    reset();
  }

  public String getName() {
    return this.name;
  }

  public void reset() {
    this.name = this.names.next();
  }

  private static class RandomNames implements Iterator<String> {

    private Random random = new Random();
    private Set<String> generatedNames = new TreeSet<String> ();

    public String next() {
      String nextName;

      do {
        nextName = String.format("%s%s", letters(), digits());
      } while (!generatedNames.add(nextName));

      return nextName;
    }

    public boolean hasNext() {
      return true;
    }

    private String digits() {
      return this.random.ints(0, 10)
        .limit(3)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining());
    }

    private String letters() {
      return this.random.ints(0, 26)
        .limit(2)
        .mapToObj(i -> String.format("%c", 'A' + i))
        .collect(Collectors.joining());
    }

  }
}
