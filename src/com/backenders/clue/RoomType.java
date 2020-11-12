package com.backenders.clue;

import java.util.stream.Stream;

public enum RoomType {

    KITCHEN("Kitchen", "A large chef's kitchen, filled with knives, heavy pots, and delicious smells."),
    BALLROOM("Ballroom", "Sliding and gliding on hardwood waxed floors, a place fit for Fred and Ginger"),
    BILLIARD_ROOM("Billiard", "The sound of the cue ball smacking the eight-ball. The smell of chalk. And you see two beautiful green felt tables are in the center of the room"),
    LIBRARY("Library", "shh, books from floor to ceiling, easy chairs and read light abound"),
    BEDROOM("Bedroom", "King size bed, mirrors, a fluffy rug, and an alarm clock."),
    HALL("Hall", "Connects to all the rooms. There is an umbrella stand by the main entry."),
    LOUNGE("Lounge", "Comfy chairs, people lounging and chatting"),
    DINING_ROOM("Dining Room", "A large table filled with dirty dishes and remanents of the meal. Is a butter knife missing?"),
    CELLAR("Cellar", "Well stocked with aging and drink now wines, Scotts Whisky, Carribean Rum, and top shelf Tequila"),
    SHOWER_ROOM("Shower Room", "All good murders happen in the shower. Would you like to linger for one?");

    private String roomDescription;
    private String roomName;

    RoomType(String roomName, String roomDescription) {
        this.roomName = roomName;
        this.roomDescription = roomDescription;
    }

    static Stream<RoomType> rooList() {
        return Stream.of(RoomType.values());
    }

    public static void printRooms() {
        RoomType.rooList()
                .map(RoomType::getRoomName)
                .forEach(System.out::println);
    }

    public String getRoomDescription() {
        return "\u001B[36m" + roomDescription + "\u001B[32m";
    }

    public String getRoomName() {
        return Color.BLUE + roomName + Color.RESET;
    }


}

