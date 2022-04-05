package com.company;
import java.util.*;


public class Methods implements StudentEnrollmentManager {
    private final List<StudentEnrollment>studentEnrollmentList = new ArrayList<>();
    private static final Methods intsance = new Methods();
    private final Utilities utilities = new Utilities();
    private final Checkduplicated checkduplicated = new Checkduplicated();
    public Methods() {

        super();
    }

    public static Methods getInstance(){
        return intsance;
    }  //Singleton

    @Override
    public void AddEnrollment(List<Student> studentsList, List<Course> courseList) {
        boolean student = false;
        boolean course = false;
        System.out.println("Enter your student ID: ");      //get the student id
        String sid = utilities.getInput();
        for (Student s : studentsList) {        //use loop to check the input student id available in student list
            if (s.getStudentid().equals(sid)) {     // compare the input student id and student id in the list
                System.out.println("Found");
                student = true;
                break;
            }
        }
        if(!student){           // if student id not available in the list return to the main menu
            System.out.println("Can't find student ID");
            return;
        }
        System.out.println("Enter your course: ");      // get the course id
        String cid = utilities.getInput();
        for (Course c : courseList) {       // use loop to check the input course id
            if (c.getCourseid().equals(cid)) {  // compare the input course id and course id in the course list
                System.out.println("Found");
                course = true;
                break;
            }
        }
        if(!course){        // if course id not available in the list return to the main menu
            System.out.println("Can't find course ID");
            return;
        }
        System.out.println("Enter your semester: ");        // get the semester
        String sem = utilities.getInput();
        if (checkduplicated.Checkduplicated(sid, cid, sem)){        // check duplicate
            return;     // return true when found a duplicate
        }else{
        studentEnrollmentList.add(new StudentEnrollment(sid, cid, sem));
        }       // if all three input correct and no duplicate in the list, add new enrollment to the student enrollment list
        System.out.println("Sucessfully add enrollment");
    }



    @Override
    public void UpdateEnrollment(List<Student> studentsList, List<Course> courseList) {
        boolean updelete = false;
        boolean upstudent = false;
        boolean upcourse = false;
        System.out.println("Enter your enrollment you want to update");
        System.out.println("Enter your student ID: ");
        String sid = utilities.getInput();
        System.out.println("Enter your course semester: ");
        String sem = utilities.getInput();
        for (StudentEnrollment studentEnrollment: studentEnrollmentList) {
            if (studentEnrollment.getStudent().equals(sid) & studentEnrollment.getSemester().equals(sem)) {
                System.out.println((studentEnrollment));
                System.out.println("Found");
                upstudent = true;

            }
        }
        if (!upstudent) {
            System.out.println("Can't find student ID in the enrollment list");
            return;
        }
        boolean exit = false;
        while (!exit) {         // menu of the update method
            System.out.println("""          
                    
                    1) Add an enrollment
                    2) Delete an enrollment
                    3) Return to main menu
                    """);

            Scanner scanner = new Scanner(System.in);
            String option;
            option = scanner.next();
            switch (option) {
                case "1" -> {       // add method
                    System.out.println(" ");
                    System.out.println("Add new enrollment");
                    System.out.println("Enter your course: ");
                    String ucid = utilities.getInput();
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
                    String usem = utilities.getInput();
                    if (checkduplicated.Checkduplicated(sid, ucid, usem)){
                        break;      // when the program found a duplicate in the list, the program will return the update menu
                    }else{
                        studentEnrollmentList.add(new StudentEnrollment(sid, ucid, usem));  // if not found a duplicate, add to student enrollment list
                    }
                    System.out.println("Sucessfully add enrollment");
                }
                case "2" -> {       // delete method
                    System.out.println("Enter your course: ");
                    String cid = utilities.getInput();
                    Iterator<StudentEnrollment> uplist = studentEnrollmentList.iterator(); // use Iterator
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
                case "3" -> exit = true;        // return to main menu
            }
        }
    }


    @Override
    public void DeleteEnrollment() {
        boolean delete = false;
        System.out.println("Enter your student ID: ");      // get all the necessary input
        String sid = utilities.getInput();
        System.out.println("Enter your course: ");
        String cid = utilities.getInput();
        System.out.println("Enter your semester: ");
        String sem = utilities.getInput();
        Iterator<StudentEnrollment> i = studentEnrollmentList.iterator();
        while (i.hasNext()){
            StudentEnrollment s = i.next();
            if (s.getStudent().equals(sid)  & s.getCourse().equals(cid) & s.getSemester().equals(sem)){
                System.out.println("Found");
                i.remove();             // remove found enrollment
                delete = true;
            }
        }
        if(!delete){
            System.out.println("Can't find the enrollment");
        }else{
            System.out.println("Successfully delete");
        }
    }

    public void addStudentEnrollment(StudentEnrollment studentEnrollment){      // add student enrollment method

        studentEnrollmentList.add(studentEnrollment);
    }

    @Override
    public List<StudentEnrollment> getAll() {       // get all student enrollments in the list

        return this.studentEnrollmentList;
    }

    @Override
    public void getOne() {      // get one student enrollment in the list
        boolean getone = false;
        System.out.println("Enter your student ID: ");
        String sid = utilities.getInput();
        System.out.println("Enter your course: ");
        String cid = utilities.getInput();
        System.out.println("Enter your semester: ");
        String sem = utilities.getInput();
        for (StudentEnrollment s : studentEnrollmentList) {  // use loop to find the enrollment
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

