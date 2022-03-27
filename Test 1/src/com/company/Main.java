package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Methods method = Methods.getInstance();

        Student student1 = AddStudent.AddStudent("1111","Tom","12/12/12");
        Student student2 = AddStudent.AddStudent("2222","terry","14/14/12");
        Student student3 = AddStudent.AddStudent("3333","Terry","15/15/15");
        student1.addStudent(student1);
        student1.addStudent(student2);
        student1.addStudent(student3);

        Course course1 = AddCourse.AddCourse("COSC1111", "Technology",12);
        Course course2 = AddCourse.AddCourse("COSC2222","Business",12);
        course1.addCourse(course1);
        course1.addCourse(course2);


        for(Student s: student1.getStudentsList()){
            System.out.println(s.getStudentid().toString());
        }
        for (Course c: course1.getCourseList()){
            System.out.println(c.toString());
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
