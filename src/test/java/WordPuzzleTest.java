import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class WordPuzzleTest {

  @Test
  public void wordPuzzlerizer_acceptingInput_String() {
    CoinCombinations coinCombo = new CoinCombinations();
    Integer expected = 0;
    expected = expected + 1;
    // System.out.println(expected);
    assertEquals(expected, coinCombo.changeMaker("1"));
  }
