package sentence;

/**
 * Represents a word node in the Sentence List. A word node represents a word in sentence.
 */
public final class WordNode implements Sentence {

  private final String word;
  private final Sentence rest;

  /**
   * Creates and returns a new word node.
   * @param word - the word in the sentence.
   * @param rest - rest of the sentence.
   */
  public WordNode(String word, Sentence rest) {
    this.word = word;
    this.rest = rest;
  }

  @Override
  public int getNumberOfWords() {
    return 1 + rest.getNumberOfWords();
  }

  @Override
  public String longestWordFinder(String longestSoFar) {
    if (word.length() > longestSoFar.length()) {
      return rest.longestWordFinder(word);
    }
    return rest.longestWordFinder(longestSoFar);
  }

  @Override
  public String longestWord() {
    return longestWordFinder("");
  }

  @Override
  public Sentence merge(Sentence other) {
    return new WordNode(word, rest.merge(other));
  }

  @Override
  public Sentence clone() {
    return new WordNode(word, rest.clone());
  }

  @Override
  public String toString() {
    return sentenceBuilder(new StringBuilder());
  }

  @Override
  public String sentenceBuilder(StringBuilder sentenceSoFar) {
    return rest.sentenceBuilder(sentenceSoFar.append(" ").append(word));
  }
}
