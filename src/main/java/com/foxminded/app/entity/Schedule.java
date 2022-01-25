package com.foxminded.app.entity;

import java.util.List;
import java.util.Objects;

public class Schedule {

    private Integer idLecture;
    private List<Lecture> lectures;

    public Schedule(Integer idLecture, List<Lecture> lectures) {
        this.idLecture = idLecture;
        this.lectures = lectures;
    }

    public Schedule() {
    }

    public Integer getIdLecture() {
        return idLecture;
    }

    public void setIdLecture(Integer idLecture) {
        this.idLecture = idLecture;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(idLecture, schedule.idLecture) && Objects.equals(lectures, schedule.lectures);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLecture);
    }

    @Override
    public String toString() {
        return "Schedule{" +
            "idLecture=" + idLecture +
            ", lectures=" + lectures +
            '}';
    }
}
