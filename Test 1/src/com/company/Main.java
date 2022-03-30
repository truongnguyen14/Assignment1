package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Methods method = Methods.getInstance();

       List<Course> courseList = new ArrayList<>();
        Course c1 = new Course("COSC1111", "Technology",12);
        Course c2 = new Course("COSC2222","Business",12);
        courseList.add(c1);
        courseList.add(c2);
        List<Course> clist = new ArrayList<>();
        HashSet<Course> HashSet = new HashSet(courseList);
        for(Course course: HashSet) {
            System.out.println(course.toString());
            clist.add(course);
        }

        List<Student> studentList = new ArrayList<>();
        Student st1 = new Student("1111","Tom","12/12/12");
        Student st2 = new Student("2222","Timo","15/1/15");
        Student st3 = new Student("3333","Terry","15/15/15");
        Student st4 = new Student("3333","Terry","15/15/15");
        studentList.add(st1);
        studentList.add(st2);
        studentList.add(st3);
        studentList.add(st4);
        List<Student> stlist = new ArrayList<>();
        HashSet<Student> hashSet = new HashSet(studentList);
        for(Student student : hashSet) {
            System.out.println(student.toString());
            stlist.add(student);
        }
        boolean exit = false;
        while(!exit) {
            System.out.println("\nWelcome to the enrollment System!\n" +
                    "1) Create an enrollment\n" +
                    "2) Update an enrollment\n" +
                    "3) Delete an enrollment\n" +
                    "4) Print all enrollment\n" +
                    "5) Print all course\n" +
                    "0) Quit");

            Scanner scanner1 = new Scanner(System.in);
            String option = "";

            if (scanner1.hasNext()) {
                option = scanner1.next();
            }

            switch (option) {
                case "1":
                    method.AddEnrollment(student1.getStudentsList(), course1.getCourseList());
                    break;
                case "2":
                    method.UpdateEnrollment(student1.getStudentsList(), course1.getCourseList());
                    break;
                case "3":
                    method.DeleteEnrollment();
                    break;
                case "4":
                    for (StudentEnrollment se : method.getAll()) {
                        System.out.println(se.toString());
                    }
                    break;
                case "5":
                    for (Course c: course1.getCourseList()){
                        System.out.println(c.toString());
                    }
                    break;
                case "0":
                    System.out.println("Goodbye");
                    exit = true;
                    break;
            }
        }

    }
}
