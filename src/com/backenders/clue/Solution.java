package com.backenders.clue;


import javax.management.relation.Role;
import java.sql.SQLOutput;
import java.util.Random;

public class Solution {
    private static RolePlayer murderer;
    private static Weapon murderWeapon;

    // Can I use the above?  Or is this next line preferred syntax?
    // Guess(RolePlayer.values()[murdererGuess], Weapon.values()[weaponGuess]);


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
        System.out.println(murderer);
        return murderer;
    }

    public static Weapon generateMurderWeapon() {
        murderWeapon = Weapon.class.getEnumConstants()
                [new Random().nextInt(Weapon.class.getEnumConstants().length)];
        System.out.println(murderWeapon);
        return murderWeapon;
    }

    public void giveSolution() {
        System.out.println("Thanks for playing.");
        System.out.println("The murderer was " + murderer + ".");
        System.out.println(murderer + " used the " + murderWeapon + ".");
    }

}

