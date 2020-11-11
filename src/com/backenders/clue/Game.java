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
    private Solution solution;
    private Player hp = new Player();
    private Stories stories;
    private GameMap gameMap = new GameMap.Builder().generateStandardMap().build();
    private Prompter prompter = new Prompter(new Scanner(System.in));

    public void start() throws IOException {
        StringBuilder actionPrompt = new StringBuilder();
        actionPrompt.append("Press 0: Take a guess.\n");
        actionPrompt.append("Press 1: Move to a different room.\n");
        actionPrompt.append("Press 2: Look for clues.\n");
        actionPrompt.append("Press 3: Check your journal.\n");
        actionPrompt.append("Press 4: Quit.\n");

        generateGame();

        int choice;
        Predicate<Integer> validRange = integer -> 0 <= integer && integer <= 4;

        while(true) {
            prompter.info("Please choose your action");
            choice = prompter.promptIntInput(actionPrompt.toString(), validRange, "Please use valid ");
            switch(choice) {
                case 0 -> askPlayerGuess();
                case 1 -> offerMoveToPlayer(hp.getCurrentRoom());
//                case 2 -> checkForClues();
                case 3 -> checkJournal();
                case 4 -> quit();
                default -> System.out.println("thats not something you can do");
            }
        }
    }
    public void displayRules() {

    }
    private void generateGame() throws IOException {
        hp.setCurrentRoom(RoomType.BALLROOM);
        Stories s = new Stories();
        s.welcomeMessage();
        prompter.info("Welcome to clue");
        prompter.promptPause();
        prompter.info("A crazy mystery game its pretty cool");
        prompter.promptPause();

    }

    private Guess askPlayerGuess(){

        Predicate<Integer> validRange = integer -> 0 <= integer && integer <= Weapon.values().length;
        prompter.info("Whats your guess?");

        StringBuilder askPlayerForMurderer = new StringBuilder();
        askPlayerForMurderer.append("Choose the murderer.\n");

        StringBuilder askPlayerForWeapon = new StringBuilder();
        askPlayerForWeapon.append("Choose the murder weapon.\n");

        for(RolePlayer rp : RolePlayer.values()) {
            askPlayerForMurderer.append("Press " + rp.ordinal() + ": "+ rp.toString()+ " \n");
        }
        for(Weapon wp : Weapon.values()) {
            askPlayerForWeapon.append("Press " + wp.ordinal()+ ": "+ wp.toString() + "\n");
        }

        int murdererGuess = prompter.promptIntInput(askPlayerForMurderer.toString(), validRange, "Please choose a valid number");
        int weaponGuess = prompter.promptIntInput(askPlayerForWeapon.toString(), validRange, "Please choose a valid number");
        prompter.info("You guess that "+ RolePlayer.values()[murdererGuess] + " did it with a " +Weapon.values()[weaponGuess]).toUpperCase();
        return new Guess();
    };

    private boolean checkSolutions(Guess playerGuess){
//        return Solution.checkSolution(playerGuess);
        return false;
    };

    private void offerMoveToPlayer(RoomType playerRoom) {
        prompter.info("Where would you like to go");

        Map<String, RoomType> currentExits = gameMap.getExits(playerRoom);
        StringBuilder playerMovePrompt = new StringBuilder();
        playerMovePrompt.append("Current location: " + hp.getCurrentRoom()+"\n");
        playerMovePrompt.append(hp.getCurrentRoom().getDescription()+ "\n");
        playerMovePrompt.append(currentExits);

        Predicate playerMovePredicate = currentExits::containsKey;
        String directionInput = prompter.promptStringInput(playerMovePrompt.toString(), playerMovePredicate, "Please pick valid input");
//        boolean validInput = false;
//
//        while(!validInput) {
//            if(currentExits == null) {
//                System.out.println("That room doesn't exist");
//                break;
//            }
//
//            try {
//                System.out.println("Current location: " + hp.getCurrentRoom());
//                System.out.println(hp.getCurrentRoom().getDescription());
//                System.out.println(currentExits);
//
//
//                directionInput = scanner.nextLine().toUpperCase();
//                if(!currentExits.keySet().contains(directionInput)) {
//                    throw new InputMismatchException();
//                }
//                validInput = true;
//            } catch (InputMismatchException e) {
//                System.out.println("\u001B[31m"+"Please pick a valid input");
//            }
//        }
        hp.setCurrentRoom(currentExits.get(directionInput.toUpperCase()));
        System.out.println(hp.getCurrentRoom());

    };

    private <T extends Enum<T>> void printList(Class<T> enumType) {
        for(T enumConstant : enumType.getEnumConstants()) {
            System.out.println(enumConstant.name());
        }
        System.out.println();
    };
    private void listRolePlayers(){
        printList(RolePlayer.class);
    };
    private void listRooms(){
        printList(RoomType.class);
    };
    private void listWeapons(){
        printList(Weapon.class);
    };
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
        int choice = prompter.promptIntInput(listOptions.toString(),journalRange, "Please pick valid int");

        switch(choice) {
            case 0 -> listWeapons();
            case 1 -> listRolePlayers();
            case 2 -> listRooms();
        }
    }

    //    method(Stories.clueTemplates, WeaponList, RolePlayer);// chose how you want to implement clue making
}
