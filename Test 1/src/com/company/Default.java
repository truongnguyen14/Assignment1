package com.company;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Default {
    File inputFile;
    BufferedReader reader;
    protected List<Student>defstlist = new ArrayList<>();
    protected List<Course>defclist = new ArrayList<>();
    public void InputFile(String file){
        Methods methods = Methods.getInstance();
        List<Student> studentList = new ArrayList<>();
        List<Course> courseList = new ArrayList<>();
        inputFile = new File(file);  // open file
        try {
            reader = new BufferedReader(new FileReader(String.valueOf(inputFile)));  // read file
            String currentline = reader.readLine();  // read file line by line
            while (currentline!=null){
                String[] line= currentline.split(",");      // split line
                Student student = new Student(line[0],line[1],line[2]);
                Course course = new Course(line[3],line[4],line[5]);
                StudentEnrollment studentEnrollment = new StudentEnrollment(line[0],line[3],line[6]);
                studentList.add(student);
                courseList.add(course);
                methods.addStudentEnrollment(studentEnrollment);
                currentline= reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File not found");
            System.exit(0);     // stop the program when the default file not found
        }
        HashSet<Student> students = new HashSet(studentList);         //remove duplicate in student list and course list using HashSet
        defstlist = new ArrayList<>(students);
        HashSet<Course> courses = new HashSet(courseList);
        defclist = new ArrayList<>(courses);
    }
}
