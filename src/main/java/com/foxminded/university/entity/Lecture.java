package com.foxminded.university.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "lecture")
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lecture")
    private int idLecture;

    @Column(name = "lecture_name")
    private String name;

    @OneToOne()
    @JoinColumn(name = "id_teacher")
    private Teacher lectureTeacher;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_schedule")
    private Schedule schedule;

    @Column(name = "date_lecture")
    private LocalDate date;

    @Column(name = "start_lecture")
    private LocalTime startLecture;

    @Column(name = "end_lecture")
    private LocalTime endLecture;

    public Lecture(LectureBuilder builder) {
        this.idLecture = builder.idLecture;
        this.name = builder.name;
        this.lectureTeacher = builder.lectureTeacher;
        this.schedule = builder.schedule;
        this.date = builder.date;
        this.startLecture = builder.startLecture;
        this.endLecture = builder.endLecture;
    }

    public Lecture() {
    }

    public static class LectureBuilder {
        private int idLecture;
        private String name;
        private Teacher lectureTeacher;
        private Schedule schedule;
        private LocalDate date;
        private LocalTime startLecture;
        private LocalTime endLecture;

        public LectureBuilder() {
        }

        public LectureBuilder setIdLecture(int idLecture) {
            this.idLecture = idLecture;
            return this;
        }

        public LectureBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public LectureBuilder setIdTeacher(Teacher lectureTeacher) {
            this.lectureTeacher = lectureTeacher;
            return this;
        }

        public LectureBuilder setSchedule(Schedule schedule) {
            this.schedule = schedule;
            return this;
        }

        public LectureBuilder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public LectureBuilder setStartLecture(LocalTime startLecture) {
            this.startLecture = startLecture;
            return this;
        }

        public LectureBuilder setEndLecture(LocalTime endLecture) {
            this.endLecture = endLecture;
            return this;
        }

        public Lecture build() {
            return new Lecture(this);
        }
    }

    public int getIdLecture() {
        return idLecture;
    }

    public String getName() {
        return name;
    }

    public Teacher getIdTeacher() {
        return lectureTeacher;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartLecture() {
        return startLecture;
    }

    public LocalTime getEndLecture() {
        return endLecture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lecture lecture = (Lecture) o;
        return Objects.equals(idLecture, lecture.idLecture) && Objects.equals(name, lecture.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLecture, name);
    }
}
