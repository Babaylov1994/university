package com.foxminded.app.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

public class Lecture {

    private Integer idLecture;
    private String name;
    private Teacher teacher;
    private LocalDate date;
    private LocalTime startLecture;
    private LocalTime endLecture;
    private List<Group> groupList;

    public Lecture(Integer idLecture, String name, Teacher teacher, LocalDate date,
                   LocalTime startLecture, LocalTime endLecture, List<Group> groupList) {
        this.idLecture = idLecture;
        this.name = name;
        this.teacher = teacher;
        this.date = date;
        this.startLecture = startLecture;
        this.endLecture = endLecture;
        this.groupList = groupList;
    }

    public Lecture() {
    }

    public Integer getIdLecture() {
        return idLecture;
    }

    public void setIdLecture(Integer idLecture) {
        this.idLecture = idLecture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartLecture() {
        return startLecture;
    }

    public void setStartLecture(LocalTime startLecture) {
        this.startLecture = startLecture;
    }

    public LocalTime getEndLecture() {
        return endLecture;
    }

    public void setEndLecture(LocalTime endLecture) {
        this.endLecture = endLecture;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lecture lecture = (Lecture) o;
        return Objects.equals(idLecture, lecture.idLecture) && Objects.equals(name, lecture.name) && Objects.equals(teacher, lecture.teacher) && Objects.equals(date, lecture.date) && Objects.equals(startLecture, lecture.startLecture) && Objects.equals(endLecture, lecture.endLecture) && Objects.equals(groupList, lecture.groupList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLecture, name);
    }

    @Override
    public String toString() {
        return "Lecture{" +
            "idLecture=" + idLecture +
            ", name='" + name + '\'' +
            ", teacher=" + teacher +
            ", date=" + date +
            ", startLecture=" + startLecture +
            ", endLecture=" + endLecture +
            ", groupList=" + groupList +
            '}';
    }
}
