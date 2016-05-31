package com.courses.spalah;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Ievgen Tararaka
 */
@Controller
public class ExampleController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView printHello(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        ModelAndView modelAndView = new ModelAndView("hello");
        return modelAndView;
    }

    @RequestMapping("/say_hello")
    public String hello(Model model) {
        return "jsp/hello";
    }

    @RequestMapping("/say_hello_body")
    @ResponseBody
    public String helloBody() {
        return "hello";
    }
}
