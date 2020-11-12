package com.backenders.clue;


import javax.management.relation.Role;
import java.sql.SQLOutput;
import java.util.Random;

public class Solution {
    private static RolePlayer murderer;
    private static Weapon murderWeapon;

    boolean checkSolution(Guess playerGuess) {
        RolePlayer murdererGuess = playerGuess.getMurdererGuess();
        Weapon weaponGuess = playerGuess.getWeaponGuess();
        boolean result = false;
        if (murdererGuess == murderer && weaponGuess == murderWeapon) {
            result = true;
        }
        return result;
    }

    public static RolePlayer generateMurderer() {
        murderer = RolePlayer.class.getEnumConstants()
                [new Random().nextInt(RolePlayer.class.getEnumConstants().length)];
        return murderer;
    }

    public static Weapon generateMurderWeapon() {
        murderWeapon = Weapon.class.getEnumConstants()
                [new Random().nextInt(Weapon.class.getEnumConstants().length)];
        return murderWeapon;
    }

    // expandability
    public void giveSolution() {
        System.out.println("Thanks for playing.");
        System.out.println("The murderer was " + murderer + ".");
        System.out.println(murderer + " used the " + murderWeapon + ".");
    }

    public static RolePlayer getMurderer() {
        return murderer;
    }

    public static Weapon getMurderWeapon() {
        return murderWeapon;
    }
}

