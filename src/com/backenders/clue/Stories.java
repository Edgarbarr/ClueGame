package com.backenders.clue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Stories {
    private String welcome;

    // Constructor


    // Business Methods
    public void welcomeMessage() {

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("welcome.txt"));
            Stream<String> lines = reader.lines();
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ignored) {
                }
            }
        }

    }

    public void menu() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("menu.txt"));
            Stream<String> lines = reader.lines();
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ignored) {
                }
            }
        }
    }


}



