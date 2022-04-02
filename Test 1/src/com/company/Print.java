package com.company;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Print {
    public Print(){

    }
    Methods methods = Methods.getInstance();
    Ultilities ultilities = new Ultilities();
    public void printallcoursefor1student() throws FileNotFoundException {
        System.out.println("Enter your student id: ");
        String id = ultilities.getInput();
        System.out.println("Enter your semester: ");
        String sem = ultilities.getInput();
        List<String> allcourse = new ArrayList<>();
        for (StudentEnrollment studentEnrollment: methods.getAll()){
            if (studentEnrollment.getStudent().equals(id) & studentEnrollment.getSemester().equals(sem)){
                System.out.println(studentEnrollment.getCourse());
                allcourse.add(studentEnrollment.getStudent() + " " + studentEnrollment.getCourse());
            }
        }
        ultilities.SaveCSV("Getallcourse.csv", allcourse);
    }
    public void printallstudentof1courseinsemester() throws FileNotFoundException {
        System.out.println("Enter your course id: ");
        String cid = ultilities.getInput();
        System.out.println("Enter your semester: ");
        String sem = ultilities.getInput();
        List<String> allstudent = new ArrayList<>();
        for (StudentEnrollment studentEnrollment: methods.getAll()){
            if (studentEnrollment.getCourse().equals(cid) & studentEnrollment.getSemester().equals(sem)){
                System.out.println(studentEnrollment.getStudent());
                allstudent.add(studentEnrollment.getStudent());
            }
            }
        ultilities.SaveCSV("Getallstudent.csv", allstudent);
      }
    public void printallcoursein1semester(){
        System.out.println("Enter your semester");
        String sem = ultilities.getInput();
        for (StudentEnrollment studentEnrollment: methods.getAll()){
            if (studentEnrollment.getSemester().equals(sem)){
                System.out.println(studentEnrollment.getCourse());
            }
        }
    }
    public void printmenu() throws FileNotFoundException {
        boolean exit = false;
        while (!exit) {
            System.out.println("""
                                        
                    1) Print all course for 1 student in 1 semester
                    2) Print all student of 1 course in 1 semester
                    3) Print all course offer in 1 semester
                    4) Return to main menu
                    """);

            Scanner scanner = new Scanner(System.in);
            String option;
            option = scanner.next();
            switch (option) {
                case "1":
                    printallcoursefor1student();
                    break;
                case "2":
                    printallstudentof1courseinsemester();
                    break;
                case "3":
                    printallcoursein1semester();
                    break;
                case "4":
                    return;
            }
        }
    }
}
