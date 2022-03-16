package com.foxminded.university.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

public class Lecture {

    private int idLecture;
    private String name;
    private int idTeacher;
    private LocalDate date;
    private LocalTime startLecture;
    private LocalTime endLecture;
    private List<Group> groupList;

    public Lecture(LectureBuilder builder) {
        this.idLecture = builder.idLecture;
        this.name = builder.name;
        this.idTeacher = builder.idTeacher;
        this.date = builder.date;
        this.startLecture = builder.startLecture;
        this.endLecture = builder.endLecture;
        this.groupList = builder.groupList;
    }

    public static class LectureBuilder {
        private int idLecture;
        private String name;
        private int idTeacher;
        private LocalDate date;
        private LocalTime startLecture;
        private LocalTime endLecture;
        private List<Group> groupList;

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

        public LectureBuilder setIdTeacher(int idTeacher) {
            this.idTeacher = idTeacher;
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

    public int getIdLecture() {
        return idLecture;
    }

    public String getName() {
        return name;
    }

    public int getIdTeacher() {
        return idTeacher;
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

    public List<Group> getGroupList() {
        return groupList;
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
            ", idTeacher=" + idTeacher +
            ", date=" + date +
            ", startLecture=" + startLecture +
            ", endLecture=" + endLecture +
            ", groupList=" + groupList +
            '}';
    }
}
