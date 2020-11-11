package com.backenders.clue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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


    public void stockWepClues() { // on build string + obj
        wepClues.add("Over in the corner, is that a ");
        wepClues.add("Under the window you see a ");
        wepClues.add("Is that the tip of a ");
        wepClues.add("Hmm, in her pocket, is that the outline of a ");
        wepClues.add("All accounted for. The staff found the missing ");
        wepClues.add("There's a dog chewing on a ");
    }

    public void fileReadWepsClues() throws IOException {
        String csvFile = "wepsClueLines.txt";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] weplines = line.split(cvsSplitBy);
                int index = weplines.length;
                int rand = (int) (Math.random() * index + 0);
                String randoChoice = weplines[rand];

                System.out.println(randoChoice);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String theWep() throws IOException {
//        fileReadWepsClues();
//        int rand = (int) (Math.random() * weplines[].lenght + 0);

//        stockWepClues();
//        int rand = (int) (Math.random() * wepClues.size() + 0);
//        String currentClue = wepClues.get(rand);
//        return currentClue;

        String whatEv = "";
        return whatEv;

    }

    public String listWeapons() {
        List<Weapon> wepList = Arrays.stream(Weapon.values()).sequential().collect(Collectors.toList());
        int index = wepList.size();
        int rand = (int) (Math.random() * index);
        String wep = "";
        wep = wepList.get(rand).toString();
        return wep;
    }

    public void getWepClue() {
//        System.out.println(theWep() + listWeapons() + " hmmm...");
    }


    public String stockRolPlayClues() { // reverse their build   obj + string

        rolPlyClues.add(" say's Yes, I've been here all night.");
        rolPlyClues.add("  has been right beside you all evening.");
        rolPlyClues.add(" was reading in the library when the murder happened");
        int index = rolPlyClues.size();
        int rand = (int) (Math.random() * index);
        return rolPlyClues.get(rand);
    }


    public void listWepText() {


    }


    // Constructors
    public Clue() {
    }

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