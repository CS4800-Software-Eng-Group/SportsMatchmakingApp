package com.example.demo.HelloWorld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.jsoup.nodes.*;
import org.jsoup.*;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

@RestController
public class Assignment4NathanMcCausland
{
    @RequestMapping("/NathanAssignment4")
    public String APITest() throws IOException
    {
        return Jsoup.connect("https://en.wikipedia.org/").get().body().html();
    }
}