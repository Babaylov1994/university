package com.foxminded.university.dao;

import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Lecture;
import com.foxminded.university.entity.Student;

import java.util.List;

public interface LectureDao {

    List<Lecture> getAllLectures();

    Lecture getLectureById(int id);

    boolean createNewLecture(Lecture lecture);

    boolean removeLecture(int id);

    boolean updateTeacherOfLecture(int idTeacher, int idLecture);
}
