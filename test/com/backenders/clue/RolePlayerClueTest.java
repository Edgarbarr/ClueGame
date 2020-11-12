package com.backenders.clue;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class RolePlayerClueTest {
    RolePlayerClue rpc = new RolePlayerClue();

    @Test
    public void fileReaderNotEmpty() throws IOException {
        assertNotNull(rpc.fileReaderRPClues());
    }

    @Test
    public void rolePlayersNotEmpty() {
        assertNotNull(rpc.listRolePlayers());
    }


}