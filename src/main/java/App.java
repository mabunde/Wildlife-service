import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFileLocation("/public");
//home page
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //tracked animals
        get("/animals", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Endangered> animals = Endangered.all();
            List<Sighting> sightings = Sighting.all();
            model.put("sightings", sightings);
            model.put("animals", animals);
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());

        //animal form submission
        post("/animals/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String animal = request.queryParams("animal");
            String danger = request.queryParams("danger");
            String health = request.queryParams("health");
            String age = request.queryParams("age");
            String location = request.queryParams("location");
            String ranger = request.queryParams("ranger");

            Endangered endangeredAnimal = new Endangered(animal, danger, health, age, location, ranger);
            endangeredAnimal.save();
            Sighting sighting = new Sighting(endangeredAnimal.getId(), location, ranger);
            sighting.save();

            model.put("endangeredAnimal", endangeredAnimal);
            model.put("sighting", sighting);

            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
