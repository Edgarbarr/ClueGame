package com.backenders.clue;

import java.util.Scanner;
import java.util.function.Predicate;

// allows adding a player name - for game expandability
public class Player {
    private RoomType currentRoom;
    private String name;
    Prompter prompter = new Prompter(new Scanner(System.in));

    // Constructor
    public Player(String name) {
        this.name = name;
    }

    public Player() {

    }

    // Business Methods
     Guess askPlayerGuess(){

        Predicate<Integer> validRange = integer -> 0 <= integer && integer <= Weapon.values().length;
        prompter.info("Whats your guess?");

        StringBuilder askPlayerForMurderer = new StringBuilder();
        askPlayerForMurderer.append("Choose the murderer.\n" + Color.RESET);

        StringBuilder askPlayerForWeapon = new StringBuilder();
        askPlayerForWeapon.append("Choose the murder weapon.\n" + Color.RESET);

        for(RolePlayer rp : RolePlayer.values()) {
            askPlayerForMurderer.append("Press " + rp.ordinal() + ": "+ rp.toString()+ " \n");
        }
        for(Weapon wp : Weapon.values()) {
            askPlayerForWeapon.append("Press " + wp.ordinal()+ ": "+ wp.toString() + "\n");
        }

        int murdererGuess = prompter.promptIntInput(askPlayerForMurderer.toString(), validRange, "Please choose a valid number");
        int weaponGuess = prompter.promptIntInput(askPlayerForWeapon.toString(), validRange, "Please choose a valid number");
        prompter.info("You guess that "+ RolePlayer.values()[murdererGuess] + " did it with a " +Weapon.values()[weaponGuess]).toUpperCase();
        return new Guess(Weapon.values()[weaponGuess], RolePlayer.values()[murdererGuess]);
    }

    // Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {

        if (name.isBlank()) {
            System.out.println("No blanks allowed. Please enter a player name:");
        } else {
            this.name = name;
        }
    }

    public RoomType getCurrentRoom() {
        return (RoomType) currentRoom;
    }

    public void setCurrentRoom(RoomType currentRoom) {
        this.currentRoom = currentRoom;
    }
}