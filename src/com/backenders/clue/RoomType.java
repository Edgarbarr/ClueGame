package com.backenders.clue;

public enum RoomType {

    KITCHEN("A large chef's kitchen, filled with knives, heavy pots, and delicious smells."),
    BALLROOM("Sliding and gliding on hardwood waxed floors, a place fit for Fred and Ginger"),
    BILLIARD_ROOM("The sound of the cue ball smacking the eight-ball. The smell of chalk. And you see two beautiful green felt tables are in the center of the room"),
    LIBRARY("shh, books from floor to ceiling, easy chairs and read light abound"),
    BEDROOM("King size bed, mirrors, a fluffy rug, and an alarm clock."),
    HALL("Connects to all the rooms. There is an umbrella stand by the main entry."),
    LOUNGE("Comfy chairs, people lounging and chatting"),
    DINING_ROOM("A large table filled with dirty dishes and remanents of the meal. Is a butter knife missing?"),
    CELLAR("Well stocked with aging and drink now wines, Scotts Whisky, Carribean Rum, and top shelf Tequila");
//    SHOWER_ROOM("All good murders happen in the shower. Would you like to linger for one?");

    private final String name;

    RoomType(String name) {
        this.name = name;
    }


    public String toString() {
        return this.name;



    }
    String getDescription() {
        return "\u001B[36m" + name + "\u001B[32m";

    }

}

