package com.company;
import java.util.*;


public class Methods implements StudentEnrolmentManager{
    private final List<StudentEnrollment>studentEnrollmentList = new ArrayList<>();
    private static final Methods intsance = new Methods();
    public Methods() {

        super();
    }
    public static Methods getInstance(){
        return intsance;
    }
    Scanner scanner = new Scanner(System.in);


    @Override
    public void AddEnrollment(List<Student> studentsList, List<Course> courseList) {
        boolean student = false;
        boolean course = false;
        System.out.println("Enter your student ID: ");
        String sid = scanner.nextLine();
        for (Student s : studentsList) {
            if (s.getStudentid().equals(sid)) {
                System.out.println("Found");
                student = true;
            }
        }
        if(!student){
            System.out.println("Can't find student ID");
            return;
        }
        System.out.println("Enter your course: ");
        String cid = scanner.nextLine();
        for (Course c : courseList) {
            if (c.getCourseid().equals(cid)) {
                System.out.println("Found");
                course = true;
            }
        }
        if(!course){
            System.out.println("Can't find course ID");
            return;
        }
        System.out.println("Enter your semester: ");
        String sem = scanner.nextLine();
        studentEnrollmentList.add(new StudentEnrollment(sid, cid, sem));
    }



    @Override
    public void UpdateEnrollment(List<Student> studentsList, List<Course> courseList) {
        boolean found = false;
        boolean upstudent = false;
        boolean upcourse = false;
        System.out.println("Enter your enrollment you want to update");
        System.out.println("Enter your student ID: ");
        String sid = scanner.nextLine();
        System.out.println("Enter your course: ");
        String cid = scanner.nextLine();
        System.out.println("Enter your semester: ");
        String sem = scanner.nextLine();
        ListIterator<StudentEnrollment> li = studentEnrollmentList.listIterator();
        while(li.hasNext()){
            StudentEnrollment st = li.next();
            if (st.getStudent().equals(sid) & st.getCourse().equals(cid) & st.getSemester().equals(sem)){
                System.out.println("Found");
                System.out.println(" ");
                System.out.println("Enter your new update");
                System.out.println("Enter your student ID: ");
                String usid = scanner.nextLine();
                for (Student s : studentsList) {
                    if (s.getStudentid().equals(sid)) {
                        System.out.println("Found");
                        upstudent = true;
                    }
                }
                if(!upstudent){
                    System.out.println("Can't find student ID");
                    return;
                }
                System.out.println("Enter your course: ");
                String ucid = scanner.nextLine();
                for (Course c : courseList) {
                    if (c.getCourseid().equals(cid)) {
                        System.out.println("Found");
                        upcourse = true;
                    }
                }
                if(!upcourse){
                    System.out.println("Can't find course ID");
                    return;
                }
                System.out.println("Enter your semester: ");
                String usem = scanner.nextLine();
                li.set(new StudentEnrollment(usid,ucid,usem));
                found = true;
            }
        }
        if(!found){
            System.out.println("Can't find the enrollment");
        }else{
            System.out.println("Successfully update");
        }
    }

    @Override
    public void DeleteEnrollment() {
        boolean delete = false;
        System.out.println("Enter your student ID: ");
        String sid = scanner.nextLine();
        System.out.println("Enter your course: ");
        String cid = scanner.nextLine();
        System.out.println("Enter your semester: ");
        String sem = scanner.nextLine();
        Iterator<StudentEnrollment> i = studentEnrollmentList.iterator();
        while (i.hasNext()){
            StudentEnrollment s = i.next();
            if (s.getStudent().equals(sid)  & s.getCourse().equals(cid) & s.getSemester().equals(sem)){
                System.out.println("Found");
                i.remove();
                delete = true;
            }
        }
            if(!delete){
                System.out.println("Can't find the enrollment");
            }else{
                System.out.println("Successfully delete");
            }
    }

    @Override
    public List<StudentEnrollment> getAll() {

        return this.studentEnrollmentList;
    }

    @Override
    public void getOne(StudentEnrollment Enrollment) {

    }
}

