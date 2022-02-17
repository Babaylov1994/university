package com.foxminded.university.service;

import com.foxminded.university.entity.Lecture;

public interface LectureService extends CrudService<Lecture, Integer> {

    boolean updateTeacherOfLecture(int idTeacher, int idSchedule);
}
