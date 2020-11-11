package com.backenders.clue;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class RolePlayerClueTest {
    RolePlayerClue rpc = new RolePlayerClue();

    // checking to see if the csv txt file is read in and loaded into the array list if so not null
    @Test
    void isTheFileReadIn() throws IOException {
        assertNotNull(rpc.fileReaderRPClues());
    }

    // checking to see if the players are added to an arraylist if so not null
    @Test
    void isThereAListOfPlayerObjects() {
        assertNotNull(rpc.listRolePlayers());
    }

}