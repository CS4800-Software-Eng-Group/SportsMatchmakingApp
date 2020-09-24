package com.example.demo;

import org.springframework.boot.WebController;
import org.springframework.boot.WebController;

@Controller
public class MyWebController {
    @RequestMapping("My")
    public static void main(String[] args) {
        System.out.println("new");
        return "my.jsp";
    }
}
