class Bob {

  public String hey(String phrase) {
    String response = "Whatever.";

    if (isSilence(phrase)) {
      response = "Fine. Be that way!";
    } else if (isShouting(phrase)) {
      response = "Whoa, chill out!";
    } else if (isQuestion(phrase)) {
      response = "Sure.";
    }

    return response;
  }

  private boolean isSilence(String phrase) {
    return phrase.trim().isEmpty();
  }

  private boolean isQuestion(String phrase) {
    return phrase.endsWith("?");
  }

  private boolean isShouting(String phrase) {
    return hasLetter(phrase) && phrase.toUpperCase().equals(phrase);
  }

  private boolean hasLetter(String phrase) {
    return phrase.chars().anyMatch(Character::isLetter);
  }

}
