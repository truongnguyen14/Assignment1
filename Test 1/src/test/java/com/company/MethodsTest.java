package com.company;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MethodsTest {
    public static Methods methods = Methods.getInstance();
    List<Student> studentList = new ArrayList<>();
    List<Course> courseList = new ArrayList<>();
    Course c1 = new Course("COSC1111", "Technology","12");
    Course c2 = new Course("COSC2222","Business","12");


    Student st1 = new Student("1111","Tom","12/12/2012");
    Student st2 = new Student("2222","Timo","15/1/2015");
    Student st3 = new Student("3333","Terry","15/5/2015");


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getInstance() {
        Methods actualInstance = Methods.getInstance();
        ArrayList<Student> studentList = new ArrayList<>();
        ArrayList<Course> courseList = new ArrayList<>();
        actualInstance.UpdateEnrollment(studentList, courseList);
        List<StudentEnrollment> all = actualInstance.getAll();
        assertEquals(studentList, all);
        assertEquals(courseList, all);
    }

    @Test
    void addEnrollment() {
        studentList.add(st1);
        studentList.add(st2);
        studentList.add(st3);
        courseList.add(c1);
        courseList.add(c2);
        methods.AddEnrollment(studentList,courseList);
    }

    @Test
    void deleteEnrollment() {
        methods.addStudentEnrollment(new StudentEnrollment("1111", "COSC1111", "1"));
        methods.DeleteEnrollment();
    }

    @Test
    void addStudentEnrollment() {
        methods.addStudentEnrollment(new StudentEnrollment("Student", "Course", "Semester"));
    }

    @Test
    void getAll() {
        assertTrue(methods.getAll().isEmpty());
    }

    @Test
    void getOne() {
        methods.addStudentEnrollment(new StudentEnrollment("1111", "COSC1111", "1"));
        methods.getOne();
    }
}