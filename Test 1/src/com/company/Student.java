package com.company;

import java.util.Objects;

public class Student {
        private final String studentid;
        private final String name;
        private final String dob;

    public Student(String studentid, String name, String dob) {
        this.studentid = studentid;
        this.name = name;
        this.dob = dob;
    }

    public String getStudentid() {
        return studentid;
    }

    @Override
    public boolean equals(Object o) {       // overide equals method to check duplicate student in the student list
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentid, student.studentid) && Objects.equals(name, student.name) && Objects.equals(dob, student.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentid, name, dob);
    }

    @Override
    public String toString() {
        return
                "studentid=" + studentid +
                ", name=" + name +
                ", dob=" + dob;
    }
}
