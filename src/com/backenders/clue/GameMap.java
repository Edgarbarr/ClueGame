package com.backenders.clue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class GameMap {
    private Map<RoomType, Map<String, RoomType>> gameMap;

    public GameMap() {
        gameMap = new HashMap<>();
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
    Map getExits(RoomType room) {
        return gameMap.get(room);
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
