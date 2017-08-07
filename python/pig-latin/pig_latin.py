import re

def translate(phrase):
    return ' '.join(translate_word(word) for word in phrase.split())

def translate_word(word):
    if not starts_with_vowel(word):
        word = rotate(word)

    return '{}ay'.format(word)

def starts_with_vowel(word):
    return re.match(r"^([aeiuo]|yt|xr).*", word)

def rotate(word):
    match = re.match(r"^(sch|thr|\w?qu|ch|th|\w)(.*)", word)
    return '{}{}'.format(match.group(2), match.group(1))
