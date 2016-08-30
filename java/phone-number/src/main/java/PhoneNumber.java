import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {
  
  private String areaCode = "000";
  private String prefix = "000";
  private String number = "0000";

  public PhoneNumber(String raw) {
    parse(raw);
  }

  public String getAreaCode() {
    return this.areaCode;
  }

  public String getNumber() {
    return String.format("%s%s%s", this.areaCode, this.prefix, this.number);
  }

  public String pretty() {
    return String.format("(%s) %s-%s", this.areaCode, this.prefix, this.number);
  }

  private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("1?(\\d{3})(\\d{3})(\\d{4})");

  private void parse(String raw) {
    String digits = raw.replaceAll("[^\\d]", "");
    Matcher m = PHONE_NUMBER_PATTERN.matcher(digits);

    if (m.matches()) {
      this.areaCode = m.group(1);
      this.prefix = m.group(2);
      this.number = m.group(3);
    }
  }

}