package com.pokemon.bellTest.game;

import com.pokemon.bellTest.exception.InvalidGameException;
import com.pokemon.bellTest.exception.InvalidParamException;
import com.pokemon.bellTest.exception.NotFoundException;
import com.pokemon.bellTest.model.PokemonDto;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


public interface GameAPI {

    @PostMapping("/start/{player}")
    public Game newGame(Player player) throws IOException;
    @PostMapping("/connect")
    public Game connectToGame(@RequestBody Player player2,@RequestParam String gameId) throws InvalidParamException, InvalidGameException;
    @PostMapping("/connectToRandomGame")
    public Game connectToRandomGame(@RequestBody Player player2) throws NotFoundException;

    @PostMapping("/gameplay")
    public Game gamePlay(@RequestBody Gameplay request) throws NotFoundException, InvalidGameException;
    @RequestMapping(value="/{name}", method=RequestMethod.POST)
    public PokemonDto getPokemon(@PathVariable("name") String name);
}
