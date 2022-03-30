package com.company.Enrollment;
import java.util.ArrayList;
import java.util.List;

public class Methods implements StudentEnrolmentManager{
    private final List<StudentEnrollment>studentEnrollmentList = new ArrayList<>();
    private static Methods intsance = new Methods();
    public Methods() {

        super();
    }
    public static Methods getInstance(){
        return intsance;
    }
    @Override
    public void AddEnrollment(StudentEnrollment Enrollment) {

        studentEnrollmentList.add(Enrollment);
    }



    @Override
    public void UpdateEnrollment(StudentEnrollment toBeUpdated, StudentEnrollment update) {
        toBeUpdated.setStudent(update.getStudent());
        toBeUpdated.setCourse(update.getCourse());
        toBeUpdated.setSemester(update.getSemester());
        System.out.println("Updated 1 enrollment:\n" + toBeUpdated.toString());
    }

    @Override
    public void DeleteEnrollment(StudentEnrollment Enrollment) {

        this.studentEnrollmentList.remove(Enrollment);
    }

    @Override
    public List<StudentEnrollment> getAll() {

        return this.studentEnrollmentList;
    }

    @Override
    public void getOne(StudentEnrollment Enrollment) {

    }
}

