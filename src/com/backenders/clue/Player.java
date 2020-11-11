package com.backenders.clue;

import java.util.EnumSet;

public class Player {
    private RoomType currentRoom;
    private String name;

    // Constructor
    public Player(String name, RoomType currentRoom) {
        this.name = name;

    }

    public Player() {

    }

    // Business Methods

    // Inner class
    private class Guess {
        // Fields
        Weapon weaponGuess;
        RolePlayer murdererGuess;

        // Constructor
        public Guess(Weapon weapon, RolePlayer rolePlayer) {
            this.weaponGuess = weapon;
            this.murdererGuess = rolePlayer;
        }

        // Accessor Methods
        public Weapon getWeaponGuess() {
            return weaponGuess;
        }

        public void setWeaponGuess(Weapon weaponGuess) {

            EnumSet<Weapon> weapons = EnumSet.allOf(Weapon.class);
            // verify name of Weapons EnumSet in weapons
            if (weapons.contains(weaponGuess)) {
                this.weaponGuess = weaponGuess;
            } else {
                System.out.println("Please choose a valid weapon.");
            }
        }

        public RolePlayer getMurdererGuess() {
            return murdererGuess;
        }

        public void setMurdererGuess(RolePlayer murdererGuess) {
            if (RolePlayer.rolePlayers.contains(murdererGuess)) {
                this.murdererGuess = murdererGuess;
            } else {
                System.out.println("Please choose a valid character.");
            }
        }
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