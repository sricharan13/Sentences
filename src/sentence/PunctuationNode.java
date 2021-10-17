package sentence;

/**
 * Represents a punctuation node in the Sentence List. A punctuation node
 * indicates a punctuation in sentence.
 */
public class PunctuationNode implements Sentence {

  private final String punctuation;
  private final Sentence rest;

  /**
   * Creates and returns a new punctuation node.
   * @param punctuation - punctuation in the sentence.
   * @param rest - rest of the sentence.
   */
  public PunctuationNode(String punctuation, Sentence rest) {
    this.punctuation = punctuation;
    this.rest = rest;
  }

  @Override
  public int getNumberOfWords() {
    return rest.getNumberOfWords();
  }

  @Override
  public String longestWord() {
    return rest.longestWord();
  }

  @Override
  public Sentence merge(Sentence other) {
    return new PunctuationNode(punctuation, rest.merge(other));
  }

  @Override
  public Sentence clone() {
    return new PunctuationNode(punctuation, rest.clone());
  }

  @Override
  public String toString() {
    return sentenceBuilder(new StringBuilder());
  }

  @Override
  public String sentenceBuilder(StringBuilder sentenceSoFar) {
    return rest.sentenceBuilder(sentenceSoFar.append(punctuation));
  }

  @Override
  public String longestWordFinder(String longestSoFar) {
    return rest.longestWordFinder(longestSoFar);
  }
}
