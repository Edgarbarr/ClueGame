package com.backenders.clue;

public class Player {
    private RoomType currentRoom;
    private String name;

    // Constructor
    public Player() { // or Scanner?
        this.name = name;
    }

    // Business Methods

    // Inner class
    private class Guess {
        // Fields
        Weapon weaponGuess;
        RolePlayer rolePlayerGuess;

        // Constructor
        public Guess(Weapon weapon, RolePlayer rolePlayer) {
            this.weaponGuess = weapon;
            this.rolePlayerGuess = rolePlayer;
        }

        // Business Methods




        // Accessor Methods
        public Weapon getWeaponGuess() {
            return weaponGuess;
        }

        public void setWeaponGuess(Weapon weapon) {
            this.weaponGuess = weapon;
        }

        public RolePlayer getRolePlayerGuess() {
            return rolePlayerGuess;
        }

        public void setRolePlayerGuess(RolePlayer rolePlayer) {
            this.rolePlayerGuess = rolePlayer;
        }
    }

    // Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {

        if (name.isBlank()){
            System.out.println("No blanks allowed. Please enter a player name:");
        }
        else{

        }
    }

    public RoomType getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(RoomType currentRoom) {
        this.currentRoom = currentRoom;
    }
}