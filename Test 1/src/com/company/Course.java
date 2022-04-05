package com.company;

import java.util.Objects;

public class Course {
    private final String courseid;
    private final String name;
    private final String credit;

    public Course(String courseid, String name, String credit) {
        this.courseid = courseid;
        this.name = name;
        this.credit = credit;
    }

    public String getCourseid() {
        return courseid;
    }

    @Override
    public boolean equals(Object o) {  // overide equals method to check duplicate course in the course list
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseid, course.courseid) && Objects.equals(name, course.name) && Objects.equals(credit, course.credit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseid, name, credit);
    }

    @Override
    public String toString() {
        return "courseid=" + courseid  +
                ", name=" + name +
                ", credit=" + credit;
    }
}
