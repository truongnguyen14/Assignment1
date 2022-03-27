package com.company;

import java.util.Scanner;

public class Ultilities {
    public String getInput(){
        Scanner scanner1 = new Scanner(System.in);
        if (scanner1.hasNext()) {
            return scanner1.next();
        }   else return null;
    }

}
