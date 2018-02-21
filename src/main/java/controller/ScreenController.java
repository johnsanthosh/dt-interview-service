package controller;


import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin("http://localhost:4200")
@RestController()
@RequestMapping(value = "/screen-service")
public class ScreenController {
    static List<String> screens;

    ScreenController() {
        screens = Stream.of("Screen1", "Screen2").collect(Collectors.toList());
    }

    @CrossOrigin("http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET, value = "/")
    String home() {
        return "Spring Boot Application Running.";
    }

    @CrossOrigin("http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET, value = "/screens")
    List<String> getScreens() {
        return screens;
    }

    @CrossOrigin("http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET, value = "/screens/{id}")
    List<String> getScreen(@PathVariable int id) {
        if (!CollectionUtils.isEmpty(screens)) {
            if (id > 0 && id <= screens.size()) {
                return Arrays.asList(screens.get(id - 1));
            }
        }

        return Arrays.asList("");
    }

}
