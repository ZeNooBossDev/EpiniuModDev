import java.util.HashMap;

public class Recipe
{

    public static void start()
    {
        HashMap<String, String> recipeElements = new HashMap<String, String>();

        recipeElements.put("Minerai de Mithril", "Lingot de Mithril");
        recipeElements.put("Mineria d'Or", "Lingot d'Or");




        for (String i : recipeElements.values()) {
            if (i.equals("Lingot de Mithril")) {
                System.out.println("vrai");
                System.out.println(recipeElements.get("Mineria d'Or"));
            }

        }
        System.out.println("faux");
    }







}
