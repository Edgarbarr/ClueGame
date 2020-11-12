package com.backenders.clue;

import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;

public class Game {
    private RolePlayer rolePlayers;
    private Weapon weapons;
    private List<RoomType> rooms; //can be enum or class
    private WeaponClue wClue;
    private RolePlayerClue rpClue;
    private Solution solution = new Solution();
    private Player hp = new Player();
    private Stories stories;
    private GameMap gameMap = new GameMap.Builder().generateStandardMap().build();
    private Prompter prompter = new Prompter(new Scanner(System.in));

    public void start() throws IOException {


        generateGame();


        int choice;

        Stories s = new Stories();
        Predicate<Integer> validRange = integer -> 1 <= integer && integer <= 5;

        boolean gameIsStarted = false;
        System.out.println("Press 1 to list instructions");
        System.out.println("Press 2 to start game");
        while (!gameIsStarted) {

            choice = prompter.promptIntInput("", validRange, "Please use valid ");
            switch (choice) {
                case 1 -> s.instructions();
                case 2 -> gameIsStarted=true;
                case 3 -> listRolePlayers();
                case 4 -> listWeapons();
                case 5 -> listRooms();

            }
        }


        while (true) {


            offerMoveToPlayer(hp.getCurrentRoom());

//
        }
    }

    public void displayRules() {

    }

    private void generateGame() throws IOException {
        hp.setCurrentRoom(RoomType.BALLROOM);
        Stories s = new Stories();
        s.welcomeMessage();

        Solution.generateMurderWeapon();
        Solution.generateMurderer();


    }
    public void letPlayerMakeGuess(){
        System.out.println("Would you like to make a guess?");
        System.out.println("Press 1 if yes");
        System.out.println("Press 2 if no");
        Predicate<Integer> isValid = input -> input == 1 || input== 2;
        int choice = prompter.promptIntInput("", isValid, "Not a valid input.");
        if (choice == 1) {
            Guess playerGuess = hp.askPlayerGuess();
            boolean isPlayerRight = solution.checkSolution(playerGuess);
            if (isPlayerRight) {
                System.out.println("Good job");
                System.exit(0);
            } else {
                System.out.println("Wrong");
            }
        }else if (choice == 2) {
            System.out.println("OK, fine then.");
        }
    }


    private boolean checkSolutions(Guess playerGuess) {

//        return Solution.checkSolution(playerGuess);
        return false;
    }

    ;

    private void offerMoveToPlayer(RoomType playerRoom) throws IOException {

        Map<String, RoomType> currentExits = gameMap.getExits(playerRoom);
        StringBuilder playerMovePrompt = new StringBuilder();

        playerMovePrompt.append("You are in the " + hp.getCurrentRoom().name() + "\n");
        playerMovePrompt.append(hp.getCurrentRoom().getDescription() + "\n");
        System.out.println(playerMovePrompt.toString());

        WeaponClue wc = new WeaponClue();
        RolePlayerClue rpc = new RolePlayerClue();

        wc.theWeapon();
        rpc.thePerp();

        System.out.println("");


        Predicate<Integer> journalRange = integer -> integer > -1 && integer < 5;

        boolean isContinue = false;
        while(!isContinue) {
            System.out.println("Press 0 if quit\n"+"Press 1: List Weapons\n"+"Press 2 to see list of Characters " + "\n" + "Press 3 to see list of Rooms " + "\n"+"press 4 to continue");
            int choice = prompter.promptIntInput("", journalRange, "Please pick valid int");
            switch (choice) {
                case 0 -> quit();
                case 1 -> listWeapons();
                case 2 -> listRolePlayers();
                case 3 -> listRooms();
                case 4 -> isContinue = true;
                default -> System.out.println("that's not something you can do");
            }
        }
        letPlayerMakeGuess();
        // would you like to make a guess?


        System.out.println(currentExits);
        prompter.info("Where would you like to go? Press the Direction Letter to move to new room.");

        playerMovePrompt.append(currentExits);

        Predicate playerMovePredicate = currentExits::containsKey;
        String directionInput = prompter.promptStringInput("", playerMovePredicate, "Please pick valid input");
        playerMovePrompt.toString();

        hp.setCurrentRoom(currentExits.get(directionInput.toUpperCase()));
        System.out.println(hp.getCurrentRoom());

    }

    ;

    private <T extends Enum<T>> void printList(Class<T> enumType) {
        for (T enumConstant : enumType.getEnumConstants()) {
            System.out.println(enumConstant.name());
        }
        System.out.println();
    }

    ;

    private void listRolePlayers() {
        printList(RolePlayer.class);
    }

    ;

    private void listRooms() {
        printList(RoomType.class);
    }

    ;

    private void listWeapons() {
        printList(Weapon.class);
    }

    ;

    private void quit() {
        System.out.println("Thanks for playing have a nice day");
        System.exit(0);
    }

    private void checkJournal() {
        StringBuilder listOptions = new StringBuilder();
        listOptions.append("what would you like to list?\n");
        listOptions.append("Press 0: Weapons\n");
        listOptions.append("Press 1: RolePlayers\n");
        listOptions.append("Press 2: Rooms\n");

        Predicate<Integer> journalRange = integer -> 0 <= integer || integer >= 2;
        int choice = prompter.promptIntInput(listOptions.toString(), journalRange, "Please pick valid int");

        switch (choice) {
            case 0 -> listWeapons();
            case 1 -> listRolePlayers();
            case 2 -> listRooms();
        }
    }

    //    method(Stories.clueTemplates, WeaponList, RolePlayer);// chose how you want to implement clue making
}
