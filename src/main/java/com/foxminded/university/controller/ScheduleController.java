package com.foxminded.university.controller;

import com.foxminded.university.service.lecture.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private LectureService lectureService;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("lectures", lectureService.getAll().orElse(null));
        return "schedule/scheduleIndex";
    }
}
