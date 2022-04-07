package com.foxminded.university.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_schedule")
    private int idSchedule;

    @Column(name = "date_schedule")
    private LocalDate date;

    public Schedule() {
    }

    public Schedule(int idSchedule, LocalDate date) {
        this.idSchedule = idSchedule;
        this.date = date;
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
}
