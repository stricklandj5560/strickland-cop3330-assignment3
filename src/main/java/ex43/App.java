package ex43;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jonathan Strickland
 */
public class App {
    /**
     * Main method in App class
     * @return stdout
     */
    public void run() {
        try (Scanner scan = new Scanner(System.in)){
            String siteName, author;
            boolean js, css;
            System.out.print("Site name: ");
            siteName = scan.nextLine().trim();
            System.out.print("Author ");
            author = scan.nextLine().trim();
            System.out.print("Do you want a folder for JavaScript? ");
            js = scan.next().toLowerCase().equals("y");
            System.out.print("Do you want a folder for CSS? ");
            css = scan.next().toLowerCase().equals("y");
            generateSite(siteName,author,js,css);
        }
    }

    /**
     * Generates a website given inptus
     * @param siteName name of site
     * @param author author
     * @param js create a javascript folder
     * @param css create a css folder
     */
    public void generateSite(String siteName, String author, boolean js, boolean css) {
        String webString = "<html>";
        webString += "<title>" + siteName + "</title>";
        webString += "<meta>" + author + "</meta>";
        webString += "</html>";
        try {
            // create file
            File dir = new File("./website/" + siteName);
            dir.mkdirs();
            Path p = dir.toPath();
            System.out.println("Created " + dir.toString());
            // write to file
            FileWriter fw = new FileWriter(p.resolve("index.html").toFile());
            PrintWriter print = new PrintWriter(fw);
            print.println(webString);
            // close
            print.close();
            fw.close();
            System.out.println("Created " + p.resolve("index.html"));
            // create js folder
            if (js) {
                p.resolve("js").toFile().mkdir();
                System.out.println("Created " + p.resolve("js"));
            }
            // create css folder?
            if (css) {
                p.resolve("css").toFile().mkdir();
                System.out.println("Created " + p.resolve("css"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
