package ex46;

import java.io.File;
import java.util.*;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jonathan Strickland
 */
public class App {
    private final String inputFile = "exercise46_input.txt";
    /**
     * Main method in App class
     * @return stdout
     */
    public void run() {
        SortedMap<String, Integer> occurencesMap = new TreeMap<>();
        try {
            // read in input file
            File f = new File(getClass().getResource(inputFile).getFile());
            Scanner scan = new Scanner(f);
            while(scan.hasNextLine()) {
                // split line
                String[] data = scan.nextLine().split(" ");
                // read occurences
                for (String d : data) {
                    // key doesn't exist, add new word
                    if (occurencesMap.get(d) == null) {
                        occurencesMap.put(d, 1);
                    } else {
                        // increment occurence
                        occurencesMap.put(d, occurencesMap.get(d) + 1);
                    }
                }
            }
            // pretty print everything
            doPrettyPrint(occurencesMap);
            scan.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Pretty prints the occurences map
     * @param occurencesMap
     */
    public void doPrettyPrint(SortedMap<String, Integer> occurencesMap) {
        // get keys and values so they can be sorted
        ArrayList<String[]> sortingMap = new ArrayList<>();
        // we need to do this to sort by values
        for (String s : occurencesMap.keySet()) {
            String[] temp = new String[2];
            temp[0] = s;
            temp[1] = String.valueOf(occurencesMap.get(s));
            sortingMap.add(temp);
        }
        // sort
        sortingMap.sort(new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o2[1].compareTo(o1[1]);
            }
        });
        // finally, print
        String cur = "";
        for (String[] s : sortingMap) {
            cur += s[0] + ": ";
            // add stars
            for (int i = 0; i < Integer.valueOf(s[1]); i++)
                cur += "*";
            cur += "\n";
        }
        System.out.println(cur);
    }
}
