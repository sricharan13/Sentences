import static org.junit.Assert.assertEquals;

import org.junit.Test;
import sentence.EmptyNode;
import sentence.PunctuationNode;
import sentence.Sentence;
import sentence.WordNode;

/**
 * tests for Sentence interface.
 */
public class SentenceTest {

  // empty sentence
  Sentence s1;
  // sentence with only words
  Sentence s2;
  // sentence with words and punctuations
  Sentence s3;
  // sentence with words and punctuations
  Sentence s4;


  private void initializeSentences() {
    s1 = new EmptyNode();
    s2 = new WordNode("Hi", new WordNode("World", new EmptyNode()));
    s3 = new WordNode("Hello", new PunctuationNode(";", new WordNode("World", new EmptyNode())));
    s4 = new WordNode("Hi", new WordNode("World", new PunctuationNode(",", new EmptyNode())));
  }

  /**
   * test the validity of function - getNumberOfWords().
   */
  @Test
  public void testGetNumberOfWords() {
    initializeSentences();
    assertEquals(0, s1.getNumberOfWords());
    assertEquals(2, s2.getNumberOfWords());
    assertEquals(2, s3.getNumberOfWords());
  }

  /**
   * test the validity of function - longestWord().
   */
  @Test
  public void testLongestWord() {
    initializeSentences();
    assertEquals("", s1.longestWord());
    assertEquals("World", s2.longestWord());
    assertEquals("Hello", s3.longestWord());
  }

  /**
   * test the validity of function - merge().
   */
  @Test
  public void testMerge() {
    initializeSentences();
    Sentence merged = s1.merge(s2);
    assertEquals("Hi World", merged.toString());
    merged = s4.merge(s2);
    assertEquals("Hi World, Hi World", merged.toString());
    merged = s2.merge(s3);
    assertEquals("Hi World Hello; World", merged.toString());
  }

  /**
   * test the validity of function - testClone().
   */
  @Test
  public void testClone() {
    initializeSentences();
    Sentence cloned = s1.clone();
    assertEquals(0, cloned.getNumberOfWords());
    assertEquals("", cloned.longestWord());
    cloned = s2.clone();
    assertEquals(2, cloned.getNumberOfWords());
    assertEquals("World", cloned.longestWord());
    cloned = s3.clone();
    assertEquals(2, cloned.getNumberOfWords());
    assertEquals("Hello", cloned.longestWord());
  }

  /**
   * test the validity of function - testToString().
   */
  @Test
  public void testToString() {
    initializeSentences();
    assertEquals("", s1.toString());
    assertEquals("Hi World", s2.toString());
    assertEquals("Hello; World", s3.toString());
    assertEquals("Hi World,", s4.toString());
  }

}