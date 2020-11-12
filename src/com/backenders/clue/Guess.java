package com.backenders.clue;

public class Guess {

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

        public RolePlayer getMurdererGuess() {
            return murdererGuess;
        }
}


