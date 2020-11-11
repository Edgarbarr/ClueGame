package com.backenders.clue;


import javax.management.relation.Role;
import java.sql.SQLOutput;
import java.util.Random;

public class Solution {
    private static RolePlayer murderer;
    private static Weapon murderWeapon;


    // Guess(RolePlayer.values()[murdererGuess], Weapon.values()[weaponGuess]);


    private boolean checkSolution(RolePlayer murdererGuess, Weapon weaponGuess) {
        boolean result = false;
        if (murdererGuess == murderer && weaponGuess == murderWeapon) {
            result = true;
        }
        return result;
    }

    protected static RolePlayer generateMurderer() {
        murderer = RolePlayer.class.getEnumConstants()
                [new Random().nextInt(RolePlayer.class.getEnumConstants().length)];
        return murderer;
    }

    protected static Weapon generateMurderWeapon() {
        murderWeapon = Weapon.class.getEnumConstants()
                [new Random().nextInt(Weapon.class.getEnumConstants().length)];
        return murderWeapon;
    }

    private void giveUpAlready(RolePlayer murderer, Weapon murderWeapon) {
        System.out.println("Thanks for playing.");
        System.out.println("The murderer was " + murderer + ".");
        System.out.println(murderer + " used the " + murderWeapon + ".");
    }

}

