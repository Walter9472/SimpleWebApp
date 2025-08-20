package com.walter.simpleWebApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    //@ResponseBody -> Returns the data not the Page - Alternative to Restcontroller
    public String greet(){
        System.out.println("Im Here...");
        return "Welcome to Walter!!";
    }
    @RequestMapping("/about")
    public String about(){
        return "We dont teach, we Educate";
    }
}
