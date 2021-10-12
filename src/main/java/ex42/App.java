package ex42;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jonathan Strickland
 */
public class App {
    private final String csvName = "exercise42_input.txt";
    /**
     * Main method in App class
     * @return stdout
     */
    public String run() {
        ArrayList<String[]> data = readCSV();
        return getPrettyPrint(data);
    }

    /**
     * Gets a pretty formatted string
     * @param data data to format
     * @return formatted data
     */
    public String getPrettyPrint(ArrayList<String[]> data) {
        String retString = "Last\tFirst\tSalary\n----------------------\n";
        // loop through and append the data to retString
        for (String[] s : data) {
            for (String d : s) {
                retString += d + "\t\t";
            }
            retString += "\n";
        }
        return retString;
    }

    /**
     * Reads in the input csv file
     * @return arraylist of names
     */
    public ArrayList<String[]> readCSV() {
        ArrayList<String[]> csvInput = new ArrayList<>();
        try {
            File f = new File(getClass().getResource(csvName).getFile());
            Scanner scan = new Scanner(f);
            // read each line and split by "," delimiter
            while (scan.hasNextLine()) {
                csvInput.add(scan.nextLine().split(","));
            }
            scan.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return csvInput;
    }
}
