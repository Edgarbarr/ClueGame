package com.backenders.clue;

import java.io.IOException;

public class ClueClient {

    // Kicks off the Clue Game
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.start();
    }
}
