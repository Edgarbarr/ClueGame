package com.backenders.clue;

import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;

public class Game {
    private Solution solution = new Solution();
    private Player hp = new Player();
    private GameMap gameMap = new GameMap.Builder().generateStandardMap().build();
    private Prompter prompter = new Prompter(new Scanner(System.in));

    // Game starts
    public void start() throws IOException {

        generateGame();

        int choice;

        Stories s = new Stories();
        Predicate<Integer> validRange = integer -> 1 <= integer && integer <= 5;

        boolean gameIsStarted = false;
        s.menu();
        while (!gameIsStarted) {

            choice = prompter.promptIntInput("", validRange, "Please use valid ");
            switch (choice) {
                case 1 -> s.instructions();
                case 2 -> gameIsStarted = true;
                case 3 -> listRolePlayers();
                case 4 -> listWeapons();
                case 5 -> listRooms();
            }
        }
        while (true) {

            offerMoveToPlayer(hp.getCurrentRoom());

        }
    }

    // builds game begins text
    private void generateGame() throws IOException {
        hp.setCurrentRoom(RoomType.BALLROOM);
        Stories s = new Stories();
        s.banner();
        s.welcomeMessage();

        Solution.generateMurderWeapon();
        Solution.generateMurderer();
    }

    // players make a guess
    public void letPlayerMakeGuess() {
        System.out.println("Would you like to make a guess?");
        System.out.println("Press 1 if yes");
        System.out.println("Press 2 if no");
        Predicate<Integer> isValid = input -> input == 1 || input == 2;
        int choice = prompter.promptIntInput("", isValid, "Not a valid input.");
        if (choice == 1) {
            Guess playerGuess = hp.askPlayerGuess();
            boolean isPlayerRight = solution.checkSolution(playerGuess);
            if (isPlayerRight) {
                System.out.println("Good job!");
                Stories s = new Stories();
                s.smileyWin();
                System.exit(0);
            } else {
                System.out.println("Wrong");
            }
        } else if (choice == 2) {
            System.out.println("OK, fine then.");
        }
    }

    // allow moves
    private void offerMoveToPlayer(RoomType playerRoom) throws IOException {

        Map<String, RoomType> currentExits = gameMap.getExits(playerRoom);
        StringBuilder playerMovePrompt = new StringBuilder();

        playerMovePrompt.append("You are in the " + hp.getCurrentRoom().name() + "\n");
        playerMovePrompt.append(hp.getCurrentRoom().getRoomDescription() + "\n" + Color.RESET);
        System.out.println(playerMovePrompt.toString());

        WeaponClue wc = new WeaponClue();
        RolePlayerClue rpc = new RolePlayerClue();

        wc.theWeapon();
        rpc.thePerp();
        System.out.println("");

        Predicate<Integer> journalRange = integer -> integer > -1 && integer < 5;

        boolean isContinue = false;
        while (!isContinue) {
            System.out.println("Press 0: Quit\n" + "Press 1: List Weapons\n" + "Press 2: List Characters " + "\n" + "Press 3: List of Rooms " + "\n" + "Press 4: Continue");
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

        // would you like to make a guess?
        letPlayerMakeGuess();

        System.out.println(currentExits);
        prompter.info("Where would you like to go? Press the Direction Letter to move to new room.");

        playerMovePrompt.append(currentExits);

        Predicate playerMovePredicate = currentExits::containsKey;
        String directionInput = prompter.promptStringInput("", playerMovePredicate, "Please pick valid input");
        playerMovePrompt.toString();

        hp.setCurrentRoom(currentExits.get(directionInput.toUpperCase()));
        System.out.println(hp.getCurrentRoom());
    }

    // print list of Weapons, Role Players, Rooms

    private void listRolePlayers() {
        RolePlayer.printRolePlayerList(RolePlayer.rpList());
    }

    private void listRooms() {

       RoomType.printRooms();
    }

    private void listWeapons() {
        Weapon.printWeaponList();
    }


    private void quit() {
        solution.giveSolution();

        System.exit(0);
    }

}
