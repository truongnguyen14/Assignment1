package com.company;

public class AddCourse {
    public static Course AddCourse(String courseid, String name, int credit){
        return new Course(courseid, name, credit);
    }
}
