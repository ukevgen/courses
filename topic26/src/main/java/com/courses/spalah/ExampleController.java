package com.courses.spalah;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Ievgen Tararaka
 */
@Controller
public class ExampleController {

    @RequestMapping("/say_hello")
    public String hello() {
        return "jsp/hello";
    }
}
