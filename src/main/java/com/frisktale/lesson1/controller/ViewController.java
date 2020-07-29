package com.frisktale.lesson1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ViewController{

    @RequestMapping("Tree")
    public String TreeView(){
        System.out.println("into Tree");
        return "eleTreeTest";
    }
}