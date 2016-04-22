import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.lang.Object;
import java.lang.String;
import spark.ModelAndView;
import static java.lang.System.out;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.Random;

public class WordPuzzle {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/outputPage", (request, reponse) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/outputPage.vtl");

      String inputString = request.queryParams("THEPUZZLINATOR");
      String output = wordPuzzlerizer(inputString);


      model.put("output", output);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }


  public static String wordPuzzlerizer(String inputString) {
    String toBePuzzle = inputString;
    String puzzle = toBePuzzle.replace('a','-');
    puzzle = puzzle.replace('A','-');
    puzzle = puzzle.replace('e','-');
    puzzle = puzzle.replace('E','-');
    puzzle = puzzle.replace('i','-');
    puzzle = puzzle.replace('I','-');
    puzzle = puzzle.replace('o','-');
    puzzle = puzzle.replace('O','-');
    puzzle = puzzle.replace('u','-');
    puzzle = puzzle.replace('U','-');
    System.out.println("StringOut: " + puzzle);
    return puzzle;
  }
}
