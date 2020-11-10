package com.backenders.clue;

import org.junit.Test;
import static org.junit.Assert.*;
public class GameMapTest {
    @Test(expected = RoomExitIsItselfException.class)
    public void build_whenARoomIsGivenItselfAsAnExit_shouldThrowRoomExitIsItselfException() {
        GameMap gameMap = new GameMap.Builder()
                .createRoom(RoomType.LIBRARY)
                .addExit("N", RoomType.LIBRARY)
                .build();
    }

    @Test
    public void build_whenGeneratingAStandardMap_shouldReturn9Rooms() {
        GameMap gameMap = new GameMap.Builder().generateStandardMap().build();

    }
}