package com.company;
import java.util.*;


public class Methods implements StudentEnrolmentManager{
    private final List<StudentEnrollment>studentEnrollmentList = new ArrayList<>();
    private static final Methods intsance = new Methods();
    private final Ultilities ultilities = new Ultilities();
    public Methods() {

        super();
    }
    public static Methods getInstance(){
        return intsance;
    }

    @Override
    public void AddEnrollment(List<Student> studentsList, List<Course> courseList) {
        boolean student = false;
        boolean course = false;
        System.out.println("Enter your student ID: ");
        String sid = ultilities.getInput();
        for (Student s : studentsList) {
            if (s.getStudentid().equals(sid)) {
                System.out.println("Found");
                student = true;
                break;
            }
        }
        if(!student){
            System.out.println("Can't find student ID");
            return;
        }
        System.out.println("Enter your course: ");
        String cid = ultilities.getInput();
        for (Course c : courseList) {
            if (c.getCourseid().equals(cid)) {
                System.out.println("Found");
                course = true;
                break;
            }
        }
        if(!course){
            System.out.println("Can't find course ID");
            return;
        }
        System.out.println("Enter your semester: ");
        String sem = ultilities.getInput();
        studentEnrollmentList.add(new StudentEnrollment(sid, cid, sem));
        System.out.println("Sucessfully add enrollment");
    }



    @Override
    public void UpdateEnrollment(List<Student> studentsList, List<Course> courseList) {
        boolean updelete = false;
        boolean upstudent = false;
        boolean upcourse = false;
        System.out.println("Enter your enrollment you want to update");
        System.out.println("Enter your student ID: ");
        String sid = ultilities.getInput();
        System.out.println("Enter your course semester: ");
        String sem = ultilities.getInput();
        for (StudentEnrollment studentEnrollment: studentEnrollmentList) {
            if (studentEnrollment.getStudent().equals(sid) & studentEnrollment.getSemester().equals(sem)) {
                System.out.println((studentEnrollment.toString()));
                System.out.println("Found");
                upstudent = true;

            }
        }
        if (!upstudent) {
            System.out.println("Can't find student ID in the enrollment list");
            return;
        }
        boolean exit = false;
        while (!exit) {
            System.out.println("""
                    
                    1) Add an enrollment
                    2) Delete an enrollment
                    3) Return to main menu
                    """);

            Scanner scanner = new Scanner(System.in);
            String option;
            option = scanner.next();
            switch (option) {
                case "1" -> {
                    System.out.println(" ");
                    System.out.println("Add new enrollment");
                    System.out.println("Enter your course: ");
                    String ucid = ultilities.getInput();
                    for (Course uc : courseList) {
                        if (uc.getCourseid().equals(ucid)) {
                            System.out.println("Found");
                            upcourse = true;
                            break;
                        }
                    }
                    if (!upcourse) {
                        System.out.println("Can't find course ID");
                        return;
                    }
                    System.out.println("Enter your semester: ");
                    String usem = ultilities.getInput();
                    studentEnrollmentList.add(new StudentEnrollment(sid, ucid, usem));
                    System.out.println("Sucessfully add enrollment");
                }
                case "2" -> {
                    System.out.println("Enter your course: ");
                    String cid = ultilities.getInput();
                    Iterator<StudentEnrollment> uplist = studentEnrollmentList.iterator();
                    while (uplist.hasNext()) {
                        StudentEnrollment s = uplist.next();
                        if (s.getCourse().equals(cid)) {
                            System.out.println("Found");
                            uplist.remove();
                            updelete = true;
                            break;
                        }
                    }
                    if (!updelete) {
                        System.out.println("Can't find the enrollment");
                    } else {
                        System.out.println("Successfully delete");
                    }
                }
                case "3" -> exit = true;
            }
        }
    }


    @Override
    public void DeleteEnrollment() {
        boolean delete = false;
        System.out.println("Enter your student ID: ");
        String sid = ultilities.getInput();
        System.out.println("Enter your course: ");
        String cid = ultilities.getInput();
        System.out.println("Enter your semester: ");
        String sem = ultilities.getInput();
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

    public void addStudentEnrollment(StudentEnrollment studentEnrollment){

        studentEnrollmentList.add(studentEnrollment);
    }

    @Override
    public List<StudentEnrollment> getAll() {

        return this.studentEnrollmentList;
    }

    @Override
    public void getOne() {
        boolean getone = false;
        System.out.println("Enter your student ID: ");
        String sid = ultilities.getInput();
        System.out.println("Enter your course: ");
        String cid = ultilities.getInput();
        System.out.println("Enter your semester: ");
        String sem = ultilities.getInput();
        for (StudentEnrollment s : studentEnrollmentList) {
            if (s.getStudent().equals(sid) & s.getCourse().equals(cid) & s.getSemester().equals(sem)) {
                System.out.println(new StudentEnrollment(sid,cid,sem));
                getone = true;
            }
        }
        if(!getone){
            System.out.println("Can't find the enrollment");
        }else{
            System.out.println("Successfully found");
        }
    }
}

