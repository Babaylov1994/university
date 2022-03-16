package com.foxminded.university.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Schedule {

    private int idSchedule;
    private LocalDate date;
    private List<Lecture> lectures;

    public Schedule(int idSchedule, LocalDate date, List<Lecture> lectures) {
        this.idSchedule = idSchedule;
        this.date = date;
        this.lectures = lectures;
    }

    public Schedule() {
    }

    public int getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(int idSchedule) {
        this.idSchedule = idSchedule;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
        return Objects.equals(idSchedule, schedule.idSchedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSchedule);
    }

    @Override
    public String toString() {
        return "Schedule{" +
            "idSchedule=" + idSchedule +
            ", date=" + date +
            ", lectures=" + lectures +
            '}';
    }
}
