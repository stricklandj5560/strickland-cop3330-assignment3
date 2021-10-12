package ex44;

import com.google.gson.Gson;

import java.io.File;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jonathan Strickland
 */
public class App {
    private final String jsonLoc = "exercise44_input.json";
    /**
     * Main method in App class
     * @return stdout
     */
    public void run() {
        try {
            // read in json text
            Reader input = Files.newBufferedReader(Paths.get((getClass().getResource(jsonLoc)).getPath()));
            // scan in json
            Gson gson = new Gson();
            Map<?, Product> map = gson.fromJson(input, Map.class);
            ArrayList<Product> products = new ArrayList<>();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

/**
 * Model for json format
 */
class Product {
    double price = 0;
    int quantity = 0;
    String name = "";
}