package com.company;

public class Checkduplicated {

    public boolean Checkduplicated(String sid, String cid, String semester){
        Methods methods = Methods.getInstance();    // get instance
        for(StudentEnrollment studentEnrollment: methods.getAll()){
            if(studentEnrollment.getStudent().equals(sid)&studentEnrollment.getCourse().equals(cid)&studentEnrollment.getSemester().equals(semester)){
                System.out.println("duplicated");
                return true;        // return true when found
            }
        }
        return false;       // return false when not found
    }
}
