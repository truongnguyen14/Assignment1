package com.company;

public class AddStudent {
    public static  Student AddStudent(String studentid, String name, String dob){
        return new Student(studentid, name, dob);
    }
}
