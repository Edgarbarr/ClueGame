package com.backenders.clue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Stories {



    public static void main(String[] args) {
        welcomeMessage();
    }

    public static void welcomeMessage () {

        try (BufferedReader reader = new BufferedReader(new FileReader("welcome.txt"))) {
            List<String> lines = new ArrayList<>();

            String curLine = null;
            while ((curLine = reader.readLine()) != null) {
                lines.add(curLine);
            }
            for (String line : lines) {
                System.out.println(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
