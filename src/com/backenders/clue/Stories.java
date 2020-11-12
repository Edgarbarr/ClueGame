package com.backenders.clue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class Stories {

    public void welcomeMessage() {
        String fileName = "welcome.txt";
        readerOfFiles(fileName);
    }

    public void instructions() {
        String fileName = "instructions.txt";
        readerOfFiles(fileName);
    }

    public void menu() {
        String fileName = "menu.txt";
        readerOfFiles(fileName);
    }

    public void banner() {
        String fileName = "skull.txt";
        readerOfFiles(fileName);
    }

    public void smileyWin() {
        String fileName = "smiley.txt";
        readerOfFiles(fileName);
    }

    public void readerOfFiles(String textDoc) {

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(textDoc));
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