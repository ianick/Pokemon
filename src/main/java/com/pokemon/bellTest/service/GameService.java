package com.pokemon.bellTest.service;

import com.pokemon.bellTest.model.PokemonResponse;
import com.pokemon.bellTest.exception.InvalidGameException;
import com.pokemon.bellTest.exception.InvalidParamException;
import com.pokemon.bellTest.exception.NotFoundException;
import com.pokemon.bellTest.game.*;
import com.pokemon.bellTest.model.Results;
import com.pokemon.bellTest.model.PokemonDto;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

@Component
public class GameService implements GameAPI {
    public Results listOfPokemonDtosResult;
    private PokemonDto pokemonDto;
    private Set<PokemonDto> pokemonDtos;
    public GameService() throws IOException {

        Set<PokemonDto> resList=new HashSet<>();
       PokemonResponse pokemonResponse=new PokemonResponse();
       PokemonResponse response=  pokemonResponse.getlistPokemonDto("https://pokeapi.co/api/v2/pokemon?limit=50&offset=0");

        Set<PokemonDto> copy = new HashSet<>(response.getResults());

       pokemonDtos = (pokemonResponse.getlistPokemonDtoWithPokemonDetails(copy)); ;
    }

    public static boolean exists(String gameId) {
        return false;
    }


    public Set<PokemonDto> getListPokemon() {
        return pokemonDtos;
    }

    @Override
    public PokemonDto getPokemon(String name) {
        if(name==null){return null;}

        PokemonDto pokemonDto1 = pokemonDtos
                .stream()
                .filter(pokemonDto2 -> pokemonDto2.getName().equals(name))
                .findFirst()
                .orElse(null);
        return pokemonDto1;
    }

    @Override
    public Game newGame(Player player) {

        Game game=Game
                .builder()
                .player1(player)
                .status(GameStatus.START)
                .gameId(UUID.randomUUID().toString())
                .listAllPokemon(pokemonDtos)
                .build();

        Storage.getInstance().setGame(game);


        return game;
    }


    @Override
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
    @Override
    public Game connectToRandomGame(Player player2) throws NotFoundException {
        Game game = Storage.getInstance().getGames().values().stream()
                .filter(it -> it.getStatus().equals(GameStatus.START))
                .findFirst().orElseThrow(() -> new NotFoundException("Game not found"));
        game.setPlayer2(player2);
        game.setStatus(GameStatus.IN_PROGRESS);
        Storage.getInstance().setGame(game);
        return game;
    }
    @Override
    public Game gamePlay(Gameplay gamePlay)  {

        return null;
    }

    public Boolean checkWinner( PokemonDto pokemon) {

        return false;
    }



}
