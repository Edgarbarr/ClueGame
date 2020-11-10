package com.backenders.clue;

import java.util.*;
import java.util.function.Predicate;

public class Game {
    private RolePlayer rolePlayers;
    private Weapon weapons;
    private List<RoomType> rooms; //can be enum or class
    private Clue clue; //should we have a clue class or have clues in Game
    private Solution solution;
    private Player hp = new Player();
    private Stories stories;
    private GameMap gameMap = new GameMap();
    private Scanner scanner = new Scanner(System.in);

//    private Thread bRoleThread;

    public void start(){
        StringBuilder actionPrompt = new StringBuilder();
        actionPrompt.append("Press 0: Take a guess.\n");
        actionPrompt.append("Press 1: Move to a different room.\n");
        actionPrompt.append("Press 2: Look for clues.\n");
        actionPrompt.append("Press 3: Check your journal.\n");
        actionPrompt.append("Press 4: Check map\n");
        actionPrompt.append("Press 5: Quit.\n");

        generateGame();

        int choice;
        Predicate<Integer> validRange = integer -> 0 <= integer && integer <= 4;

        while(true) {
            System.out.println("\u001B[35m"+"Choose your action");
            choice = playerChoice(validRange, actionPrompt.toString());
            scanner.nextLine();
            switch(choice) {
                case 0 -> askPlayerGuess();
                case 1 -> offerMoveToPlayer(hp.getCurrentRoom());
                case 2 -> checkForClues();
                case 3 -> checkJournal();
                case 4 -> quit();
                default -> System.out.println("thats not something you can do");
            }
        }
    }
    public void displayRules() {

    }
    private void generateGame() {
        createGameMap();
        hp.setCurrentRoom(RoomType.BALLROOM);
        System.out.println("Welcome to clue");
        playerPause();
        System.out.println("A crazy mystery game its pretty cool");
        playerPause();
    }
    private Guess askPlayerGuess(){

        Predicate<Integer> validRange = integer -> 0 <= integer && integer <= Weapon.values().length;

        System.out.println("Whats your guess?");

        StringBuilder askPlayerForMurderer = new StringBuilder();
        askPlayerForMurderer.append("Choose the murderer.\n");

        StringBuilder askPlayerForWeapon = new StringBuilder();
        askPlayerForWeapon.append("Choose the murder weapon.\n");

        for(RolePlayer rp : RolePlayer.values()) {
            askPlayerForMurderer.append("Press " + rp.ordinal() + ": "+ rp.toString()+ " \n");
        }
        for(Weapon wp : Weapon.values()) {
            askPlayerForWeapon.append("Press " + wp.ordinal() + ": to pick "+ wp.toString() + "\n");
        }

        int murdererGuess = playerChoice(validRange, askPlayerForMurderer.toString());

        int weaponGuess = playerChoice(validRange, askPlayerForWeapon.toString());

        System.out.println("You guess that "+ RolePlayer.values()[murdererGuess] + " did it with a " +Weapon.values()[weaponGuess]);
        return new Guess();
//        return new Guess(RolePlayer.values()[murdererGuess], Weapon.values()[weaponGuess]);

    };

    private boolean checkSolutions(Guess playerGuess){
//        return Solution.checkSolution(playerGuess);
        return false;
    };

    private void offerMoveToPlayer(RoomType playerRoom) {
        System.out.println("Where would you like to go");
        Map<String, RoomType> currentExits = gameMap.getExits(playerRoom);

        String directionInput = "";
        boolean validInput = false;
        while(!validInput) {

            if(currentExits == null) {
                System.out.println("That room doesn't exist");
                break;
            }

            try {
                System.out.println("Current location: " + hp.getCurrentRoom());
                System.out.println(hp.getCurrentRoom().getDescription());
                System.out.println(currentExits);


                directionInput = scanner.nextLine().toUpperCase();
                if(!currentExits.keySet().contains(directionInput)) {
                    throw new InputMismatchException();
                }
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("\u001B[31m"+"Please pick a valid input");
            }
        }
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
    private void playerPause() {
        System.out.println("Press enter to continue");
        scanner.nextLine();
    }
    private int playerChoice(Predicate validRange, String choicePrompt) {
        int choice = 0;
        boolean validChoice = false;

        while(!validChoice) {
            System.out.println(choicePrompt);
            try {
                choice = scanner.nextInt();
                if(!validRange.test(choice)) {
                    throw new InputMismatchException();
                }
                validChoice = true;
            } catch(InputMismatchException e) {
                scanner.nextLine();
                System.out.println("\u001B[31m"+"Please chose a valid number");
            }
        }
        return choice;
    }

    private void checkJournal() {
        StringBuilder listOptions = new StringBuilder();
        listOptions.append("what would you like to list?\n");
        listOptions.append("Press 0: Weapons\n");
        listOptions.append("Press 1: RolePlayers\n");
        listOptions.append("Press 2: Rooms\n");

        Predicate<Integer> journalRange = integer -> 0 <= integer || integer >= 2;
        int choice = playerChoice(journalRange, listOptions.toString());

        switch(choice) {
            case 0 -> listWeapons();
            case 1 -> listRolePlayers();
            case 2 -> listRooms();
        }
    }

    public Clue checkForClues() {
        System.out.println("You found a clue");
        return new Clue();
    }
    private void createGameMap() {
            gameMap.setRoom(RoomType.KITCHEN, new Exit("N", RoomType.LIBRARY), new Exit("E", RoomType.BALLROOM));
            gameMap.setRoom(RoomType.BALLROOM, new Exit("N", RoomType.DINING_ROOM), new Exit("W", RoomType.KITCHEN), new Exit("E", RoomType.BILLIARD_ROOM));
            gameMap.setRoom(RoomType.BILLIARD_ROOM, new Exit("N", RoomType.BEDROOM), new Exit("W", RoomType.BALLROOM));
            gameMap.setRoom(RoomType.LIBRARY, new Exit("S", RoomType.KITCHEN), new Exit("N", RoomType.LOUNGE), new Exit("SE", RoomType.BEDROOM), new Exit("NE", RoomType.HALL));
            gameMap.setRoom(RoomType.BEDROOM, new Exit("N",RoomType.HALL), new Exit("S", RoomType.BILLIARD_ROOM), new Exit("W", RoomType.LIBRARY));
            gameMap.setRoom(RoomType.HALL, new Exit("S", RoomType.BEDROOM), new Exit("N", RoomType.CELLAR), new Exit("W", RoomType.LIBRARY));
            gameMap.setRoom(RoomType.LOUNGE, new Exit("E", RoomType.DINING_ROOM), new Exit("S", RoomType.LIBRARY));
            gameMap.setRoom(RoomType.DINING_ROOM, new Exit("S", RoomType.BALLROOM), new Exit("W", RoomType.LOUNGE), new Exit("E", RoomType.CELLAR));
            gameMap.setRoom(RoomType.CELLAR, new Exit("S", RoomType.HALL), new Exit("W", RoomType.DINING_ROOM));

    }
    private void printMap() {
        scanner.nextLine();
             playerPause();
    }
    //    method(Stories.clueTemplates, WeaponList, RolePlayer);// chose how you want to implement clue making
}
