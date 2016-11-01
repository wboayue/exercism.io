import java.util.ArrayList;
import java.util.List;

public class BeerSong {

  public static String verse(int number) {
    return singBottlesOfBeer(number) + singTakeOneDown(number);
  }

  private static String singBottlesOfBeer(int number) {
    return capitalize(singBeerOnWall(number) + ", " + pluralize("bottle", number) + " of beer.\n");
  }

  private static String singBeerOnWall(int count) {
    return String.format("%s of beer on the wall", pluralize("bottle", count));
  }

  public static String sing(int start, int end) {
    List<String> verses = new ArrayList<>();

    for (int verseNumber = start; verseNumber >= end; --verseNumber) {
      verses.add(verse(verseNumber));
    }

    return String.join("", verses);
  }

  public static String singSong() {
    return sing(99, 0);
  }

  private static String singTakeOneDown(int number) {
    switch (number) {
      case 0:
        return "Go to the store and buy some more, 99 bottles of beer on the wall.\n\n";
      case 1:
        return "Take it down and pass it around, no more bottles of beer on the wall.\n\n";
      default:
        return String.format("Take one down and pass it around, %s.\n\n", singBeerOnWall(number - 1));
    }
  }

  private static String capitalize(String sentence) {
    return sentence.substring(0, 1).toUpperCase() + sentence.substring(1);
  }

  private static String pluralize(String word, int count) {
    switch (count) {
      case 0:
        return String.format("no more %ss", word);
      case 1:
        return String.format("1 %s", word);
      default:
        return String.format("%d %ss", count, word);
    }
  }

}