package com.backenders.clue;

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

    private Weapon(String name) {
        this.regName = name;
    }

    @Override
    public String toString() {
        return regName;
    }
}
