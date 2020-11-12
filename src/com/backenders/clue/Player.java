package com.backenders.clue;

import java.util.EnumSet;
import java.util.Scanner;
import java.util.function.Predicate;

public class Player {
    private RoomType currentRoom;
    private String name;
    Prompter prompter = new Prompter(new Scanner(System.in));

    // Constructor
    public Player(String name, RoomType currentRoom) {
        this.name = name;
    }

    public Player() {

    }

    // Business Methods
     Guess askPlayerGuess(){

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
        return new Guess(Weapon.values()[weaponGuess], RolePlayer.values()[murdererGuess]);
    };

    // Inner class
//    private class Guess {
//        // Fields
//        Weapon weaponGuess;
//        RolePlayer murdererGuess;
//
//        // Constructor
//        public Guess(Weapon weapon, RolePlayer rolePlayer) {
//            this.weaponGuess = weapon;
//            this.murdererGuess = rolePlayer;
//        }
//
//        // Accessor Methods
//        public Weapon getWeaponGuess() {
//            return weaponGuess;
//        }
//
//        public void setWeaponGuess(Weapon weaponGuess) {
//
//            EnumSet<Weapon> weapons = EnumSet.allOf(Weapon.class);
//            // verify name of Weapons EnumSet in weapons
//
//            if (weapons.contains(weaponGuess)) {
//                this.weaponGuess = weaponGuess;
//            } else {
//                System.out.println("Please choose a valid weapon.");
//            }
//        }
//
//        public RolePlayer getMurdererGuess() {
//            return murdererGuess;
//        }
//
//        public void setMurdererGuess(RolePlayer murdererGuess) {
//            if (RolePlayer.rolePlayers.contains(murdererGuess)) {
//                this.murdererGuess = murdererGuess;
//            } else {
//                System.out.println("Please choose a valid character.");
//            }
//        }
//    }

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