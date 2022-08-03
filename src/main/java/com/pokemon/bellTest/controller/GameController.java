package com.pokemon.bellTest.controller;

import com.pokemon.bellTest.exception.InvalidGameException;
import com.pokemon.bellTest.exception.InvalidParamException;
import com.pokemon.bellTest.exception.NotFoundException;
import com.pokemon.bellTest.game.Game;
import com.pokemon.bellTest.game.GameAPI;
import com.pokemon.bellTest.game.Gameplay;
import com.pokemon.bellTest.game.Player;
import com.pokemon.bellTest.model.DemoandeConetion;
import com.pokemon.bellTest.model.Results;
import com.pokemon.bellTest.service.GameService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/pokemon")
public class GameController {



    @Autowired
    private GameAPI gameAPI;

    private GameService gameService;
    @PostMapping("/start/{player}")
    public ResponseEntity<Game> init(@RequestBody Player player) {
        // log.info("start game request: {}", player);
        return ResponseEntity.ok(gameService.newGame(player));
    }
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Results findByPokemon(@RequestParam(value = "limit") long limit,
                                       @RequestParam(value = "offset") long offset) {
        //log.info("Searching Pokemons ");
        return gameService.getPokemon(gameAPI.getPokemon(limit,offset));

    }

    @PostMapping("/connect")
    public ResponseEntity<Game> connect(@RequestBody DemoandeConetion request) throws InvalidParamException, InvalidGameException {
        //log.info("connect request: {}", request);
        return ResponseEntity.ok(gameService.connectToGame(request.getPlayer(), request.getGameId()));
    }

    @PostMapping("/gameplay")
    public ResponseEntity<Game> gamePlay(@RequestBody Gameplay request) throws NotFoundException, InvalidGameException {
       // log.info("gameplay: {}", request);
        Game game = gameService.gamePlay(request);
        return ResponseEntity.ok(game);
    }

}
