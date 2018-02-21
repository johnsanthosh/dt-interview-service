package controller;


import model.ScreenModel;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;


@CrossOrigin("http://localhost:4200")
@RestController()
@RequestMapping(value = "/screen-service")
public class ScreenController {
    List<ScreenModel> screens = null;

    void init(HttpSession session) {
        ScreenModel screen1 = new ScreenModel("1", "Screen1");
        ScreenModel screen2 = new ScreenModel("2", "Screen1");

        screens = Arrays.asList(screen1, screen2);
        session.setAttribute("screens", screens);
    }

    @CrossOrigin("http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET, value = "/")
    String home() {
        return "Spring Boot Application Running.";
    }

    @CrossOrigin("http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET, value = "/screens")
    List<ScreenModel> getScreens(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(CollectionUtils.isEmpty(screens)){
            init(session);
        }

        //screens = (List<String>) session.getAttribute("screens");
        return screens;
    }

    @CrossOrigin("http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET, value = "/screens/{id}")
    List<ScreenModel> getScreen(@PathVariable int id, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(CollectionUtils.isEmpty(screens)){
            init(session);
        }

        //screens = (List<String>) session.getAttribute("screens");

        if (!CollectionUtils.isEmpty(screens)) {
            if (id > 0 && id <= screens.size()) {
                return Arrays.asList(screens.get(id - 1));
            }
        }

        return Arrays.asList();
    }

    @CrossOrigin("http://localhost:4200")
    @RequestMapping(method = RequestMethod.POST, value = "/screens")
    void updateScreen(@RequestBody Map<String, String> screen) {
        System.out.println(screen.keySet());
        String id = screen.get("id");
        String content = screen.get("content");
        System.out.println(id + content);
        int idNum = Integer.parseInt(id);

        if (!CollectionUtils.isEmpty(screens)) {
            if (idNum > 0 && idNum <= screens.size()) {
                screens.get(idNum - 1).setContent(content);
            }
        }
    }

}
