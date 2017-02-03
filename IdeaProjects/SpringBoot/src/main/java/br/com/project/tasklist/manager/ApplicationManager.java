package br.com.project.tasklist.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by gersonsales on 02/02/17.
 */
@Controller
@EnableAutoConfiguration
public class ApplicationManager {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationManager.class, args);
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/home")
    public String home() {
        return "index";
    }

}
