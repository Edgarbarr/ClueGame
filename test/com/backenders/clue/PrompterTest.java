package com.backenders.clue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

import java.io.File;
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
    public void info() {
        String response = null;

        scanner = new Scanner(new File("prompter-responses/info.txt"));
        prompter = new Prompter(scanner);
        Predicate predicate = input -> true;
        response = prompter.promptStringInput("sup", predicate, "Wrong");
        assertEquals("HELLO", response);

    }

    @Test
    public void promptStringInput() {
    }

    @Test
    public void promptIntInput() {
    }

    @Test
    public void promptPause() {
    }
}