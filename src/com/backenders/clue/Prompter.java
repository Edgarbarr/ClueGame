package com.backenders.clue;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Predicate;

public class Prompter {
    private Scanner scanner;

    public Prompter(Scanner scanner) {
        this.scanner = scanner;
    }

    public String info(String info) {
        System.out.println(info);
        return info;
    }

    public String promptStringInput(String prompt, Predicate validInputPattern, String retryText) {
        String input = null;
        boolean validInput = false;
        while(!validInput) {
            System.out.println(Color.CYAN+prompt+Color.RESET);
            try {
                input = scanner.nextLine().toUpperCase();
                if(!validInputPattern.test(input)) {
                    throw new InputMismatchException();
                }
                validInput = true;
            } catch(InputMismatchException e) {
                System.out.println(Color.RED+retryText+Color.RESET);
            }
        }
        return input;
    }

    public int promptIntInput(String prompt, Predicate validInputPattern, String retryText) {
        int input = 0;
        boolean validInput = false;

        while(!validInput) {
            System.out.println(Color.CYAN+prompt+Color.RESET);
            try {
                input = scanner.nextInt();
                if(!validInputPattern.test(input)) {
                    throw new InputMismatchException();
                }
                validInput = true;
            } catch(InputMismatchException e) {
                System.out.println(Color.RED+retryText+Color.RESET);
            } finally {
                scanner.nextLine();
            }
        }
        return input;
    }
    public void promptPause() {
        System.out.println("Press enter to continue");
        scanner.nextLine();
    }
}
