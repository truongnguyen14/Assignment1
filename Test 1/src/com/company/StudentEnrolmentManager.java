package com.company;
import java.util.ArrayList;
import java.util.List;

public interface StudentEnrolmentManager {
    public void AddEnrollment(List<Student>studentsList, List<Course> courseList);
    public void UpdateEnrollment(List<Student> studentsList, List<Course> courseList);
    public void DeleteEnrollment();
    public List<StudentEnrollment> getAll();
    public void getOne(StudentEnrollment Enrollment);
}
