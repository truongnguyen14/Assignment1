package com.company;

import java.io.*;
import java.util.*;

public class Main {
    static File inputFile;
    static BufferedReader reader;
    public static void main(String[] args) throws FileNotFoundException {
	// write your code here
        Methods method = Methods.getInstance();
        List<Student> studentList = new ArrayList<>();
        List<Course> courseList = new ArrayList<>();
        Course c1 = new Course("COSC1111", "Technology","12");
        Course c2 = new Course("COSC2222","Business","12");
        courseList.add(c1);
        courseList.add(c2);


        Student st1 = new Student("1111","Tom","12/12/2012");
        Student st2 = new Student("2222","Timo","15/1/2015");
        Student st3 = new Student("3333","Terry","15/5/2015");
        studentList.add(st1);
        studentList.add(st2);
        studentList.add(st3);


        inputFile = new File("default.csv");
        try {
            reader = new BufferedReader(new FileReader(inputFile));
            String currentline = reader.readLine();
            while (currentline!=null){
                String[] line= currentline.split(",");      // split line
                Student student = new Student(line[0],line[1],line[2]);
                Course course = new Course(line[3],line[4],line[5]);
                StudentEnrollment studentEnrollment = new StudentEnrollment(line[0],line[3],line[6]);
                studentList.add(student);
                courseList.add(course);
                method.addStudentEnrollment(studentEnrollment);
                currentline= reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File not found");
            System.exit(0);     // stop the program when the default not found
        }
        HashSet<Student> students = new HashSet(studentList);        //remove duplicate in student list and course list using HashSet
        List<Student> stlist = new ArrayList<>(students);
        HashSet<Course> courses = new HashSet(courseList);
        List<Course> clist = new ArrayList<>(courses);

        boolean exit = false;
        while(!exit) {
            System.out.println("""

                    Welcome to the enrollment System!
                    1) Create an enrollment
                    2) Update an enrollment
                    3) Delete an enrollment
                    4) Print all enrollment
                    5) Print one enrollment
                    6) Print all student
                    7) Print all course
                    8) Print type
                    0) Quit""");

            Scanner scanner = new Scanner(System.in);
            String option;
            option = scanner.next();
            switch (option) {
                case "1":
                    method.AddEnrollment(stlist, clist);
                    break;
                case "2":
                    method.UpdateEnrollment(stlist, clist);
                    break;
                case "3":
                    method.DeleteEnrollment();
                    break;
                case "4":
                    for (StudentEnrollment se : method.getAll()) {      // Get all enrollment
                        System.out.println(se.toString());
                    }
                    break;
                case "5":
                    method.getOne();        // Get one enrollment
                    break;
                case "6":
                    for (Student student: stlist) {     // Get all student
                        System.out.println(student.toString());
                    }
                    break;
                case "7":
                    for (Course course: clist){     // Get all course
                        System.out.println(course.toString());
                    }
                    break;
                case "8":
                    Print print = new Print();
                    print.printmenu();      // Get print menu
                    break;
                case "0":
                    System.out.println("Have a nice day");
                    exit = true;
                    break;
            }
        }

    }
}
