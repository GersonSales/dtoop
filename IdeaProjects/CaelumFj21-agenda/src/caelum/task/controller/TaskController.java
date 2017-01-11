package caelum.task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gersonsales on 10/01/17.
 */
@Controller
public class TaskController {

    @RequestMapping("/unnamedMethods")
    public void unnamedMethod() {
        System.out.println("Executing spring logic!");

    }
}
