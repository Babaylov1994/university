package com.foxminded.university.service.lecture;

import com.foxminded.university.entity.Lecture;
import com.foxminded.university.service.CrudService;

public interface LectureService extends CrudService<Lecture, Integer> {

    boolean updateTeacherOfLecture(int idTeacher, int idLecture);
}
