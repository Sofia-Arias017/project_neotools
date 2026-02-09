package com.sjdevs.project_neotools.infrastructure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Forward root to index.html in static resources
    @GetMapping("/")
    public String home() {
        return "forward:/index.html";
    }
}
