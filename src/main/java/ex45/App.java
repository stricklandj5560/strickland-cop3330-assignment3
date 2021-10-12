package ex45;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jonathan Strickland
 */
public class App {
    private final String inputFile = "exercise45_input.txt";
    /**
     * Main method in App class
     * @return stdout
     */
    public void run() {
        try {
            // read in input file
            File f = new File(getClass().getResource(inputFile).getFile());
            Scanner scan = new Scanner(f);
            String output = "";
            // put file in string
            while (scan.hasNextLine())
                output += scan.nextLine() + "\n";
            // replace all occurences of "utilize" with "use"
            output = output.replaceAll("utilize", "use");

            // get output file name
            System.out.print("What should the name of the output file be? ");
            String outputFileName = new Scanner(System.in).nextLine().trim();

            File outputFile = new File(outputFileName);
            outputFile.createNewFile();
            // write contents
            FileWriter fw = new FileWriter(outputFile);
            PrintWriter write = new PrintWriter(fw);
            write.println(output);

            write.close();
            fw.close();
            scan.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}