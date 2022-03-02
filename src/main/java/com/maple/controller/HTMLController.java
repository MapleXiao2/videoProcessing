package com.maple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HTMLController {

    @RequestMapping("/upload")
    public String upload() {
        return "upload";
    }

    @RequestMapping("/features")
    public String features() {
        return "features";
    }

    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }


}
