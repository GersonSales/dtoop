package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gersonsales on 02/02/17.
 */
@RestController
public class TaskController {

    @RequestMapping("/")
    public String index() {
        return "Hello World";
    }

}
