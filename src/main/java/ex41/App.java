package ex41;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jonathan Strickland
 */
public class App {
    private final String csvName = "exercise41_input.txt";

    /**
     * Main method in App class
     * @return stdout
     */
    public String run() {
        ArrayList<String[]> names = readCSV();
        // sort names
        names.sort(new Comparator<String[]>() {
            @Override
            // sort names by first name
            public int compare(String[] o1, String[] o2) {
                return o1[0].compareTo(o2[0]);
            }
        });
        return getPrettyPrint(names);
    }

    /**
     * Gets pretty print of names
     * @param list list of sorted names
     * @return printed string
     */
    public String getPrettyPrint(ArrayList<String[]> list) {
        String retString = "Total of %d Names\n---------------\n";
        // join names by comma
        for (String[] s : list)
            retString += s[0] + ", " + s[1] + "\n";
        return String.format(retString, list.size());
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
