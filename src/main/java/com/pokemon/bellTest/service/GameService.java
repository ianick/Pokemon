package com.pokemon.bellTest.service;

import com.pokemon.bellTest.exception.InvalidGameException;
import com.pokemon.bellTest.exception.InvalidParamException;
import com.pokemon.bellTest.exception.NotFoundException;
import com.pokemon.bellTest.game.Game;
import com.pokemon.bellTest.game.GameStatus;
import com.pokemon.bellTest.game.Gameplay;
import com.pokemon.bellTest.game.Player;
import com.pokemon.bellTest.model.Results;
import com.pokemon.bellTest.model.PokemonDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@Slf4j
public class GameService {

    public Results listOfPokemonDtosResult;



    @Value("${myrest.url}")
    private final static String URL_BASE="https://pokeapi.co/api/v2/pokemon";
   // private final WebClient webClient;

    private PokemonDto pokemonDto;
    private Set<PokemonDto> listPokemonDtos;
    public GameService() {
    }

    public static boolean exists(String gameId) {
        return false;
    }

    public Game newGame(Player player){
        Game game=Game
                .builder()
                .player1(player)
                .status(GameStatus.START)
                .gameId(UUID.randomUUID().toString())
                .build();

        Storage.getInstance().setGame(game);
        return game;
    }
    public Results getPokemon( Results listOfPokemonDtosResult) {
        log.info("Searching Pokemons ");
        return null;
    }

    public PokemonDto getPokemon(String name) {

        return this.getPokemon(name);
    }

    public Game connectToGame(Player player2, String gameId) throws InvalidParamException, InvalidGameException {
        if (!Storage.getInstance().getGames().containsKey(gameId)) {
            throw new InvalidParamException("Game with provided id doesn't exist");
        }
        Game game = Storage.getInstance().getGames().get(gameId);

        if (game.getPlayer2() != null) {
            throw new InvalidGameException("Game is not valid anymore");
        }

        game.setPlayer2(player2);
        game.setStatus(GameStatus.IN_PROGRESS);
        Storage.getInstance().setGame(game);
        return game;
    }
    public Game connectToRandomGame(Player player2) throws NotFoundException {
        Game game = Storage.getInstance().getGames().values().stream()
                .filter(it -> it.getStatus().equals(GameStatus.START))
                .findFirst().orElseThrow(() -> new NotFoundException("Game not found"));
        game.setPlayer2(player2);
        game.setStatus(GameStatus.IN_PROGRESS);
        Storage.getInstance().setGame(game);
        return game;
    }
    public Game gamePlay(Gameplay gamePlay)  {

        return null;
    }
    public Boolean checkWinner( PokemonDto pokemon) {

        return false;
    }


}
