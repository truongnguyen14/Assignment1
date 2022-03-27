package com.company;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseid;
    private String name;
    private int credit;
    protected List<Course> courseList = new ArrayList<>();

    public Course(){

    }
    public Course(String courseid, String name, int credit) {
        this.courseid = courseid;
        this.name = name;
        this.credit = credit;
        this.courseList = new ArrayList<>();
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getCourseid() {
        return courseid;
    }

    public String getName() {
        return name;
    }

    public int getCredit() {
        return credit;
    }

    public void addCourse(Course course){
        courseList.add(course);
    }
    public List<Course> getCourseList(){
        return courseList;
    }
    @Override
    public String toString() {
        return "courseid=" + courseid  +
                ", name=" + name +
                ", credit=" + credit;
    }
}
