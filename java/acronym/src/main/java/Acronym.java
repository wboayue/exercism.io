import java.util.function.IntPredicate;

public class Acronym {

  public static String generate(String phrase) {
    class LetterFilter implements IntPredicate {
      private int previous = ' ';

      @Override
      public boolean test(int current) {
        int lastCodePoint = previous;
        this.previous = current;

        return (Character.isLetter(current) && !Character.isLetterOrDigit(lastCodePoint))
          || (Character.isUpperCase(current) && Character.isLowerCase(lastCodePoint));
      }
    }

    LetterFilter isPartOfAcronym = new LetterFilter();

    return phrase.codePoints()
      .filter(isPartOfAcronym)
      .map(Character::toUpperCase)
      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
      .toString();
  }

  private static boolean isSignificant(int current, int previous) {
    return (Character.isLetter(current) && !Character.isLetterOrDigit(previous))
      || (Character.isUpperCase(current) && Character.isLowerCase(previous));
  }
}