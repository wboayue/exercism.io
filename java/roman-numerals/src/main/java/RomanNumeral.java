import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class RomanNumeral {

  private int number;
  private static Map<Integer, String> NUMBER_MAP = buildNumberMap();

  public RomanNumeral(int number) {
    this.number = number;
  }

  public String getRomanNumeral() {
    StringBuilder romanNumeral = new StringBuilder();

    int remainingArabic = this.number;

    for (Map.Entry<Integer, String> entry : NUMBER_MAP.entrySet()) {
      int factor = entry.getKey();
      String roman = entry.getValue();

      romanNumeral.append(repeat(roman, remainingArabic / factor));
      remainingArabic = remainingArabic % factor;
    }

    return romanNumeral.toString();
  }

  private String repeat(String s, int n) {
    return String.join("", Collections.nCopies(n, s));
  }

  private static Map<Integer, String> buildNumberMap() {
    Map<Integer, String> mapping = new TreeMap<>(Comparator.reverseOrder());
    mapping.put(1000, "M");
    mapping.put(900, "CM");
    mapping.put(500, "D");
    mapping.put(400, "CD");
    mapping.put(100, "C");
    mapping.put(90, "XC");
    mapping.put(50, "L");
    mapping.put(40, "XL");
    mapping.put(10, "X");
    mapping.put(9, "IX");
    mapping.put(5, "V");
    mapping.put(4, "IV");
    mapping.put(1, "I");
    return mapping;
  }

}
