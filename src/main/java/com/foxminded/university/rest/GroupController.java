package com.foxminded.university.rest;

import com.foxminded.university.entity.Department;
import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Student;
import com.foxminded.university.rest.exception_handling.IncorrectData;
import com.foxminded.university.rest.exception_handling.NoSuchEntityException;
import com.foxminded.university.service.group.GroupService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping
    @ApiOperation(value = "Returns list of groups")
    public List<Group> getAllGroups() {
        return groupService.getAll().orElse(null);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Returns group by id")
    public Group getGroupById(@PathVariable("id") int id) {
        Group group = groupService.getById(id).orElse(null);
        if (group == null) {
            throw new NoSuchEntityException("There is no group with id = " +
                id + " in database");
        }
        return groupService.getById(id).orElse(null);
    }

    @GetMapping("/{id}/studentsOfGroup")
    @ApiOperation(value = "Returns list students of group")
    public List<Student> getStudentByGroup(@PathVariable("id") int id) {
        return groupService.getListStudentFromGroup(id).orElse(null);
    }

    @PostMapping
    @ApiOperation(value = "Create new group")
    public Group addNewGroup(@RequestBody Group group) {
        groupService.create(group);
        return group;
    }
}
