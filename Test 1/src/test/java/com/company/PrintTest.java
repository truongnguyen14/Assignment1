package com.company;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrintTest {
    public static Methods methods = Methods.getInstance();
    public Print print = new Print();
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
    void printallcoursefor1student() throws FileNotFoundException {
        methods.addStudentEnrollment(new StudentEnrollment("1111", "COSC1111", "1"));
        print.printallcoursefor1student();
    }

    @Test
    void printallstudentof1courseinsemester() throws FileNotFoundException {
        methods.addStudentEnrollment(new StudentEnrollment("1111", "COSC1111", "1"));
        print.printallstudentof1courseinsemester();
    }

    @Test
    void printallcoursein1semester() throws FileNotFoundException{
        methods.addStudentEnrollment(new StudentEnrollment("1111", "COSC1111", "1"));
        print.printallcoursein1semester();
    }
}