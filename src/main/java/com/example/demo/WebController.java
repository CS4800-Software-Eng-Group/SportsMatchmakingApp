package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Fixed the syntax of the file
@Controller
public class WebController {
    @RequestMapping("My")
    public String My(){
        System.out.println("new");
        return "my.jsp";
    }
}
