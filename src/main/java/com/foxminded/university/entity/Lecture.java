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

    @Column(name = "date_lecture")
    private LocalDate date;

    @Column(name = "start_lecture")
    private LocalTime startLecture;

    @Column(name = "end_lecture")
    private LocalTime endLecture;

    @OneToMany()
    @JoinColumn(name = "id_group")
    private List<Group> groupList;

    public Lecture(LectureBuilder builder) {
        this.idLecture = builder.idLecture;
        this.name = builder.name;
        this.lectureTeacher = builder.lectureTeacher;
        this.date = builder.date;
        this.startLecture = builder.startLecture;
        this.endLecture = builder.endLecture;
        this.groupList = builder.groupList;
    }

    public Lecture() {
    }

    public static class LectureBuilder {
        private int idLecture;
        private String name;
        private Teacher lectureTeacher;
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

        public LectureBuilder setIdTeacher(Teacher lectureTeacher) {
            this.lectureTeacher = lectureTeacher;
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

    public Teacher getIdTeacher() {
        return lectureTeacher;
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
            ", lectureTeacher=" + lectureTeacher +
            ", date=" + date +
            ", startLecture=" + startLecture +
            ", endLecture=" + endLecture +
            ", groupList=" + groupList +
            '}';
    }
}
