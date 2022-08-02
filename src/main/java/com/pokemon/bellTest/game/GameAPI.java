package com.pokemon.bellTest.game;

import com.pokemon.bellTest.exception.InvalidGameException;
import com.pokemon.bellTest.exception.InvalidParamException;
import com.pokemon.bellTest.exception.NotFoundException;
import com.pokemon.bellTest.game.Game;
import com.pokemon.bellTest.game.Gameplay;
import com.pokemon.bellTest.game.Player;
import com.pokemon.bellTest.model.ListOfPokemonDto;
import com.pokemon.bellTest.model.PokemonDto;
import reactor.core.publisher.Flux;

import java.util.Set;


public interface GameAPI {

    public Game connectToGame(Player player2, String gameId) throws InvalidParamException, InvalidGameException;
    public Game connectToRandomGame(Player player2) throws NotFoundException;
    public Game gamePlay(Gameplay gamePlay);
    public Boolean checkWinner(int[][] board, PokemonDto pokemon);
    public Flux<ListOfPokemonDto> getPokemon();

}
