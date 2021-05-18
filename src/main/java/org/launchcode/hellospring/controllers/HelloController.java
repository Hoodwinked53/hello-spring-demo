package org.launchcode.hellospring.controllers;

import org.apache.coyote.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    // Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // lives at /hello/goodbye due to above RequestMapping
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // lives at /hello/hello due to above RequestMapping
    // Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // lives at /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                    "<body>" +
                        "<form action = 'hello' method = 'post'>" + // submit a request to /hello
                            "<input type = 'text' name = 'name'>" +
                            "<input type = 'submit' value = 'Greet me!'>" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }

    @RequestMapping(value = "greeting", method = RequestMethod.GET)
    public String greeting() {
        return "<form method = 'post'>" +
                "<input type = 'text' name = 'name'>" +
                "<select name = 'language'>" +
                "<option value = 'english'> English </option>" +
                "<option value = 'french'> French </option>" +
                "<option value = 'italian'> Italian </option>" +
                "<option value = 'spanish'> Spanish </option>" +
                "<option value = 'german'> German </option>" +
                "</select>" +
                "<input type = 'submit' value = 'Greet Me!' />" +
                "</form>";
    }

    @RequestMapping(value = "greeting", method = RequestMethod.POST)
    public static String createMessage(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }

        String message = "";

        if (language.equals("english")) {
            message = "Hello, ";
        } else if (language.equals("french")) {
            message = "Bonjour, ";
        } else if (language.equals("italian")) {
            message = "Ciao, ";
        } else if (language.equals("spanish")) {
            message = "Hola, ";
        } else if (language.equals("german")) {
            message = "Hallo, ";
        }

        return "<p style = 'color: red; text-align: center; margin-top: 20vh'>" + message + name + "</p>";
    }


}
