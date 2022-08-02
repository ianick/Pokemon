package com.pokemon.bellTest.service;

import com.pokemon.bellTest.Client.PokemonClient;
import com.pokemon.bellTest.game.GameAPI;
import com.pokemon.bellTest.exception.InvalidGameException;
import com.pokemon.bellTest.exception.InvalidParamException;
import com.pokemon.bellTest.exception.NotFoundException;
import com.pokemon.bellTest.game.Game;
import com.pokemon.bellTest.game.GameStatus;
import com.pokemon.bellTest.game.Gameplay;
import com.pokemon.bellTest.game.Player;
import com.pokemon.bellTest.model.ListOfPokemonDto;
import com.pokemon.bellTest.model.PokemonDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
@Slf4j
public class GameService implements GameAPI {

    public Set<ListOfPokemonDto> listOfPokemonDtos;
    @Value("${myrest.url}")
    private final static String URL_BASE="https://pokeapi.co/api/v2/pokemon?limit=100000&offset=0";
    private final WebClient webClient;

    private PokemonClient pokemonClient;

    public GameService(WebClient.Builder builder) {
        webClient = builder
                .baseUrl(URL_BASE)
                .build();
    }

    public Game newGame(Player player){

        Game game=Game
                .builder()
                .player1(player)
                .board(new int[10][10])
                .status(GameStatus.START)
                .gameId(UUID.randomUUID().toString())
                .build();

        Storage.getInstance().setGame(game);
        return game;
    }
    @Override
    public Flux<ListOfPokemonDto> getPokemon() {
        log.info("Searching Pokemons ");
        return webClient.get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("check the parameters")))
                .bodyToFlux(ListOfPokemonDto.class);

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
    @Override
    public Boolean checkWinner(int[][] board, PokemonDto pokemon) {

        return false;
    }


}
