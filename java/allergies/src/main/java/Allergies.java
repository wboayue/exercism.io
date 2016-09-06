import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Allergies {
  
  private int score;

  public Allergies(int score) {
    this.score = score;
  }

  public boolean isAllergicTo(Allergen allergen) {
    return (allergen.getScore() & this.score) != 0;
  }

  public List getList() {
    return Arrays.stream(Allergen.values())
      .filter(this::isAllergicTo)
      .collect(Collectors.toList());
  }

}