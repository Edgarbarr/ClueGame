package com.backenders.clue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RolePlayerClue {

    public String fileReaderRPClues() throws IOException {
        String csvFile = "rolePlayerClueLines.txt";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        String randoChoice = "";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] rplines = line.split(cvsSplitBy);
                int index = rplines.length;
                int rand = (int) (Math.random() * index + 0);
                randoChoice = rplines[rand];
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

    public String listRolePlayers() {
        // check against solution to not return the solution one
        // store in a set to allow player to see already collected clues & to allow not sending duplicate clues

        List<RolePlayer> rpList = Arrays.stream(RolePlayer.values()).sequential().collect(Collectors.toList());
        int index = rpList.size() -1;
        rpList.remove(Solution.getMurderer());
        int rand = (int) (Math.random() * index);
        String rplayer;
        rplayer = rpList.get(rand).getRpName();
        return rplayer;
    }

    public Object thePerp() throws IOException {
        String yourRolePlayerClue = listRolePlayers()  + Color.GREEN + fileReaderRPClues();
        System.out.println(yourRolePlayerClue + Color.RESET);
        return null;
    }

}