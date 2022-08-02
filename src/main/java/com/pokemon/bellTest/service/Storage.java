package com.pokemon.bellTest.service;

import com.pokemon.bellTest.game.Game;

import java.util.HashMap;
import java.util.Map;
public class Storage {

    private Map<String, Game> games;

    private static Storage instance;

    private Storage(){
        games = new HashMap<>();
    }

    public static synchronized  Storage getInstance(){
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public Map<String, Game> getGames() {
        return games;
    }

    public void setGame(Game game) {
        games.put(game.getGameId(), game);
    }

}
