package com.backenders.clue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;
import java.util.function.Predicate;

import static org.junit.Assert.*;

public class PrompterTest {

    private Scanner scanner;
    private Prompter prompter;

    @AfterClass
    public static void afterClass() throws Exception {

    }

    @Test
    public void info_whenGivenAValidString_shouldReturnAndPrintsTheString() throws IOException {
        String infoString = "Welcome to clue";

        scanner = new Scanner(new File("prompter-responses/info.txt"));
        prompter = new Prompter(scanner);

        assertEquals(infoString, prompter.info(infoString));

    }

    @Test
    public void promptStringInput_whenInputPassesPredicate_shouldReturnInput() throws IOException {
        scanner = new Scanner(new File("prompter-responses/prompt-string-input.txt"));
        prompter = new Prompter(scanner);

        String name = "Edgar";
        String prompt = "Enter your name";
        String errorMessage = "Wrong";
        Predicate predicate = input -> input.equals(name);

        String response = prompter.promptStringInput(prompt, predicate, errorMessage);
        assertEquals(name, response);
    }

    @Test
    public void promptIntInput() throws IOException {
        int age = 29;

        scanner = new Scanner(new File("prompter-responses/prompt-int-input.txt"));
        prompter = new Prompter(scanner);

        String prompt = "Enter your age";
        String errorMessage = "That's not your age";
        Predicate predicate = integer -> integer.equals(29);


        int response = prompter.promptIntInput(prompt, predicate, errorMessage);
        assertEquals(age, response);

    }

}