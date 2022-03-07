package com.foxminded.university.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UniversityController {

    @GetMapping()
    public String index() {
        return "/university";
    }
}
