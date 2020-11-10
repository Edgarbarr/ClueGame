package com.backenders.clue;

import java.util.ArrayList;
import java.util.List;

public class Clue {
    // Fields - clue consists of String text, Weapon, RolePlayer
    private String weaponClue = "";
    private String rolePlayerClue = "";

    private List<String> wepClues = new ArrayList<>();
    private List<String> rolPlyClues = new ArrayList<>();
    private List<String> wep = new ArrayList<>();
    private List<String> rp = new ArrayList<>();

    private Weapon weapon;
    private RolePlayer rolePlayer;


    public String stockWepClues() { // on build string + obj
        wepClues.add("Over in the corner, is that a ");
        wepClues.add("Under the window you see a ");
        wepClues.add("Is that the tip of a ");
        wepClues.add("Hmm, in her pocket, is that the outline of a ");
        wepClues.add("All accounted for. The staff found the missing ");
        wepClues.add("There's a dog chewing on a ");

        int rand = (int) (Math.random() * wepClues.size() + 0);
        String currentClue = wepClues.get(rand);

        return currentClue;
    }

    public void stockRolPlayClues() { // reverse their build   obj + string
        rolPlyClues.add(" say's Yes, I've been here all night.");
        rolPlyClues.add("  has been right beside you all evening.");
        rolPlyClues.add(" was reading in the library when the murder happened");
    }

    public void

    // Constructors
    public Clue() {}

    public Clue(String weaponClue, Weapon weapon) {
        this.weaponClue = weaponClue;
        this.weapon = weapon;
    }
    public Clue(String rolePlayerClue, RolePlayer rolePlayer) {
        this.rolePlayerClue = rolePlayerClue;
        this.rolePlayer = rolePlayer;
    }


// Accessors
    public String getWeaponClue() {
        return weaponClue;
    }

    public void setWeaponClue(String weaponClue) {
        this.weaponClue = weaponClue;
    }

    public String getRolePlayerClue() {
        return rolePlayerClue;
    }

    public void setRolePlayerClue(String rolePlayerClue) {
        this.rolePlayerClue = rolePlayerClue;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public RolePlayer getRolePlayer() {
        return rolePlayer;
    }

    public void setRolePlayer(RolePlayer rolePlayer) {
        this.rolePlayer = rolePlayer;
    }

    @Override
    public String toString() {
        return "Clue{" +
                "weaponClue='" + weaponClue + '\'' +
                ", rolePlayerClue='" + rolePlayerClue + '\'' +
                ", weapon=" + weapon +
                ", rolePlayer=" + rolePlayer +
                '}';
    }
}