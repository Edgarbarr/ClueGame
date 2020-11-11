package com.backenders.clue;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class WeaponClueTest {
    WeaponClue wc = new WeaponClue();

    // are the txt files being read in, if so they are not null
    @Test
    void isFileReadIn() throws IOException {
        assertNotNull(wc.fileReadWepsClues());
    }

    // are the weapons being read in, if so they are not null
    @Test
    void isWeaponListStocked() {
        assertNotNull(wc.listWeapons());
    }

}