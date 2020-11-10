package com.backenders.clue;

public class Exit {
    private String direction;
    private RoomType room;

    public Exit(String direction, RoomType room) {
        this.direction = direction;
        this.room = room;
    }
    String getDirection() {
        return direction;
    }
    RoomType getRoom() {
        return room;
    }
}
