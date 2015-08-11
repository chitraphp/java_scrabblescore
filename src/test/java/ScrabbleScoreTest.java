import org.junit.*;
import static org.junit.Assert.*;

public class ScrabbleScoreTest {
  @Test
  public void scoreFor_singleLetter() {
    ScrabbleScore score = new ScrabbleScore();
    Integer expScore = 1;
    assertEquals(expScore, score.getScore("A"));
  }

  @Test
  public void scoreFor_singleLowercaseLetter() {
    ScrabbleScore score = new ScrabbleScore();
    Integer expScore = 1;
    assertEquals(expScore, score.getScore("a"));
  }

  @Test
  public void scoreFor_twoLowercaseLetters() {
    ScrabbleScore score = new ScrabbleScore();
    Integer expScore = 2;
    assertEquals(expScore, score.getScore("an"));
  }

  @Test
  public void scoreFor_oneLowercaseOneUppercase() {
    ScrabbleScore score = new ScrabbleScore();
    Integer expScore = 2;
    assertEquals(expScore, score.getScore("An"));
  }

  @Test
  public void scoreFor_twoUppercaseLetters() {
    ScrabbleScore score = new ScrabbleScore();
    Integer expScore = 2;
    assertEquals(expScore, score.getScore("AN"));
  }

  @Test
  public void scoreFor_threeDifferentValuedLetters() {
    ScrabbleScore score = new ScrabbleScore();
    Integer expScore = 4;
    assertEquals(expScore, score.getScore("and"));
  }

  @Test
  public void scoreFor_wordWithUpperAndLowercaseDifferentValues() {
    ScrabbleScore score = new ScrabbleScore();
    Integer expScore = 16;
    assertEquals(expScore, score.getScore("Zebra"));
  }

  @Test
  public void scoreFor_tenPointLetterAndEightPointLetter() {
    ScrabbleScore score = new ScrabbleScore();
    Integer expScore = 18;
    assertEquals(expScore, score.getScore("jq"));
  }

  @Test
  public void scoreFor_fivePointLetterAndFourPointLetter() {
    ScrabbleScore score = new ScrabbleScore();
    Integer expScore = 9;
    assertEquals(expScore, score.getScore("fk"));
  }

  @Test
  public void scoreFor_threePointLetterAndFourPointLetter() {
    ScrabbleScore score = new ScrabbleScore();
    Integer expScore = 7;
    assertEquals(expScore, score.getScore("bw"));
  }
}
