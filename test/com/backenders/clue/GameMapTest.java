package com.backenders.clue;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

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
    public void build_whenGeneratingAStandardMap_shouldReturnRoomsWithProperExits() {

        GameMap gameMap = new GameMap.Builder().generateStandardMap().build();
        Map<String, RoomType> kitchenExits = gameMap.getExits(RoomType.KITCHEN);
        Map<String, RoomType> ballroomExits = gameMap.getExits(RoomType.BALLROOM);
        Map<String, RoomType> billiardRoomExits = gameMap.getExits(RoomType.BILLIARD_ROOM);
        Map<String, RoomType> libraryExits = gameMap.getExits(RoomType.LIBRARY);
        Map<String, RoomType> bedroomExits = gameMap.getExits(RoomType.BEDROOM);
        Map<String, RoomType> hallExits = gameMap.getExits(RoomType.HALL);
        Map<String, RoomType> loungeExits = gameMap.getExits(RoomType.LOUNGE);
        Map<String, RoomType> diningRoomExits = gameMap.getExits(RoomType.DINING_ROOM);
        Map<String, RoomType> cellarExits = gameMap.getExits(RoomType.CELLAR);

        assertSame(kitchenExits.get("N"), RoomType.LIBRARY);
        assertSame(kitchenExits.get("E"), RoomType.BALLROOM);

        assertSame(ballroomExits.get("N"), RoomType.DINING_ROOM);
        assertSame(ballroomExits.get("E"), RoomType.BILLIARD_ROOM);
        assertSame(ballroomExits.get("W"), RoomType.KITCHEN);

        assertSame(billiardRoomExits.get("N"), RoomType.BEDROOM);
        assertSame(billiardRoomExits.get("W"), RoomType.BALLROOM);

        assertSame(libraryExits.get("N"), RoomType.LOUNGE);
        assertSame(libraryExits.get("NE"), RoomType.HALL);
        assertSame(libraryExits.get("SE"), RoomType.BEDROOM);
        assertSame(libraryExits.get("S"), RoomType.KITCHEN);

        assertSame(bedroomExits.get("N"), RoomType.HALL);
        assertSame(bedroomExits.get("S"), RoomType.BILLIARD_ROOM);
        assertSame(bedroomExits.get("W"), RoomType.LIBRARY);

        assertSame(hallExits.get("N"), RoomType.CELLAR);
        assertSame(hallExits.get("S"), RoomType.BEDROOM);
        assertSame(hallExits.get("W"), RoomType.LIBRARY);

        assertSame(loungeExits.get("E"), RoomType.DINING_ROOM);
        assertSame(loungeExits.get("S"), RoomType.LIBRARY);

        assertSame(diningRoomExits.get("E"), RoomType.CELLAR);
        assertSame(diningRoomExits.get("S"), RoomType.BALLROOM);
        assertSame(diningRoomExits.get("W"), RoomType.LOUNGE);

        assertSame(cellarExits.get("S"), RoomType.HALL);
        assertSame(cellarExits.get("W"), RoomType.DINING_ROOM);
    }

    @Test
    public void builder_when() {
        GameMap gameMap = new GameMap.Builder()
                .createRoom(RoomType.LIBRARY)
                .addExit("S", RoomType.BALLROOM)
                .addExit("E", RoomType.BEDROOM)
                .nextRoom(RoomType.BALLROOM)
                .addExit("N", RoomType.LIBRARY)
                .addExit("E", RoomType.BEDROOM)
                .nextRoom(RoomType.BEDROOM)
                .addExit("N", RoomType.LIBRARY)
                .addExit("S", RoomType.BALLROOM)
                .build();
    }
}