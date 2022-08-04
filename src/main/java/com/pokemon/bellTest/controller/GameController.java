package com.pokemon.bellTest.controller;

import com.pokemon.bellTest.exception.InvalidGameException;
import com.pokemon.bellTest.exception.InvalidParamException;
import com.pokemon.bellTest.exception.NotFoundException;
import com.pokemon.bellTest.game.Game;
import com.pokemon.bellTest.game.Gameplay;
import com.pokemon.bellTest.game.Player;
import com.pokemon.bellTest.model.DemoandeConetion;
import com.pokemon.bellTest.model.PokemonDto;
import com.pokemon.bellTest.model.Results;
import com.pokemon.bellTest.service.GameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@Slf4j
@RequestMapping("/pokemon")
public class GameController {



    private GameService gameService;


    public GameController( GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/start/{player}")
    public ResponseEntity<Game> init(@RequestBody Player player) throws IOException {
        // log.info("start game request: {}", player);
        return ResponseEntity.ok(gameService.newGame(player));
    }
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Results findByPokemon() {
        //log.info("Searching Pokemons ");
        return null;

    }

    @PostMapping("/connect")
    public ResponseEntity<Game> connectToGame(@RequestBody DemoandeConetion request) throws InvalidParamException, InvalidGameException {
        //log.info("connect request: {}", request);
        return ResponseEntity.ok(gameService.connectToGame(request.getPlayer(), request.getGameId()));
    }
    @RequestMapping(value="/{name}", method=RequestMethod.POST)
    public ResponseEntity<PokemonDto> getPokemon(@PathVariable("name") String name){
        System.out.println("Estoui aqui nbiojofifnn 123456");
        return ResponseEntity.ok(gameService.getPokemon(name));
    }

    @PostMapping("/connectToRandomGame")
    public ResponseEntity<Game> connectToRandomGame(@RequestBody Player player2) throws InvalidParamException, InvalidGameException, NotFoundException {
        //log.info("connect request: {}", request);
        return ResponseEntity.ok(gameService.connectToRandomGame(player2));
    }

    @PostMapping("/gameplay")
    public ResponseEntity<Game> gamePlay(@RequestBody Gameplay request) throws NotFoundException, InvalidGameException {
       // log.info("gameplay: {}", request);
        Game game = gameService.gamePlay(request);
        return ResponseEntity.ok(game);
    }

}
