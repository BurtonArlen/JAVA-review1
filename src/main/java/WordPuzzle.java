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
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/outputPage", (request, reponse) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/outputPage.vtl");

      String inputString = request.queryParams("inputValue");
      ArrayList<String> output = wordPuzzlerizer(inputString);


      model.put("output", output);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }


  public static ArrayList<String> wordPuzzlerizer(String inputString) {
    String toBePuzzle = inputString;
    ArrayList<String> daStringerator = new ArrayList<String>();
    daStringerator.add(toBePuzzle);
    System.out.println("ArrayString: " + daStringerator);
    return daStringerator;
  }
}



    // Integer index = 0;
    // some form of string split
    // ArrayList<String> daStringerator = new ArrayList<String>();
    // ArrayList<char> getPrimative = new ArrayList<char>();
    // getPrimative.add(daStringerator.get(index));
    // String stringPuzzlated = "";
