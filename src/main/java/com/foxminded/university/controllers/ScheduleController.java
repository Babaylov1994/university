package com.foxminded.university.controllers;

import com.foxminded.university.service.lecture.LectureService;
import com.foxminded.university.service.schedule.ScheduleService;
import com.foxminded.university.service.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private LectureService lectureService;

    @Autowired
    private TeacherService teacherService;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("lectures", lectureService.getAll());
        model.addAttribute("teachers", teacherService.getAll());
        return "schedule/scheduleIndex";
    }
}
