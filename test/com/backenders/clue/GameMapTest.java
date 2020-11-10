package com.backenders.clue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameMapTest {
    GameMap gameMap = new GameMap();

    @Test
    void setRoom() {
        gameMap.setRoom(RoomType.KITCHEN, new Exit("N", RoomType.LIBRARY), new Exit("E", RoomType.BALLROOM));
    }

    @Test
    void getExits() {
    }
}