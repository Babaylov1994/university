package com.foxminded.university.dao;

import com.foxminded.university.entity.Lecture;

public interface LectureDao extends CrudDao<Lecture, Integer> {

    boolean updateTeacherOfLecture(int idTeacher, int idLecture);
}
