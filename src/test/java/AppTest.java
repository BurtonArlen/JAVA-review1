import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void getPuzzle() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Enter a word or sentence to PUZZLEATORIZE");
  }

  @Test
  public void UserPuzzleFunction() {
    goTo("http://localhost:4567");
    fill("#THEPUZZLINATOR").with("These are words, these words also have punctuation.");
    submit(".btn");
    assertThat(pageSource()).contains("Th-s- -r- w-rds, th-s- w-rds -ls- h-v- p-nct--t--n.");
  }

  @Test
  public void UserPuzzleLoser() {
    goTo("http://localhost:4567");
    fill("#THEPUZZLINATOR").with("Words of wisdom");
    submit(".btn");
    fill("#THEANSWERIZER").with("Wirds af wosdam");
    submit("#lockIn");
    assertThat(pageSource()).contains("YOU ARE A LOSER!");
  }

  @Test
  public void UserPuzzleWinner() {
    goTo("http://localhost:4567");
    fill("#THEPUZZLINATOR").with("Words of wisdom");
    submit(".btn");
    fill("#THEANSWERIZER").with("Words of wisdom");
    submit("#lockIn");
    assertThat(pageSource()).contains("OH, WOW, SUCH MASTERY OF THE ART OF THE LOST VOWEL! IVE NEVER SEEN SUCH INCREDIBLE SKILL! YOU MUST BE SOME SORT OF WIZARD!");
  }
}
