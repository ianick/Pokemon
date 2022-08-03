package com.pokemon.bellTest.game;

import com.pokemon.bellTest.model.PokemonDto;
import com.pokemon.bellTest.model.Results;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "pokemonFeignClient", url = "https://pokeapi.co/api/v2")
public interface GameAPI {

    @RequestMapping(method=RequestMethod.GET)
    public Results getPokemon(@RequestParam(value = "limit") Long limit, @RequestParam(value = "offset") long offset);

    @GetMapping("/{name}")
    public PokemonDto getPokemon(@PathVariable("name") String name);
}
