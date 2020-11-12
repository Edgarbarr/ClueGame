package com.backenders.clue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WeaponClue {

    public String fileReadWepsClues() throws IOException {
        String csvFile = "wepsClueLines.txt";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        String randoChoice = "";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] weplines = line.split(cvsSplitBy);
                int index = weplines.length;
                int rand = (int) (Math.random() * index + 0);
                randoChoice = weplines[rand];
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return randoChoice;
    }

    public String listWeapons() {
        // check against solution to not return the solution one
        // store in a set to allow player to see already collected clues & to allow not sending duplicate clues

        List<Weapon> wepList = Arrays.stream(Weapon.values()).sequential().collect(Collectors.toList());
        wepList.remove(Solution.getMurderWeapon());
        int index = wepList.size() -1;
        int rand = (int) (Math.random() * index);
        String wep = "";
        wep = wepList.get(rand).toString();
        return wep;
    }

    public Object theWeapon() throws IOException {
        String yourWeaponClue = fileReadWepsClues() + " " + listWeapons() + ".";
        System.out.println(yourWeaponClue);

        return null;
    }
}