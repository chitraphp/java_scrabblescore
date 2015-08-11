import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import java.util.Map;



public class ScrabbleScore {
    public static void main(String[] args) {
        String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap model = new HashMap();

      model.put("template","templates/scrabblescore.vtl");
      return new ModelAndView(model, layout);

    }, new VelocityTemplateEngine());

    get("/scoreDisplay", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/scoreDisplay.vtl");

      String userInput = request.queryParams("userInput");
      Integer userOutput = getScore(userInput);

      model.put("userOutput", userOutput);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    }

        public static Integer getScore(String word) {

            Integer score = 0;
            HashMap<Character, Integer> letterValues = new HashMap<Character, Integer>();

            letterValues.put('A', 1);
            letterValues.put('E', 1);
            letterValues.put('I', 1);
            letterValues.put('O', 1);
            letterValues.put('U', 1);
            letterValues.put('L', 1);
            letterValues.put('N', 1);
            letterValues.put('R', 1);
            letterValues.put('S', 1);
            letterValues.put('T', 1);
            letterValues.put('D', 2);
            letterValues.put('G', 2);
            letterValues.put('B', 3);letterValues.put('C', 3);letterValues.put('M', 3);letterValues.put('P', 3);
            letterValues.put('F', 4);letterValues.put('H', 4);letterValues.put('V', 4);letterValues.put('W', 4);letterValues.put('Y', 4);
            letterValues.put('K', 5);
            letterValues.put('J', 8);letterValues.put('X', 8);
            letterValues.put('Q', 10);letterValues.put('Z', 10);

            char[] wordChars = word.toCharArray();
            for (char letter : wordChars ) {
                letter = Character.toUpperCase(letter);
                Integer value = letterValues.get(letter);
                score = score + value;

            }

            return score;
        }
}
