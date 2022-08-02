package com.pokemon.bellTest.controller;

import com.pokemon.bellTest.model.ListOfPokemonDto;
import com.pokemon.bellTest.model.PokemonDto;
import com.pokemon.bellTest.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.Set;


@RestController
@AllArgsConstructor
public class GameController {

    GameService gameService;

    @RequestMapping("/start")
    @ResponseStatus(HttpStatus.OK)
    public Flux<ListOfPokemonDto> findByPokemon( ) {
        return gameService.getPokemon();

    }
}
