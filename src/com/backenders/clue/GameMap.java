package com.backenders.clue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class GameMap {
    final Map<RoomType, Map<String, RoomType>> gameMap;

    private GameMap(Builder builder) {
        gameMap = builder.gameMap;
    }

    public Map<String, RoomType> getExits(RoomType roomType) {
        return gameMap.get(roomType);
    }

    public static class Builder {
        private final Map<RoomType, Map<String, RoomType>> gameMap;
        private final List<Room> roomList = new ArrayList<>();

        public Builder() {
            gameMap = new HashMap<>();
        }

        class Exit {
            String direction;
            RoomType roomType;

            Exit(String direction, RoomType roomType) {
                this.direction = direction;
                this.roomType = roomType;
            }
        }

        class Room {
            RoomType type;
            List<Exit> exitList = new ArrayList<>();
            private final Builder builder;

            Room(RoomType type, Builder builder) {
                this.type = type;
                this.builder = builder;
            }

            Room addExit(String direction, RoomType room) {
                exitList.add(new Exit(direction, room));
                return this;
            }

            Room nextRoom(RoomType room) {
                return builder.createRoom(room);
            }

            GameMap build() {
                return builder.build();
            }
        }

        public Room createRoom(RoomType type) {
            Room newRoom = new Room(type, this);
            roomList.add(newRoom);
            return newRoom;
        }

        public GameMap build() {
            roomList.forEach(room -> {
                Map<String, RoomType> exitsMap = new HashMap<>();
                room.exitList.forEach(exit -> {
                    if (exit.roomType == room.type)
                        throw new RoomExitIsItselfException(room.type + " exit at " + exit.direction + " is " + exit.roomType);
                    exitsMap.put(exit.direction, exit.roomType);
                });
                gameMap.put(room.type, exitsMap);
            });
            return new GameMap(this);
        }

        public Builder generateStandardMap() {
            this.createRoom(RoomType.KITCHEN)
                    .addExit("N", RoomType.LIBRARY)
                    .addExit("E", RoomType.BALLROOM)

                    .nextRoom(RoomType.BALLROOM)
                    .addExit("N", RoomType.DINING_ROOM)
                    .addExit("E", RoomType.BILLIARD_ROOM)
                    .addExit("W", RoomType.KITCHEN)

                    .nextRoom(RoomType.BILLIARD_ROOM)
                    .addExit("N", RoomType.BEDROOM)
                    .addExit("W", RoomType.BALLROOM)

                    .nextRoom(RoomType.LIBRARY)
                    .addExit("N", RoomType.LOUNGE)
                    .addExit("NE", RoomType.HALL)
                    .addExit("SE", RoomType.BEDROOM)
                    .addExit("S", RoomType.KITCHEN)

                    .nextRoom(RoomType.BEDROOM)
                    .addExit("N", RoomType.HALL)
                    .addExit("S", RoomType.BILLIARD_ROOM)
                    .addExit("W", RoomType.LIBRARY)

                    .nextRoom(RoomType.HALL)
                    .addExit("N", RoomType.CELLAR)
                    .addExit("S", RoomType.BEDROOM)
                    .addExit("W", RoomType.LIBRARY)

                    .nextRoom(RoomType.LOUNGE)
                    .addExit("E", RoomType.DINING_ROOM)
                    .addExit("S", RoomType.LIBRARY)

                    .nextRoom(RoomType.DINING_ROOM)
                    .addExit("E", RoomType.CELLAR)
                    .addExit("S", RoomType.BALLROOM)
                    .addExit("W", RoomType.LOUNGE)

                    .nextRoom(RoomType.CELLAR)
                    .addExit("S", RoomType.HALL)
                    .addExit("W", RoomType.DINING_ROOM);
            return this;
        }
    }

}
