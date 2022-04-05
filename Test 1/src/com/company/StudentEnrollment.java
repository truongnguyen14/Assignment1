package com.company;

import java.util.Objects;

public class StudentEnrollment {
    private final String student;
    private final String course;
    private final String semester;

    public StudentEnrollment(String student, String course, String semester) {
        this.student = student;
        this.course = course;
        this.semester = semester;
    }

    public String getStudent() {
        return student;
    }

    public String getCourse() {
        return course;
    }

    public String getSemester() {
        return semester;
    }


    @Override
    public boolean equals(Object o) {  // overide equals method to check duplicate student enrollment in the student enrollment list
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEnrollment that = (StudentEnrollment) o;
        return Objects.equals(student, that.student) &&
                Objects.equals(course, that.course) &&
                Objects.equals(semester, that.semester);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, course, semester);
    }

    @Override
    public String toString() {
        return "student=" + student +
                ", course=" + course +
                ", semester=" + semester;
    }

}
