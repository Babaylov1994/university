package com.foxminded.university.rest;

import com.foxminded.university.entity.Department;
import com.foxminded.university.entity.Schedule;
import com.foxminded.university.rest.exception_handling.IncorrectData;
import com.foxminded.university.rest.exception_handling.NoSuchEntityException;
import com.foxminded.university.service.schedule.ScheduleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping()
    @ApiOperation(value = "Returns list of schedule")
    public List<Schedule> getAllSchedule() {
        return scheduleService.getAll().orElse(null);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Returns schedule by id")
    public Schedule getScheduleById(@PathVariable("id") int id) {
        Schedule schedule = scheduleService.getById(id).orElse(null);
        if (schedule == null) {
            throw new NoSuchEntityException("There is no schedule with id = " +
                id + " in database");
        }
        return scheduleService.getById(id).orElse(null);
    }

    @PostMapping
    @ApiOperation(value = "Create new schedule")
    public Schedule addNewDepartment(@RequestBody Schedule schedule) {
        scheduleService.create(schedule);
        return schedule;
    }
}
