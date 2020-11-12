package com.backenders.clue;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class WeaponClueTest {
WeaponClue wc = new WeaponClue();

    @Test
    public void wepsHintReadInNotEmpty() throws IOException {
        assertNotNull(wc.fileReadWepsClues());
    }

    @Test
    public void weaponsListCheckNotEmpty() {
        assertNotNull(wc.listWeapons());
    }
}