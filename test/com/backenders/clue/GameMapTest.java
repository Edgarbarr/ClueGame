package com.backenders.clue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GameMapTest {
    GameMap gameMap;
    @BeforeEach
    void setUp() {
        gameMap = new GameMap();
    }
    @Test
    void setRoom_whenGivenAnExitThatMatchesTheRoom_throwsRoomExitIsItselfException() {
        Exception e = assertThrows(RoomExitIsItselfException.class, () -> gameMap.setRoom(RoomType.KITCHEN, new Exit("N", RoomType.KITCHEN)));
        assertEquals("KITCHEN exit at N cannot be KITCHEN", e.getMessage());
    }

    @Test
    void getExits_whenGivenAValidRoom_returnsMapOfItsAssignedExits() {
        RoomType playerRoom = RoomType.DINING_ROOM;
        gameMap.setRoom(RoomType.DINING_ROOM, new Exit("N",RoomType.KITCHEN));
        Map<String, RoomType> validExit = new HashMap<>();
        validExit.put("N", RoomType.KITCHEN);

        assertEquals(validExit, gameMap.getExits(playerRoom));
    }

    @Test
    void getExits_whenGivenAnInvalidRoom_returnsNull() {
        RoomType invalidRoom = RoomType.SHOWER_ROOM;
        gameMap.setRoom(RoomType.DINING_ROOM, new Exit("N",RoomType.KITCHEN));
        assertNull(gameMap.getExits(invalidRoom));
    }

    @Test
    void name() {
    }
}