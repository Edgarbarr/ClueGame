package com.backenders.clue;

import java.util.EnumSet;
import java.util.stream.Stream;

public enum RolePlayer {
    // Do we want to add an index number to each enum? It might make storing these easier?
    // and would make guessing easier. Player would only have to enter a number not a name
    GURU_JAY("Guru Jay", "All-knowing, extremely patient expert of all things Java. Just listen and heed."),
    MRS_PEACOCK("Mrs. Peacock", "Flamboyant and friendly. She likes to be the center of attention."),
    MRS_ORCHID("Mrs. Orchid", "Gentle and sensitive but bold. Watch for her reaction."),
    COLONEL_MUSTARD("Colonel Mustard", "Sharp and stern. He expects you to do what he orders."),
    MR_GREEN("Mr. Green", "Environmentally conscious and knowledgeable. He will have a better method."),
    LIEUTENANT_DAN("Lieutenant Dan", "Courageous and curious. He is worldly and confident."),
    MISS_SCARLET("Miss Scarlet", "Deceptively quiet and sweet. You don't realize her strength."),
    CAPTAIN_CANDACE("Captain Candace", "Brave, thoughtful leader. Look to her for insight AND direction."),
    PROFESSOR_EDGAR("Professor Edgar", "Intelligent, creative and soft-spoken. Rockstar of code review. His instruction is invaluable."),
    GEMOLOGIST_GINA("Gemologist Gina", "Curious and a little odd. She can spot a fake.");

    protected static EnumSet<RolePlayer> rolePlayers;

    private String charDescription;
    private String rpName;

    // Constructor
    RolePlayer(String rpName, String charDescription) {
        this.rpName = rpName;
        this.charDescription = charDescription;
    }

    static Stream<RolePlayer> rpList() {
        return Stream.of(RolePlayer.values());
    }

    public void printRolePlayerList(Stream<RolePlayer> rpList) {
        RolePlayer.rpList()
                .forEach(RolePlayer -> System.out.println(rpName + " " + charDescription));

        // Or we can use an EnumSet because it is supposed to be faster
        // and better than a map....
//        EnumSet.allOf(RolePlayer.class)
//                .forEach(System.out::println);
    }

    static EnumSet<RolePlayer> printRolePlayers() {
        EnumSet<RolePlayer> rpList = EnumSet.allOf(RolePlayer.class);
        System.out.println(rpList);
        return rpList;
    }

    // Accessor Methods
    public String getCharDescription() {
        return charDescription;
    }

    public String getRpName() {
        return rpName;
    }

}
