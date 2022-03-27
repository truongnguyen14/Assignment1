package com.company;

import java.util.ArrayList;
import java.util.List;


public class Student {
    private String studentid;
    private String name;
    private String dob;
    protected List<Student> studentsList = new ArrayList<>();

    public Student() {

    }

    public Student(String studentid, String name, String dob) {
        this.studentid = studentid;
        this.name = name;
        this.dob = dob;
        this.studentsList = new ArrayList<>();
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getStudentid() {
        return studentid;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public void addStudent(Student student){

        studentsList.add(student);
    }
    public List<Student> getStudentsList(){
        return studentsList;
    }
    @Override
    public String toString() {
        return
                "studentid=" + studentid +
                ", name=" + name +
                ", dob=" + dob;
    }
}
