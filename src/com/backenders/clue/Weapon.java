package com.backenders.clue;

import java.util.stream.Stream;

public enum Weapon {//NEED 10 CREATIVE WEAPONS
    RIB_EYE("Rib Eye"),
    DAGGER("Dagger"),
    CANDLESTICK("Candlestick"),
    REVOLVER("Revolver"),
    LEAD_PIPE("Lead Pipe"),
    WRENCH("Wrench"),
    ROCKET_LAUNCHER("Rocket Launcher"),
    SPOON("Spoon"),
    CLAYMORE("Claymore"),
    BANANA("Banana");

    private String regName;

    Weapon(String name) {
        this.regName = name;
    }

    static Stream<Weapon> wList() {
        return Stream.of(Weapon.values());
    }

    public static void printWeaponList() {
        Weapon.wList()
                .forEach(System.out::println);
    }

    @Override
    public String toString() {
                        return Color.MAGENTA + regName + Color.RESET;
    }
}
