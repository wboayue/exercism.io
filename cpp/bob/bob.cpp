#include "bob.h"
#include <iostream>
#include <regex>
#include <boost/algorithm/string.hpp>

namespace bob {

  bool is_question(const std::string& sentence);
  bool is_number_only(const std::string& sentence);
  bool is_shout(const std::string& sentence);
  bool is_silence(const std::string& sentence);

  std::string hey(const std::string& sentence) {
    std::string response { "Whatever." };
    std::string trimmed_sentence { boost::algorithm::trim_copy(sentence) };

    if (is_silence(trimmed_sentence)) {
      response = "Fine. Be that way!";
    } else if (is_shout(trimmed_sentence)) {
      response = "Whoa, chill out!";
    } else if (is_question(trimmed_sentence)) {
      response = "Sure.";
    } 

    return response;
  }

  bool is_question(const std::string& sentence) {
    return sentence.back() == '?';
  }

  bool is_number_only(const std::string& sentence) {
    static const std::regex number_regex { "[0-9? ,]+" };

    return std::regex_match(sentence, number_regex);
  }

  bool is_shout(const std::string& sentence) {
    return !is_number_only(sentence) && boost::to_upper_copy<std::string>(sentence) == sentence;
  }

  bool is_silence(const std::string& sentence) {
    return sentence == "";
  }

}