package com.company;
import java.util.List;

public interface StudentEnrollmentManager {
    public void AddEnrollment(List<Student>studentsList, List<Course> courseList);
    public void UpdateEnrollment(List<Student> studentsList, List<Course> courseList);
    public void DeleteEnrollment();
    public List<StudentEnrollment> getAll();
    public void getOne();
}
