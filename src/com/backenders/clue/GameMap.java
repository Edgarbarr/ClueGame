package com.backenders.clue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class GameMap {
    private Map<RoomType, Map<String, RoomType>> gameMap;

    public GameMap() {
        gameMap = new HashMap<>();
        createGameMap();
    }
    public void setRoom(RoomType room, Exit ...exits) {
        Map<String, RoomType> exitsMap = new HashMap<>();
        Arrays.stream(exits)
                .sequential()
                .forEach(exit -> {
                    if(exit.getRoom() == room) throw new RoomExitIsItselfException(room + " exit at " + exit.getDirection() + " cannot be " + exit.getRoom());
                    exitsMap.put(exit.getDirection(),exit.getRoom());
                });
        gameMap.put(room, exitsMap);
    }
    public void setExit(String direction, RoomType room) {

    }

    Map getExits(RoomType room) {
        return gameMap.get(room);
    }
    private void createGameMap() {
        setRoom(RoomType.KITCHEN, new Exit("N", RoomType.LIBRARY), new Exit("E", RoomType.BALLROOM));
        setRoom(RoomType.BALLROOM, new Exit("N", RoomType.DINING_ROOM), new Exit("W", RoomType.KITCHEN), new Exit("E", RoomType.BILLIARD_ROOM));
        setRoom(RoomType.BILLIARD_ROOM, new Exit("N", RoomType.BEDROOM), new Exit("W", RoomType.BALLROOM));
        setRoom(RoomType.LIBRARY, new Exit("S", RoomType.KITCHEN), new Exit("N", RoomType.LOUNGE), new Exit("SE", RoomType.BEDROOM), new Exit("NE", RoomType.HALL));
        setRoom(RoomType.BEDROOM, new Exit("N",RoomType.HALL), new Exit("S", RoomType.BILLIARD_ROOM), new Exit("W", RoomType.LIBRARY));
        setRoom(RoomType.HALL, new Exit("S", RoomType.BEDROOM), new Exit("N", RoomType.CELLAR), new Exit("W", RoomType.LIBRARY));
        setRoom(RoomType.LOUNGE, new Exit("E", RoomType.DINING_ROOM), new Exit("S", RoomType.LIBRARY));
        setRoom(RoomType.DINING_ROOM, new Exit("S", RoomType.BALLROOM), new Exit("W", RoomType.LOUNGE), new Exit("E", RoomType.CELLAR));
        setRoom(RoomType.CELLAR, new Exit("S", RoomType.HALL), new Exit("W", RoomType.DINING_ROOM));
    }
    private void createExits() {

    }


    //    void printMap() {
//        Formatter map = new Formatter();
//        map.format("#################################################\n");
//        map.format("#               #               #               #\n");
//        map.format("#               #               #               #\n");
//        map.format("#%15s"+"#%15s"+"#%15s#\n", Room.values()[6], Room.values()[7], Room.values()[8]);
//        map.format("#               #               #               #\n");
//        map.format("#               #               #               #\n");
//        map.format("#################################################\n");
//        map.format("#               #               #               #\n");
//        map.format("#               #               #               #\n");
//        map.format("#%15s"+"#     CLUE      #################\n", Room.values()[3]);
//        map.format("#               #               #               #\n");
//        map.format("#               #               #               #\n");
//        map.format("#################################################\n");
//        map.format("#               #               #               #\n");
//        map.format("#               #               #               #\n");
//        map.format("#%15s"+"#%15s"+"#%15s#\n", Room.values()[0], Room.values()[1], Room.values()[2]);
//        map.format("#               #               #               #\n");
//        map.format("#               #               #               #\n");
//        map.format("#################################################\n");
//        System.out.println(map);
//
//
//
//    }
}
