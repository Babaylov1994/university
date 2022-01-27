package com.foxminded.university.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

public class Lecture {

    private int idLecture;
    private String name;
    private Teacher teacher;
    private LocalDate date;
    private LocalTime startLecture;
    private LocalTime endLecture;
    private List<Group> groupList;

    public Lecture(LectureBuilder builder) {
        this.idLecture = builder.idLecture;
        this.name = builder.name;
        this.teacher = builder.teacher;
        this.date = builder.date;
        this.startLecture = builder.startLecture;
        this.endLecture = builder.endLecture;
        this.groupList = builder.groupList;
    }

    public static class LectureBuilder {
        private int idLecture;
        private String name;
        private Teacher teacher;
        private LocalDate date;
        private LocalTime startLecture;
        private LocalTime endLecture;
        private List<Group> groupList;

        public LectureBuilder(int idLecture) {
            this.idLecture = idLecture;
        }

        public LectureBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public LectureBuilder setTeacher(Teacher teacher) {
            this.teacher = teacher;
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

        public LectureBuilder setGroupList(List<Group> groupList) {
            this.groupList = groupList;
            return this;
        }

        public Lecture build() {
            return new Lecture(this);
        }
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
