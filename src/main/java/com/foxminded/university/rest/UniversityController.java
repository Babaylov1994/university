package com.foxminded.university.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UniversityController {

    @GetMapping()
    public String index() {
        return "/university";
    }
}
