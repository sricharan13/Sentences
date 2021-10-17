package sentence;

/**
 * Represents an empty node in the Sentence List. An empty node indicates the end of a sentence.
 */
public class EmptyNode implements Sentence {

  @Override
  public int getNumberOfWords() {
    return 0;
  }

  @Override
  public String longestWord() {
    return "";
  }

  @Override
  public Sentence merge(Sentence other) {
    return other;
  }

  @Override
  public Sentence clone() {
    return this;
  }

  @Override
  public String toString() {
    return "";
  }

  @Override
  public String sentenceBuilder(StringBuilder sentenceSoFar) {
    return sentenceSoFar.substring(1, sentenceSoFar.length());
  }

  @Override
  public String longestWordFinder(String longestSoFar) {
    return longestSoFar;
  }
}
