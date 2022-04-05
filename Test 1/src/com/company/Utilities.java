package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class Utilities {
    public String getInput(){       // get the input method
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String SaveCSV(String name, List<String> list) throws FileNotFoundException {  // save CSV method
        File CSV = new File(name);     // open file
        PrintWriter out = new PrintWriter(CSV);
        System.out.println("Do you want to save into CSV? (Y/N)");
        String ask = getInput().toLowerCase();      // make all input into lower case
        if (ask.contains("y") || ask.contains("Yes")){      // if statement
            for (String List : list) {      // use loop to print all the data from the array list to CSV file
                out.println(List);
            }
            out.close();   // close file
        }else if (ask.contains("n") || ask.contains("No")){
            return ask;         // if user type n or no, it will return the print menu
        }else{
            return SaveCSV(name, list);     // if user type any character other than y or n, it will return SaveCSV method
        }
        return ask;
    }
}
